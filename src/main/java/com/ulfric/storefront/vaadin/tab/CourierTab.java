package com.ulfric.storefront.vaadin.tab;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.tabs.Tab;

public class CourierTab extends Tab {

	public CourierTab(Component... components) {
		super(components);

		addClassName("big-tab");
		addClassName("courier");
	}

}
