package com.ulfric.storefront.model;

import java.util.HashSet;
import java.util.Set;

public class Sale extends PriceOffset {

	private Set<String> items = new HashSet<>();
	private Boolean global = false;

	public Set<String> getItems() {
		return items;
	}

	public void setItems(Set<String> items) {
		this.items = items;
	}

	public Boolean getGlobal() {
		return global;
	}

	public void setGlobal(Boolean global) {
		this.global = global;
	}

}
