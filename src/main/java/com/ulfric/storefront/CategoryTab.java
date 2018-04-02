package com.ulfric.storefront;

import java.util.Objects;

import com.ulfric.storefront.model.Category;
import com.ulfric.storefront.vaadin.tab.ContrastTab;
import com.vaadin.flow.component.Text;

public class CategoryTab extends ContrastTab {

	private final Category category;

	public CategoryTab(Category category) {
		super(new Text(category.getName()));
		Objects.requireNonNull(category, "category");

		this.category = category;
		addClassName("category-tab");
	}

	public Category getCategory() {
		return category;
	}

}
