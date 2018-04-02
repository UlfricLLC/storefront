package com.ulfric.storefront;

import com.ulfric.storefront.vaadin.container.Container;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.ParentLayout;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@ParentLayout(StorefrontView.class)
@SpringComponent
@UIScope
public class ContentDisplay extends Composite<Div> implements RouterLayout {

	private final NavBar navbar;
	private final Container container;

	public ContentDisplay(NavBar navbar, Container container) {
		this.navbar = navbar;
		this.container = container;
	}

	public NavBar getNavBar() {
		return navbar;
	}

	public void setTitle(String title) {
		container.setTitle(title);
	}

	public void setPage(Component component) {
		container.setPage(component);
	}

	public Container getContainer() {
		return container;
	}

}
