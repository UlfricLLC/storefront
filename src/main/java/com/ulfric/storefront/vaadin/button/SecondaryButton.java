package com.ulfric.storefront.vaadin.button;

import com.vaadin.flow.dom.ThemeList;

public class SecondaryButton extends CourierButton {

	public SecondaryButton() {
		ThemeList themes = getElement().getThemeList();
		themes.add("secondary");
		getStyle().set("font-weight", "600");
	}

}
