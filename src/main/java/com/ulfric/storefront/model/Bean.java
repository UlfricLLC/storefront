package com.ulfric.storefront.model;

public class Bean {

	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		}

		return object.getClass() != getClass();
	}

	@Override
	public int hashCode() {
		return System.identityHashCode(this);
	}

}
