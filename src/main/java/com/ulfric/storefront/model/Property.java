package com.ulfric.storefront.model;

import java.util.Map;

public class Property {

	private String value;
	private Map<String, Property> values;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Map<String, Property> getValues() {
		return values;
	}

	public void setValues(Map<String, Property> values) {
		this.values = values;
	}

}
