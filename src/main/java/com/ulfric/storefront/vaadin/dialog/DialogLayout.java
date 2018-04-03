package com.ulfric.storefront.vaadin.dialog;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class DialogLayout extends VerticalLayout {

	public static final String MAX_WIDTH = "56vh";

	public DialogLayout() {
		setWidth("100%");
		setHeight("80vh");

		getStyle().set("max-width", DialogLayout.MAX_WIDTH); // TODO which one of these is not needed
		getStyle().set("maxWidth", DialogLayout.MAX_WIDTH);

		getStyle().set("max-height", "80vh"); // TODO which one of these is not needed
		getStyle().set("maxHeight", "80vh");

		Div makeTheBoardWideHack = new Div();
		makeTheBoardWideHack.setWidth(DialogLayout.MAX_WIDTH);
		add(makeTheBoardWideHack); // without this, you can scroll horizontally inside the board when it is small
	}

}
