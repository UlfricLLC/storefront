package com.ulfric.storefront.vaadin.button;

import com.vaadin.flow.dom.ThemeList;

public class TertiaryContrastButton extends TertiaryButton {

	public TertiaryContrastButton() {
		ThemeList themes = getElement().getThemeList();
		themes.add("contrast");
	}

}
