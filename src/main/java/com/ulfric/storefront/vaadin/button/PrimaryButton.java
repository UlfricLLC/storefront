package com.ulfric.storefront.vaadin.button;

import com.vaadin.flow.dom.ThemeList;

public class PrimaryButton extends CourierButton {

	public PrimaryButton() {
		ThemeList themes = getElement().getThemeList();
		themes.add("primary");
	}

}
