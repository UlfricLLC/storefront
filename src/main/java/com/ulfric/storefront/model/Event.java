package com.ulfric.storefront.model;

import java.util.HashMap;
import java.util.Map;

public class Event extends Named {

	private Map<String, String> details = new HashMap<>();
	private Boolean interaction;

	public Map<String, String> getDetails() {
		return details;
	}

	public void setDetails(Map<String, String> details) {
		this.details = details;
	}

	public Boolean getInteraction() {
		return interaction;
	}

	public void setInteraction(Boolean interaction) {
		this.interaction = interaction;
	}

}
