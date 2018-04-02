package com.ulfric.storefront;

import com.ulfric.storefront.model.Webstore;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.board.Row;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class Header extends Composite<Row> {

	public Header(Webstore webstore, Title title, HeaderButtons headerButtons) {
		getContent().add(title, headerButtons);
	}

}
