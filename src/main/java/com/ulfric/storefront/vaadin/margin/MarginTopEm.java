package com.ulfric.storefront.vaadin.margin;

import com.vaadin.flow.component.html.Div;

public class MarginTopEm extends Div {

	public MarginTopEm(int size) {
		getStyle().set("margin-top", size + "em");
	}

}
