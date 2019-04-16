package org.vaadin.rolf;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value="wrap", layout= RootLayout.class)
public class WrapDemoView extends VerticalLayout {


    public WrapDemoView(){
        setSizeFull();
        addClassName("view");
        setPadding(false);
        setSpacing(false);

        HorizontalLayout viewHeader = new HorizontalLayout();
        viewHeader.addClassNames("view-header", "noshrink");
        viewHeader.setWidthFull();
        viewHeader.setPadding(true);
        viewHeader.setAlignItems(Alignment.CENTER);
        add(viewHeader);

        Div viewTitle = new Div(new Text("Grid View"));
        viewTitle.addClassName("view-title");
        viewHeader.add(viewTitle);

        Button menubutton = new Button(VaadinIcon.MENU.create());
        menubutton.addClassName("menu-button");
        menubutton.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE, ButtonVariant.LUMO_ICON);
        viewHeader.addComponentAsFirst(menubutton);
        menubutton.addClickListener(e->UI.getCurrent().getElement().setAttribute("show-menu", true));

        Div contentScroller = new Div();
        contentScroller.addClassNames("view-contents", "scroller");
        contentScroller.setSizeFull();
        add(contentScroller);

        HorizontalLayout wrappingLayout = new HorizontalLayout();
        wrappingLayout.setSizeUndefined();
        wrappingLayout.addClassName("wrapping-layout");
        contentScroller.add(wrappingLayout);

        for (int i=0; i<10; i++) {
            Button btn = new Button("Button " + i);
            btn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
            wrappingLayout.add(btn);
        }

    }

}
