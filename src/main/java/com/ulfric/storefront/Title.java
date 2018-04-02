package com.ulfric.storefront;

import com.ulfric.storefront.model.Webstore;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class Title extends H3 {

	public Title(Webstore webstore) {
		super(webstore.getName());
		addClassName("courier");
	}

}
