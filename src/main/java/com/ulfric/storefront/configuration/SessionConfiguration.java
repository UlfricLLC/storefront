package com.ulfric.storefront.configuration;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ulfric.storefront.model.Session;
import com.ulfric.storefront.repositories.SessionRepository;
import com.ulfric.storefront.util.CookieUtil;
import com.vaadin.flow.spring.annotation.UIScope;

@Configuration
public class SessionConfiguration {

	public static final String SESSION_COOKIE_NAME = "storefront_session";

	private final SessionRepository sessionRepository;

	public SessionConfiguration(SessionRepository sessionRepository) {
		this.sessionRepository = sessionRepository;
	}

	@Bean
	@UIScope
	public Session session() {
		return CookieUtil.getCookieValue(SESSION_COOKIE_NAME)
				.map(sessionRepository::getById)
				.map(session -> {
					if (session.getVisitTimestamps() == null) {
						session.setVisitTimestamps(new ArrayList<>());
					}
					session.getVisitTimestamps().add(System.currentTimeMillis());
					return session;
				})
				.orElseGet(() -> {
					Session session = sessionRepository.createNew();
					CookieUtil.setCookieValue(SESSION_COOKIE_NAME, session.getId());
					return session;
				});
	}

}
