package com.ulfric.storefront.vaadin.button;

import com.vaadin.flow.dom.ThemeList;

public class FriendlyButton extends PrimaryButton {

	public FriendlyButton() {
		ThemeList themes = getElement().getThemeList();
		themes.add("success");
	}

}
