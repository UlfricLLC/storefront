package com.ulfric.storefront.util;

import java.util.Objects;
import java.util.Optional;

import javax.servlet.http.Cookie;

import com.vaadin.flow.server.VaadinRequest;

public class CookieUtil {

	public static Optional<String> getCookieValue(String name) {
		Objects.requireNonNull(name, "name");

		for (Cookie cookie : VaadinRequest.getCurrent().getCookies()) {
			if (cookie.getName() == null) {
				continue;
			}

			if (cookie.getName().equalsIgnoreCase(name)) {
				if (cookie.getValue() != null) {
					return Optional.of(cookie.getValue());
				}
			}
		}

		return Optional.empty();
	}

	public static void setCookieValue(String name, String value) {
		// TODO implement!!!
		return;
	}

}
