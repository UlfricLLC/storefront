package com.ulfric.storefront.frontend.view;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.ulfric.storefront.frontend.component.ItemDialog;
import com.ulfric.storefront.model.Category;
import com.ulfric.storefront.model.Described;
import com.ulfric.storefront.model.Event;
import com.ulfric.storefront.model.Item;
import com.ulfric.storefront.model.PriceOffset;
import com.ulfric.storefront.model.Sale;
import com.ulfric.storefront.model.Session;
import com.ulfric.storefront.model.Webstore;
import com.ulfric.storefront.repositories.SessionRepository;
import com.ulfric.storefront.services.AnalyticsService;
import com.ulfric.storefront.vaadin.button.ContrastButton;
import com.ulfric.storefront.vaadin.margin.MarginTopEm;
import com.ulfric.storefront.vaadin.text.ItemNameText;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.SelectionMode;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;

@Route(value = "category", layout = ContentDisplay.class)
@SpringComponent
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CategoryView extends View implements HasUrlParameter<String> {

	private final Webstore webstore;
	private final Session session;
	private final SessionRepository sessions;
	private final AnalyticsService analytics;
	private final ContentDisplay display;

	public CategoryView(Webstore webstore, Session session, SessionRepository sessions,
			AnalyticsService analytics, ContentDisplay display) {
		this.webstore = webstore;
		this.session = session;
		this.sessions = sessions;
		this.analytics = analytics;
		this.display = display;
	}

	@Override
	public void setParameter(BeforeEvent event, String parameter) {
		display.getNavBar().select(parameter);
		Category category = findCategory(parameter);
		String title = category == null ? "Packages" : category.getName();
		display.setTitle(title);

		Event analyticsEvent = new Event();
		analyticsEvent.setName("visit_category");
		analyticsEvent.getDetails().put("title", title);
		analyticsEvent.getDetails().put("parameter", parameter);
		analytics.record(session.getAnalyticsId(), analyticsEvent);

		Div page = new Div();

		if (!StringUtils.isEmpty(category.getDescription())) {
			page.add(Described.render(category.getDescription()));
			page.add(new MarginTopEm(1));
		}

		Grid<Item> listing = new Grid<>();
		listing.getElement().getThemeList().add("wrap-cell-content");
		listing.setItems(webstore.getItems());
		listing.addColumn(new LabelRenderer(ItemNameText::new, (text, item) -> text.setText(item.getName())));
		listing.addColumn(new Renderer<>(PriceComponent::new, new PriceConfigurer()));
		listing.addColumn(new Renderer<>(ContrastButton::new, (button, item) -> {
			button.setWidth("100%");
			button.setText("More info");
			button.addClickListener(click -> new ItemDialog(title, item, session, sessions, analytics).open());
		}));
		listing.setSelectionMode(SelectionMode.NONE);
		page.add(listing);
		display.setPage(page);
	}

	private Category findCategory(String path) {
		if (CollectionUtils.isEmpty(webstore.getItems())) {
			return null;
		}

		for (Item item : webstore.getItems()) {
			if (CollectionUtils.isEmpty(item.getCategories())) {
				continue;
			}

			for (Category category : item.getCategories()) {
				if (category.getPath() == null) {
					if (path == null) {
						return category;
					}

					continue;
				}

				if (path == null) {
					continue;
				}

				if (category.getPath().equalsIgnoreCase(path)) {
					return category;
				}
			}
		}

		return null;
	}

	private final class PriceConfigurer implements BiConsumer<PriceComponent, Item> {
		@Override
		public void accept(PriceComponent price, Item item) {
			if (!Item.isPositive(item.getPrice())) {
				addFree(price);
				return;
			}

			BigDecimal newPrice = item.getPrice();
			for (Sale sale : webstore.getSales()) {
				if (!Item.isPositive(sale.getAmount())) {
					continue;
				}

				if (BooleanUtils.isTrue(sale.getGlobal())
						|| sale.getItems().contains(item.getName())
						|| sale.getItems().contains(item.getPath())) {
					newPrice = PriceOffset.apply(sale, newPrice);
				}
			}

			if (!Item.isPositive(newPrice)) {
				addFree(price);
				return;
			}

			price.addNormalPrice(item.getPrice());

			if (newPrice.compareTo(item.getPrice()) != 0) {
				price.addSalePrice(newPrice);
			}
		}

		private void addFree(PriceComponent price) {
			price.add(new Label("$0 - Free"));
		}
	}

	private static final class PriceComponent extends HorizontalLayout {
		Label salePrice;
		Label normalPrice;

		public void addSalePrice(BigDecimal salePrice) {
			normalPrice.addClassName("price-discounted-label");
			this.salePrice = format(salePrice);
			add(this.salePrice);
		}

		public void addNormalPrice(BigDecimal normalPrice) {
			this.normalPrice = format(normalPrice);
			add(this.normalPrice);
		}

		private Label format(BigDecimal bigDecimal) {
			Label label = new Label(NumberFormat.getCurrencyInstance(Locale.US).format(bigDecimal));
			label.addClassName("price-label");
			return label;
		}
	}

	private static class LabelRenderer extends Renderer<Label> {
		public LabelRenderer(Supplier<Label> supplier, BiConsumer<Label, Item> consumer) {
			super(supplier, consumer);
		}
	}

	private static class Renderer<T extends Component> extends ComponentRenderer<T, Item> {
		 public Renderer(Supplier<T> supplier, BiConsumer<T, Item> consumer) {
			 super(supplier::get, consumer::accept);
		 }
	}

}
