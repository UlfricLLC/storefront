package com.ulfric.storefront.vaadin.button;

import com.vaadin.flow.dom.ThemeList;

public class ComplementaryButton extends CourierButton {

	public ComplementaryButton() {
		ThemeList themes = getElement().getThemeList();
		themes.add("contrast");
		themes.add("tertiary");
	}

}
