package com.ulfric.storefront.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ulfric.storefront.model.Webstore;
import com.ulfric.storefront.services.WebstoreService;
import com.vaadin.flow.spring.annotation.UIScope;

@Configuration
public class WebstoreConfiguration {

	private final WebstoreService webstoreService;

	public WebstoreConfiguration(WebstoreService webstoreService) {
		this.webstoreService = webstoreService;
	}

	@Bean
	@UIScope
	public Webstore webstore() {
		return webstoreService.getWebstore();
	}

}
