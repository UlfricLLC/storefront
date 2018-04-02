package com.ulfric.storefront.widget;

import com.ulfric.storefront.model.WidgetDescriptor;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;

public class TextWidget extends Widget {

	public TextWidget(WidgetDescriptor descriptor) {
		super(descriptor);
	}

	@Override
	protected Component contents() {
		return new Text(descriptor.getProperties().get("text").getValue());
	}

}
