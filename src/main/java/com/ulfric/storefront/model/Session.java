package com.ulfric.storefront.model;

import java.util.List;
import java.util.SortedMap;
import java.util.UUID;

public class Session extends HasId {

	private List<Long> visitTimestamps;
	private UUID mojangId;
	private SortedMap<Long, UUID> formerMojangIds;
	private Cart cart;
	private String customerId;
	private String analyticsId;

	public List<Long> getVisitTimestamps() {
		return visitTimestamps;
	}

	public void setVisitTimestamps(List<Long> visitTimestamps) {
		this.visitTimestamps = visitTimestamps;
	}

	public UUID getMojangId() {
		return mojangId;
	}

	public void setMojangId(UUID mojangId) {
		this.mojangId = mojangId;
	}

	public SortedMap<Long, UUID> getFormerMojangIds() {
		return formerMojangIds;
	}

	public void setFormerMojangIds(SortedMap<Long, UUID> formerMojangIds) {
		this.formerMojangIds = formerMojangIds;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getAnalyticsId() {
		return analyticsId;
	}

	public void setAnalyticsId(String analyticsId) {
		this.analyticsId = analyticsId;
	}

}
