package com.ulfric.storefront.services;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.stereotype.Service;

import com.ulfric.storefront.model.Category;
import com.ulfric.storefront.model.Item;
import com.ulfric.storefront.model.Property;
import com.ulfric.storefront.model.Webstore;
import com.ulfric.storefront.model.WidgetDescriptor;

@Service
public class WebstoreService {

	public Webstore getWebstore() {
		Webstore webstore = new Webstore();
		webstore.setName("skyblocking");

		webstore.setWidgets(Arrays.asList(widget(), widget()));

		Item item = new Item();
		item.setCategories(Arrays.asList(category("ranks"), category("rank upgrades", "upgrades"), category("crate keys", "keys"), category("perks"), category("money")));
		webstore.setItems(Arrays.asList(item));

		return webstore;
	}

	private Category category(String name) {
		return category(name, name);
	}

	private Category category(String name, String path) {
		Category category = new Category();
		category.setName(name);
		category.setPath(path);
		return category;
	}

	private WidgetDescriptor widget() {
		WidgetDescriptor text = new WidgetDescriptor();
		text.setName("Support");
		text.setType("text");
		Property property = new Property();
		property.setValue("For support, you must email us. But in emailing us, we may ignore you. It really depends on how busy we are!");
		text.setProperties(Collections.singletonMap("text", property));
		return text;
	}

}
