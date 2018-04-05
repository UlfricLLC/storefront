package com.ulfric.storefront.element;

public enum StandardElements {

	TEXT(new TextElementFunction()),
	LIST(new ListElementFunction());

	public static ElementFunction standardized(String string) {
		try {
			return valueOf(string.trim().toUpperCase()).implementation;
		} catch (Exception exception) {
			return null;
		}
	}

	private final ElementFunction implementation;

	StandardElements(ElementFunction implementation) {
		this.implementation = implementation;
	}

}
