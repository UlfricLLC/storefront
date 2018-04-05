package com.ulfric.storefront.util;

import java.util.UUID;

public class IdUtil {

	public static String generateUniqueId() {
		return shortUniqueId() + shortUniqueId();
	}

	private static String shortUniqueId() {
		return UUID.randomUUID().toString().replace("-", "").toLowerCase();
	}

}
