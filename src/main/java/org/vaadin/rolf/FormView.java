package org.vaadin.rolf;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value="", layout= RootLayout.class)
public class FormView extends VerticalLayout {

    public FormView(){
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

        Div viewTitle = new Div(new Text("Form View"));
        viewTitle.addClassName("view-title");
        viewHeader.add(viewTitle);

        Div contentScroller = new Div();
        contentScroller.addClassNames("view-contents", "scroller");
        contentScroller.setSizeFull();
        contentScroller.add(getForm());
        add(contentScroller);

        HorizontalLayout viewFooter = new HorizontalLayout();
        viewFooter.addClassNames("view-footer", "noshrink");
        viewFooter.setWidthFull();
        viewFooter.setPadding(true);
        Button btnSave = new Button("Save");
        btnSave.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        Button btnCancel = new Button("Cancel");
        viewFooter.add(btnSave, btnCancel);
        add(viewFooter);

//        Button menubutton = new Button(VaadinIcon.MENU.create());
//        menubutton.addClassName("menu-button");
//        menubutton.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE, ButtonVariant.LUMO_ICON);
//        viewHeader.addComponentAsFirst(menubutton);
//        menubutton.addClickListener(e->UI.getCurrent().getElement().setAttribute("show-menu", true));

    }

    private FormLayout getForm() {
        FormLayout form = new FormLayout();

        form.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1),
                new FormLayout.ResponsiveStep("400px", 2),
                new FormLayout.ResponsiveStep("600px", 3)
        );

        form.add(new TextField("First name"), new TextField("Last name"));
        form.add(new DatePicker("Date of birth"), new ComboBox<String>("Gender"){{setItems("Male", "Female", "Other");}});
        form.add(new EmailField("Email address"), new TextField("Phone number"));
        TextField streetAddress = new TextField("Street address");
        streetAddress.getElement().setAttribute("colspan", "3");
        form.add(streetAddress);
        form.add(new TextField("City"), new TextField("Zipcode"), new ComboBox<>("Country"));

        return form;
    }
}
