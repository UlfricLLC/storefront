package com.ulfric.storefront.services;

import com.ulfric.storefront.model.Event;

public interface AnalyticsService {

	void record(String analyticsId, Event event);

}
