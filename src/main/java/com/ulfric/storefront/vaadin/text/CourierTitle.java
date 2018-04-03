package com.ulfric.storefront.vaadin.text;

import com.vaadin.flow.component.html.H3;

public class CourierTitle extends H3 {

	public CourierTitle(String title) {
		super(title);

		addClassName("courier");
	}

}
