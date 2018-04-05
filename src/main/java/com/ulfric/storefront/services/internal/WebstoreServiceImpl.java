package com.ulfric.storefront.services.internal;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ulfric.storefront.model.Category;
import com.ulfric.storefront.model.Element;
import com.ulfric.storefront.model.Item;
import com.ulfric.storefront.model.Sale;
import com.ulfric.storefront.model.Webstore;
import com.ulfric.storefront.services.WebstoreService;

@Service
public class WebstoreServiceImpl implements WebstoreService {

	@Override
	public Webstore getWebstore() {
		Webstore webstore = new Webstore();
		webstore.setName("skyritz");

		webstore.setWidgets(Arrays.asList(widget(), widget()));

		Item item = new Item();
		item.setName("Diamond Rank");
		item.setDescription(Arrays.asList(text("description", "Hello, world"), list("Some awesome perk", "Another awesome perk")));
		item.setPrice(BigDecimal.valueOf(24.99));
		item.setCategories(Arrays.asList(category("Ranks"), category("Rank Upgrades", "upgrades"), category("Crate Keys", "keys"), category("Perks"), category("Money")));

		Item item2 = new Item();
		item2.setName("Gold Rank");
		item2.setDescription(Arrays.asList(text("description", v())));
		item2.setPrice(BigDecimal.valueOf(9.99));
		item2.setCategories(item.getCategories());
		webstore.setItems(Arrays.asList(item2, item));

		Sale sale = new Sale();
		sale.setAmount(BigDecimal.valueOf(10));
		sale.setItems(Collections.singleton("Gold Rank"));
		webstore.setSales(Arrays.asList(sale));

		return webstore;
	}

	private Category category(String name) {
		return category(name, name.toLowerCase());
	}

	private Category category(String name, String path) {
		Category category = new Category();
		category.setName(name);
		category.setPath(path);
		category.setDescription(Arrays.asList(text("Category", "This is some description for your category, named " + name + " at path " + path)));
		return category;
	}

	private Element widget() {
		return text("Support", "For support, you must email us. But in emailing us, we may ignore you. It really depends on how busy we are!");
	}

	private Element text(String name, String body) {
		Element text = new Element();
		text.setName(name);
		text.setType("text");
		text.setValue(body);
		return text;
	}

	private String v() {
		StringBuilder s = new StringBuilder();
		for (int x = 0; x < 400; x++) {
			s.append(UUID.randomUUID().toString().replace('-', ' '));
			s.append(' ');
		}
		return s.toString();
	}

	private Element list(String... items) {
		Element list = new Element();
		list.setName("list");
		list.setType("list");
		Map<String, Element> itemMap = new TreeMap<>();
		for (int x = 0; x < items.length; x++) {
			itemMap.put(String.valueOf(x), text(x + "", items[x]));
		}
		list.setValues(itemMap);
		return list;
	}

}
