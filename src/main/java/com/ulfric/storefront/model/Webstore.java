package com.ulfric.storefront.model;

import java.util.ArrayList;
import java.util.List;

public class Webstore extends Named {

	private List<Item> items = new ArrayList<>();
	private List<PriceOffset> sales = new ArrayList<>();
	private List<PriceOffset> fees = new ArrayList<>();
	private List<WidgetDescriptor> widgets = new ArrayList<>();
	private String homeBody = "This webstore does not yet have a homeBody set";

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<PriceOffset> getSales() {
		return sales;
	}

	public void setSales(List<PriceOffset> sales) {
		this.sales = sales;
	}

	public List<PriceOffset> getFees() {
		return fees;
	}

	public void setFees(List<PriceOffset> fees) {
		this.fees = fees;
	}

	public List<WidgetDescriptor> getWidgets() {
		return widgets;
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
