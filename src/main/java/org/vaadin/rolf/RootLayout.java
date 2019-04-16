package org.vaadin.rolf;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.server.PWA;

@PWA(name = "Mobile UI Demo", shortName = "Mobile UI Demo")
@HtmlImport("frontend://styles/shared-styles.html")
public class RootLayout extends HorizontalLayout implements RouterLayout {

    public RootLayout() {

        addClassName("root-layout");
        setSizeFull();
        setPadding(false);
        setSpacing(false);

        NaviCol naviCol = new NaviCol();
        add(naviCol);

//        UI.getCurrent().addAfterNavigationListener(e->hideMenu());
//
//        Div scrim = new Div();
//        scrim.addClassName("navicol-scrim");
//        scrim.addClickListener(e->hideMenu());
//        addComponentAsFirst(scrim);

    }

//    private void hideMenu() {
//        UI.getCurrent().getElement().setAttribute("show-menu", false);
//    }

}
