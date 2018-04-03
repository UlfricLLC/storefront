package com.ulfric.storefront.frontend.component;

import com.ulfric.storefront.vaadin.button.ComplementaryButton;
import com.ulfric.storefront.vaadin.button.PrimaryButton;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcons;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class HeaderButtons extends HorizontalLayout {

	public HeaderButtons() {
		setMargin(false);
		setPadding(false);
		setJustifyContentMode(JustifyContentMode.END);
		setAlignItems(Alignment.END);

		Button login = new ComplementaryButton();
		login.setText("Login");
		login.getElement().getThemeList().add("contrast");
		login.getElement().getThemeList().add("tertiary");

		login.addClickListener(click -> {
			TextField username = new TextField();
			username.setPlaceholder("Username");
			Button go = new Button(new Icon(VaadinIcons.CHEVRON_RIGHT));
			go.getElement().getThemeList().add("small");
			go.getElement().getThemeList().add("contrast");
			go.getElement().getThemeList().add("tertiary");
			go.addClassName("pointer");
			go.addClickListener(click2 -> replace(username, login));
			username.setSuffixComponent(go);
			replace(login, username);
		});

		Button checkout = new PrimaryButton();
		checkout.setWidth("100%");
		checkout.setText("Checkout");

		add(login, checkout);
	}

}
