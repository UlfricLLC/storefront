package com.ulfric.storefront.vaadin.button;

import com.vaadin.flow.dom.ThemeList;

public class ContrastButton extends CourierButton {

	public ContrastButton() {
		ThemeList themes = getElement().getThemeList();
		themes.add("primary");
		themes.add("contrast");
	}

}
