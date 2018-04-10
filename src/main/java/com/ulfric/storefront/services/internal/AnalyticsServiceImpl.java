package com.ulfric.storefront.services.internal;

import org.springframework.stereotype.Service;

import com.ulfric.storefront.model.Event;
import com.ulfric.storefront.services.AnalyticsService;

@Service
public class AnalyticsServiceImpl implements AnalyticsService {

	@Override
	public void record(String analyticsId, Event event) {
		// TODO Use google analytics
	}

}
