package com.ulfric.storefront.model;

import java.util.List;

import com.ulfric.storefront.element.ElementFunction;
import com.ulfric.storefront.element.StandardElements;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;

public class Described extends DisplayNamed {

	public static Div render(List<Element> elements) {
		Div container = new Div();
		elements.stream().map(Described::render).forEach(container::add);
		return container;
	}

	public static Component render(Element element) {
		ElementFunction function = StandardElements.standardized(element.getType());
		if (function == null) {
			throw new UnsupportedOperationException("Unimplemented standard element type " + element.getType());
		}

		return function.apply(element);
	}

	private List<Element> description;

	public List<Element> getDescription() {
		return description;
	}

	public void setDescription(List<Element> description) {
		this.description = description;
	}

}
