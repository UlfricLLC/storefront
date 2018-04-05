package com.ulfric.storefront.model;

import java.util.Objects;

public class Named extends Bean {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object object) {
		if (!super.equals(this)) {
			return false;
		}

		Named that = (Named) object;
		return Objects.equals(name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

}
