package com.ulfric.storefront.frontend.component;

import org.springframework.util.CollectionUtils;

import com.ulfric.storefront.frontend.view.ContentDisplay;
import com.ulfric.storefront.frontend.view.HomeView;
import com.ulfric.storefront.model.Element;
import com.ulfric.storefront.model.Webstore;
import com.ulfric.storefront.vaadin.container.Container;
import com.ulfric.storefront.widget.Widget;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.board.Row;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class Body extends Composite<Row> {

	public Body(ContentDisplay content, Webstore webstore) {
		Row row = getContent();
		row.getStyle().set("margin", "0 -0.5em"); // HACK TO GET SPACING TO WORK
		Container container = content.getContainer();
		container.getContent().getStyle().set("margin", "0 0.5em"); // HACK TO GET SPACING TO WORK
		new HomeView(webstore, content); // HACK TO GET THE HOME PAGE WORKING
		if (!CollectionUtils.isEmpty(webstore.getWidgets())) {
			Row widgets = new Row();
			widgets.getStyle().set("margin", "0 -0.5em -0.5em"); // HACK TO GET SPACING TO WORK
			for (Element descriptor : webstore.getWidgets()) {
				try {
					Widget widget = new Widget(descriptor);
					Container rendered = widget.render();
					rendered.getContent().getStyle().set("margin", "0 0.5em 0.5em"); // HACK TO GET SPACING TO WORK
					widgets.add(rendered);
				} catch (Exception exception) { // TODO don't catch generic
					exception.printStackTrace(); // TODO error handling
				}
			}
			row.add(container);
			row.addNestedRow(widgets);
			row.setComponentSpan(container, 2);
		} else {
			row.add(container);
		}
	}

}
