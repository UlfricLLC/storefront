package com.ulfric.storefront.model;

import java.math.BigDecimal;
import java.util.List;

public class Item extends Described {

	public static boolean isPositive(BigDecimal price) { // TODO move
		return price != null && price.compareTo(BigDecimal.ZERO) > 0;
	}

	private List<Category> categories;
	private BigDecimal price;
	private List<String> commands;
	private Boolean changeableQuantity;

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<String> getCommands() {
		return commands;
	}

	public void setCommands(List<String> commands) {
		this.commands = commands;
	}

	public Boolean getChangeableQuantity() {
		return changeableQuantity;
	}

	public void setChangeableQuantity(Boolean changeableQuantity) {
		this.changeableQuantity = changeableQuantity;
	}

}
