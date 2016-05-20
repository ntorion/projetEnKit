package prof.prodageo.org;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.GridLayout;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* import for explicit declaration of callback */
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Button.ClickEvent;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@Widgetset("prof.prodageo.org.MyAppWidgetset")
public class MyUI extends UI {

        private static final Logger log = LoggerFactory.getLogger(MyUIServlet.class);

    /* explicit declaration as attributes of graphical components for GenMyModel */
        final VerticalLayout layout = new VerticalLayout();
        final TextField texteLongueur = new TextField();
        final TextField texteLargeur = new TextField();
        final TextField surname = new TextField();
        Button button = new Button("Créer pièce") ;
        final GridLayout gLayout = new GridLayout(2,3);
        Button buttonFormeCarre = new Button("CARRE") ;
        Button buttonFormeRond = new Button("ROND") ;
        Button buttonFormeTriangle = new Button("TRIANGLE") ;
        Button buttonFormePentagone = new Button("PENTAGONE") ;
        Button buttonFormeHexagone = new Button("HEXAGONE") ;
        Button buttonFormeLigne = new Button("LIGNE") ;
        Label fdp = new Label("Forme de la pièce");
        Label es = new Label("Elements Structurels");
        Button buttonESCarre = new Button("ES CARRE") ;
        Button buttonESRond = new Button("ES ROND") ;


    /* explicit callback */
    /* https://vaadin.com/docs/-/part/framework/application/application-events.html */
    public class ClickMeClass implements Button.ClickListener
    {
        public void buttonClick(ClickEvent event)
        {

        }
    }



    @Override
    protected void init(VaadinRequest vaadinRequest) {


        // final VerticalLayout layout = new VerticalLayout();

        // final TextField name = new TextField();
        texteLongueur.setCaption("Longueur : ");
        texteLargeur.setCaption("Largeur : ");

        /*
        Button button = new Button("Click Me");
        button.addClickListener( e -> {
            layout.addComponent(new Label("Thanks " + name.getValue()
                    + ", it works!"));
            log.info("Button clicked with value : " + name.getValue());
        });
        */
        ClickMeClass callback = new ClickMeClass() ;
        button.addClickListener( callback ) ;
        gLayout.addComponents(buttonFormeRond,buttonFormeLigne,buttonFormeCarre,buttonFormeTriangle,buttonFormeHexagone,buttonFormePentagone);
        layout.addComponents(fdp,gLayout,es,buttonESRond,buttonESCarre,texteLongueur,texteLargeur, button);
        layout.setMargin(true);
        layout.setSpacing(true);

        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
