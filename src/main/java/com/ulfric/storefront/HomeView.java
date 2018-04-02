package com.ulfric.storefront;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

import com.ulfric.storefront.model.Webstore;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.router.ParentLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;

@Route(value = "home", layout = ContentDisplay.class)
@ParentLayout(ContentDisplay.class)
@SpringComponent
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class HomeView extends View {

	public HomeView(Webstore webstore, ContentDisplay display) {
		display.getNavBar().select(null);
		display.setTitle("Home");
		display.setPage(new Text(webstore.getHomeBody()));
	}

}
