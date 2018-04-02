package com.ulfric.storefront.widget;

import java.util.Objects;

import com.ulfric.storefront.model.WidgetDescriptor;
import com.ulfric.storefront.vaadin.container.Container;
import com.vaadin.flow.component.Component;

public abstract class Widget {

	protected final WidgetDescriptor descriptor;

	public Widget(WidgetDescriptor descriptor) {
		Objects.requireNonNull(descriptor, "descriptor");

		this.descriptor = descriptor;
	}

	public final Container render() {
		Container container = new Container(descriptor.getName(), contents());

		return container;
	}

	protected abstract Component contents();

}
