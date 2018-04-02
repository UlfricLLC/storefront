package com.ulfric.storefront.model;

import java.util.Objects;

public class Category extends Named {

	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public boolean equals(Object object) {
		if (!super.equals(object)) {
			return false;
		}

		Category that = (Category) object;
		return Objects.equals(path, that.path);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), path);
	}

}
