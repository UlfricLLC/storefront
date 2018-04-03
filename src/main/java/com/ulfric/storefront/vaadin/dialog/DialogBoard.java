package com.ulfric.storefront.vaadin.dialog;

import com.vaadin.flow.component.board.Board;
import com.vaadin.flow.component.html.Div;

public class DialogBoard extends Board {

	public static final String MAX_WIDTH = "56vh";

	public DialogBoard(int height) {
		setWidth("100%");
		setHeight(height + "vh");

		getStyle().set("max-width", DialogBoard.MAX_WIDTH); // TODO which one of these is not needed
		getStyle().set("maxWidth", DialogBoard.MAX_WIDTH);

		getStyle().set("max-height", height + "vh"); // TODO which one of these is not needed
		getStyle().set("maxHeight", height + "vh");

		Div makeTheBoardWideHack = new Div();
		makeTheBoardWideHack.setWidth(DialogBoard.MAX_WIDTH);
		add(makeTheBoardWideHack); // without this, you can scroll horizontally inside the board when it is small
	}

}
