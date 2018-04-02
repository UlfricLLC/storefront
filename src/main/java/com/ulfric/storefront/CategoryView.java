package com.ulfric.storefront;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.util.CollectionUtils;

import com.ulfric.storefront.model.Category;
import com.ulfric.storefront.model.Item;
import com.ulfric.storefront.model.Webstore;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;

@Route(value = "category", layout = ContentDisplay.class)
@SpringComponent
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CategoryView extends View implements HasUrlParameter<String> {

	private final Webstore webstore;
	private final ContentDisplay display;

	public CategoryView(Webstore webstore, ContentDisplay display) {
		this.webstore = webstore;
		this.display = display;
	}

	@Override
	public void setParameter(BeforeEvent event, String parameter) {
		display.getNavBar().select(parameter);
		Category category = findCategory(parameter);
		display.setTitle(category == null ? "Packages" : category.getName());
		display.setPage(new Text("SOME STUFF IS HERE"));
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

}
