package com.ulfric.storefront.element;

import com.ulfric.storefront.model.Element;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Label;

public class TextElementFunction implements ElementFunction {

	@Override
	public Component apply(Element element) {
		return new Label(element.getValue());
	}

}
