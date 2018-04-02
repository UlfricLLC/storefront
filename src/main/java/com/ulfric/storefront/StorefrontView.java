package com.ulfric.storefront;

import com.ulfric.storefront.vaadin.margin.MarginTopEm;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@HtmlImport("styles/shared-styles.html")
@Route("")
@Theme(Lumo.class)
public class StorefrontView extends MainLayout implements RouterLayout {

    public StorefrontView(Header header, NavBar navBar, Body body) {
    	getContent().add(new MarginTopEm(2), header, new MarginTopEm(3), navBar, new MarginTopEm(2), body);
    }

}
