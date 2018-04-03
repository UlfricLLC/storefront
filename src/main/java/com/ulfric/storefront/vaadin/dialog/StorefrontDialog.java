package com.ulfric.storefront.vaadin.dialog;

import com.vaadin.flow.component.dialog.Dialog;

public class StorefrontDialog extends Dialog {

	public StorefrontDialog() {
		getElement().getThemeList().add("storefront-dialog");
		addClassName("dialog");
	}

}
