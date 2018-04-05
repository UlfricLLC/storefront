package com.ulfric.storefront.widget;

import java.util.Objects;

import com.ulfric.storefront.model.Described;
import com.ulfric.storefront.model.Element;
import com.ulfric.storefront.vaadin.container.Container;

public class Widget {

	protected final Element element;

	public Widget(Element element) {
		Objects.requireNonNull(element, "element");

		this.element = element;
	}

	public final Container render() {
		Container container = new Container(element.getName(), Described.render(element));

		return container;
	}

}
