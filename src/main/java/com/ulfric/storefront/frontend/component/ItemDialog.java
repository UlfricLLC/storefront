package com.ulfric.storefront.frontend.component;

import java.util.UUID;

import com.ulfric.storefront.model.Item;
import com.ulfric.storefront.vaadin.button.ContrastButton;
import com.ulfric.storefront.vaadin.button.SecondaryContrastButton;
import com.ulfric.storefront.vaadin.dialog.DialogLayout;
import com.ulfric.storefront.vaadin.dialog.StorefrontDialog;
import com.ulfric.storefront.vaadin.margin.Line;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcons;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class ItemDialog extends Composite<StorefrontDialog> {

	public ItemDialog(Item item) {
		VerticalLayout layout = new DialogLayout();

		//layout.add(new CourierTitle(item.getName()));

		Div sublayout = new Div();
		sublayout.setSizeFull();
		sublayout.getStyle().set("max-height", "60vh");
		sublayout.getStyle().set("maxHeight", "60vh");
		sublayout.getStyle().set("overflow", "auto");
		sublayout.add(new Label(v()));
		//layout.add(sublayout);

		Div buttons = new Div();
		buttons.setSizeFull();

		HorizontalLayout purchaseRow = new HorizontalLayout();
		purchaseRow.setWidth("100%");
		purchaseRow.getStyle().set("flex-direction", "row");
		purchaseRow.getStyle().set("flex-wrap", "wrap-reverse");
		purchaseRow.setJustifyContentMode(JustifyContentMode.START);
		purchaseRow.setAlignItems(Alignment.START);

		Button addToCart = new SecondaryContrastButton();
		addToCart.setText("Add to cart");

		Button purchase = new ContrastButton();
		purchase.setText("Buy with one click");

		purchaseRow.add(addToCart, purchase);
		purchaseRow.setFlexGrow(1, addToCart);
		purchaseRow.setFlexGrow(7, purchase);

		buttons.add(purchaseRow);

		HorizontalLayout orRow = new HorizontalLayout();
		orRow.setWidth("100%");

		Label or = new Label("OR");
		or.getStyle().set("text-align", "center");
		orRow.add(new Line(), or, new Line());

		buttons.add(orRow);

		TextField giftUsername = new TextField();
		giftUsername.setWidth("100%");
		giftUsername.setMaxLength(16);
		giftUsername.setPlaceholder("Recipient's Minecraft username");
		HorizontalLayout gifttt = new HorizontalLayout();
		Label buyAsAGift = new Label("BUY AS A GIFT");
		buyAsAGift.getStyle().set("font-weight", "600");
		buyAsAGift.getStyle().set("margin-top", "0.25em");
		gifttt.add(buyAsAGift, new Icon(VaadinIcons.GIFT));
		Button go = new Button(gifttt);
		go.getElement().getThemeList().add("small");
		go.getElement().getThemeList().add("contrast");
		go.getElement().getThemeList().add("tertiary");
		go.addClassName("pointer");
		giftUsername.setSuffixComponent(go);
		buttons.add(giftUsername);

		layout.add(buttons);

		getContent().add(layout);
	}

	private String v() {
		StringBuilder s = new StringBuilder();
		for (int x = 0; x < 1000; x++) {
			s.append(UUID.randomUUID().toString().replace('-', ' '));
			s.append(' ');
		}
		return s.toString();
	}

	public void open() {
		getContent().open();
	}

}
