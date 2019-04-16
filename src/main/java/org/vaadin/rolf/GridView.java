package org.vaadin.rolf;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.HeaderRow;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;
import org.vaadin.rolf.models.Address;
import org.vaadin.rolf.models.Person;

import java.util.ArrayList;
import java.util.List;

@Route(value="grid", layout= RootLayout.class)
public class GridView extends VerticalLayout {

    Grid<Person> grid = new Grid<>(Person.class, false);
    HeaderRow gridHeader;

    public GridView(){
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

        grid.setItems(getPersonData());
        grid.setSizeFull();
        grid.addColumn(new ComponentRenderer<>(person -> {
            Image img = new Image(person.getImage(), "");
            img.addClassName("grid-profile-picture");
            return img;
        })).setHeader("").setFlexGrow(0);
        grid.addColumn(Person::getfirstName).setHeader("First name");
        grid.addColumn(Person::getLastName).setHeader("Last name");
        grid.addColumn(Person::getAge).setFlexGrow(0).setHeader("Age");
        grid.addColumn(Person::getPhoneNumber).setHeader("Phone number");
        grid.addColumn(person -> person.getAddress().getCity()).setHeader("City");
        grid.addColumn(new ComponentRenderer<>(person -> {

            Image img = new Image(person.getImage(), "");
            img.addClassName("grid-profile-picture");

            Span name = new Span(person.getfirstName() + " " + person.getLastName());
            name.addClassName("name");
            Span details = new Span(person.getAge() + " " + person.getAddress().getCity());
            details.addClassName("details");
            VerticalLayout nameAndDetails = new VerticalLayout(name, details);
            nameAndDetails.setPadding(false);
            nameAndDetails.setSpacing(false);

            HorizontalLayout cellLayout = new HorizontalLayout(img, nameAndDetails);
            cellLayout.addClassName("mobile-grid-cell");
            cellLayout.setPadding(false);

            return cellLayout;
        })).setKey("mobile-col").setFlexGrow(1);
        add(grid);

        gridHeader = grid.getHeaderRows().get(0);

        UI.getCurrent().getPage().addBrowserWindowResizeListener(e->{
           setGridCols(e.getWidth());
        });

        Button menubutton = new Button(VaadinIcon.MENU.create());
        menubutton.addClassName("menu-button");
        menubutton.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE, ButtonVariant.LUMO_ICON);
        viewHeader.addComponentAsFirst(menubutton);
        menubutton.addClickListener(e->UI.getCurrent().getElement().setAttribute("show-menu", true));

    }

    private void setGridCols(int viewportWidth) {
        boolean showOnlyMobileColumn = viewportWidth < 500;

        for (Grid.Column<Person> col : grid.getColumns()) {
            col.setVisible(!showOnlyMobileColumn);
        }

        grid.getColumnByKey("mobile-col").setVisible(showOnlyMobileColumn);

        if (showOnlyMobileColumn) {
            grid.addClassName("no-header");
        } else {
            grid.removeClassName("no-header");
        }


    }

    private List<Person> getPersonData() {
        List<Person> personList = new ArrayList<>();

        personList.add(new Person(10, "Lucas", "Kane", 68,
                new Address("12080", "Washington"), "127-942-237"));
        personList.add(new Person(11, "Peter", "Buchanan", 38,
                new Address("93849", "New York"), "201-793-488"));
        personList.add(new Person(12, "Samuel", "Lee", 53,
                new Address("86829", "New York"), "043-713-538"));
        personList.add(new Person(13, "Anton", "Ross", 37,
                new Address("63521", "New York"), "150-813-6462"));
        personList.add(new Person(14, "Aaron", "Atkinson", 18,
                new Address("25415", "Washington"), "321-679-8544"));
        personList.add(new Person(15, "Jack", "Woodward", 28,
                new Address("95632", "New York"), "187-338-588"));

        return personList;
    }
}
