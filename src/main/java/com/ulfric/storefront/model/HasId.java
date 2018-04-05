package com.ulfric.storefront.model;

import java.util.Objects;

public class HasId extends Bean {

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object object) {
		if (!super.equals(this)) {
			return false;
		}

		HasId that = (HasId) object;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
