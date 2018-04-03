package com.ulfric.storefront.frontend.component;

import com.ulfric.storefront.model.Webstore;
import com.ulfric.storefront.vaadin.text.CourierTitle;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class Title extends CourierTitle {

	public Title(Webstore webstore) {
		super(webstore.getName());
	}

}
