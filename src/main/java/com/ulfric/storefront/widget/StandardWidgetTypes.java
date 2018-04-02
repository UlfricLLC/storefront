package com.ulfric.storefront.widget;

public enum StandardWidgetTypes {

	TEXT(TextWidget.class);

	public static Class<? extends Widget> standardized(String string) {
		try {
			return valueOf(string.trim().toUpperCase()).implementation;
		} catch (Exception exception) {
			return null;
		}
	}

	private final Class<? extends Widget> implementation;

	StandardWidgetTypes(Class<? extends Widget> implementation) {
		this.implementation = implementation;
	}

}
