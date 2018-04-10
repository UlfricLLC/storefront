package com.ulfric.storefront.util;

import java.util.Locale;
import java.util.Optional;

import com.vaadin.flow.server.VaadinRequest;

public class LocaleUtil {

	public static Optional<Locale> getSessionLocale() {
		VaadinRequest request = VaadinRequest.getCurrent();
		return request == null ? Optional.empty() : Optional.ofNullable(request.getLocale());
	}

}
