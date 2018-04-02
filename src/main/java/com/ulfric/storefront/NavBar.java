package com.ulfric.storefront;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.ulfric.storefront.model.Category;
import com.ulfric.storefront.model.Item;
import com.ulfric.storefront.model.Webstore;
import com.ulfric.storefront.vaadin.tab.ContrastTab;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcons;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class NavBar extends Composite<Tabs> {

	private final Webstore webstore;
	private final Map<String, Tab> categoryToTab = new HashMap<>();

	public NavBar(Webstore webstore) {
		this.webstore = webstore;

		Tab home = new ContrastTab(new Icon(VaadinIcons.HOME));
    	home.setSelected(true);
    	getContent().add(home);

    	getDefinedCategories().forEach(category -> {
    		Tab tab = new CategoryTab(category);
    		add(tab, category);
    	});

    	Tabs tabs = getContent();
    	tabs.addSelectedChangeListener(event -> {
    		if (!event.isFromClient()) {
    			return;
    		}

    		getUI().ifPresent(ui -> {
    			Tab selected = tabs.getSelectedTab();
    			if (selected instanceof CategoryTab) {
    				CategoryTab category = (CategoryTab) selected;
    				ui.navigate("category/" + category.getCategory().getPath());
    			}
    			else if (tabs.getSelectedIndex() == 0) {
    				ui.navigate("home");
    			}
    		});
    	});
	}

    private Stream<Category> getDefinedCategories() {
    	return webstore.getItems()
    			.stream()
    			.map(Item::getCategories)
    			.map(categories -> {
    				if (CollectionUtils.isEmpty(categories)) {
    					return Collections.singletonList(packages());
    				}
    				return categories;
    			})
    			.flatMap(List::stream)
    			.filter(Objects::nonNull)
    			.distinct();
    }

    private Category packages() {
    	Category packages = new Category();
    	packages.setName("Packages");
    	packages.setPath("packages");
    	return packages;
    }

    private void add(Tab tab, Category category) {
    	getContent().add(tab);
    	if (StringUtils.isEmpty(category.getPath())) {
    		categoryToTab.put("packages", tab);
    	} else {
    		categoryToTab.put(category.getPath().toLowerCase(), tab);
    	}

    	if (StringUtils.isEmpty(category.getName())) {
    		categoryToTab.put("packages", tab);
    	} else {
    		categoryToTab.put(category.getName().toLowerCase(), tab);
    	}
    }

    public void select(String category) {
    	Tabs tabs = getContent();
    	if (StringUtils.isEmpty(category)) {
    		if (tabs.getSelectedIndex() == 0) {
    			return;
    		}
    		tabs.setSelectedIndex(0);
    		return;
    	}

    	Tab tab = categoryToTab.get(category.toLowerCase());
    	Objects.requireNonNull(tab, "missing tab: " + category.toLowerCase());
    	if (tabs.getSelectedTab() != tab) {
    		tabs.setSelectedTab(tab);
    	}
    }

}
