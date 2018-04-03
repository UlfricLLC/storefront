package com.ulfric.storefront.vaadin.text;

import com.vaadin.flow.component.html.Label;

public class CourierText extends Label {

	public CourierText() {
		this(null);
	}

	public CourierText(String text) {
		super(text);

		addClassName("courier");
	}

}
