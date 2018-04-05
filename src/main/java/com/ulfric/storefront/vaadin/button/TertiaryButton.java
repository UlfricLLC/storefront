package com.ulfric.storefront.vaadin.button;

import com.vaadin.flow.dom.ThemeList;

public class TertiaryButton extends CourierButton {

	public TertiaryButton() {
		ThemeList themes = getElement().getThemeList();
		themes.add("tertiary");
		getStyle().set("font-weight", "600");
	}

}
