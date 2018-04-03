package com.ulfric.storefront.vaadin.button;

import com.vaadin.flow.dom.ThemeList;

public class SecondaryContrastButton extends SecondaryButton {

	public SecondaryContrastButton() {
		ThemeList themes = getElement().getThemeList();
		themes.add("contrast");
	}

}
