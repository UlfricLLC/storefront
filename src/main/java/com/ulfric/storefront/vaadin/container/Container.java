package com.ulfric.storefront.vaadin.container;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.util.StringUtils;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.spring.annotation.SpringComponent;

@SpringComponent
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Container extends Composite<Div> {

	private final Div body = new Div();
	private final H3 title;

	private static H3 title(String string) {
		H3 title = new H3(StringUtils.isEmpty(string) ? null : string);
		title.addClassName("courier");
		title.addClassName("container-title");
		return title;
	}

	public Container() {
		this("", new Div());
	}

	public Container(String title, Component page) {
		this(title(title), page);
	}

	private Container(H3 title, Component page) {
		getContent().add(title, this.body);

		this.title = title;
		this.body.add(page);
		getContent().addClassName("container");
	}

	public void setTitle(String title) {
		this.title.setText(title);
	}

	public void setPage(Component page) {
		this.body.removeAll();
		this.body.add(page);
	}

}
