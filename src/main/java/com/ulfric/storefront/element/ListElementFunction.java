package com.ulfric.storefront.element;

import java.util.Map;
import java.util.TreeMap;

import com.ulfric.storefront.model.Described;
import com.ulfric.storefront.model.Element;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.UnorderedList;

public class ListElementFunction implements ElementFunction {

	@Override
	public Component apply(Element element) {
		UnorderedList list = new UnorderedList();
		for (Map.Entry<String, Element> value : new TreeMap<>(element.getValues()).entrySet()) {
			list.add(new ListItem(Described.render(value.getValue())));
		}
		return list;
	}

}
