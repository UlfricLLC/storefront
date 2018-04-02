package com.ulfric.storefront.vaadin.button;

import com.vaadin.flow.dom.ThemeList;

public class FriendlyButton extends CourierButton {

	public FriendlyButton() {
		ThemeList themes = getElement().getThemeList();
		themes.add("primary");
		//themes.add("success");
	}

}
