package com.ulfric.storefront.frontend.view;

import java.util.Locale;

import com.ulfric.storefront.frontend.component.Body;
import com.ulfric.storefront.frontend.component.Header;
import com.ulfric.storefront.frontend.component.NavBar;
import com.ulfric.storefront.model.Event;
import com.ulfric.storefront.model.Session;
import com.ulfric.storefront.services.AnalyticsService;
import com.ulfric.storefront.util.LocaleUtil;
import com.ulfric.storefront.vaadin.margin.MarginTopEm;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@HtmlImport("styles/shared-styles.html")
@Route("")
@Theme(Lumo.class)
public class StorefrontView extends MainLayout implements RouterLayout {

	public StorefrontView(Header header, NavBar navBar, Body body, Session session, AnalyticsService analytics) {
		getContent().add(new MarginTopEm(2), header, new MarginTopEm(3), navBar, new MarginTopEm(2), body);

		Event event = new Event();
		event.setName("visit"); // TODO record leave & time spent on site
		Locale locale = LocaleUtil.getSessionLocale().orElse(null);
		if (locale == null) {
			event.getDetails().put("locale", "unknown");
		} else {
			event.getDetails().put("locale", locale.toString());
		}
		analytics.record(session.getAnalyticsId(), event);
	}

}
