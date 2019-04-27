package org.vaadin.rolf;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;

public class NaviCol extends VerticalLayout {

    public NaviCol() {

        setHeightFull();
        setPadding(false);
        setSpacing(false);
        setWidth("200px");
        setMinWidth("200px");
        addClassName("navicol");

        Span appTitle = new Span("Responsive Demo");
        appTitle.addClassName("app-title");
        add(appTitle);

        VerticalLayout navicolHeader = new VerticalLayout(appTitle);
        navicolHeader.addClassNames("navicol-header", "noshrink");
        navicolHeader.setPadding(true);
        navicolHeader.setWidthFull();
        add(navicolHeader);

        VerticalLayout links = new VerticalLayout();
        links.setPadding(true);
        links.setWidthFull();
        links.addClassName("links");

        Div scroller = new Div(links);
        scroller.addClassNames("link-wrapper", "scroller");
        scroller.setSizeFull();
        setFlexGrow(1, scroller);
        add(scroller);

        links.add(new RouterLink("Form View", FormView.class));
        links.add(new RouterLink("Wrapping Layout", WrapDemoView.class));
        for (int i=0; i<20; i++) {
            Anchor a = new Anchor("", "Some view " + i);
            links.add(a);
        }

    }
}
