package com.ulfric.storefront.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Webstore extends Named {

	private List<Item> items = new ArrayList<>();
	private List<Sale> sales = new ArrayList<>();
	private Map<String, PriceOffset> giftcards = new HashMap<>();
	private List<WidgetDescriptor> widgets = new ArrayList<>();
	private String homeBody = "This webstore does not yet have a homeBody set";

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<Sale> getSales() {
		return sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

	public List<WidgetDescriptor> getWidgets() {
		return widgets;
	}

	public Map<String, PriceOffset> getGiftcards() {
		return giftcards;
	}

	public void setGiftcards(Map<String, PriceOffset> giftcards) {
		this.giftcards = giftcards;
	}

	public void setWidgets(List<WidgetDescriptor> widgets) {
		this.widgets = widgets;
	}

	public String getHomeBody() {
		return homeBody;
	}

	public void setHomeBody(String homeBody) {
		this.homeBody = homeBody;
	}

}
