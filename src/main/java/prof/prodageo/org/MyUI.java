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
import com.vaadin.ui.*;



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
@Theme("colored")
@Widgetset("prof.prodageo.org.MyAppWidgetset")
public class MyUI extends UI {

        private static final Logger log = LoggerFactory.getLogger(MyUIServlet.class);

    /* explicit declaration as attributes of graphical components for GenMyModel */
        final CssLayout content = new CssLayout();
        final HorizontalLayout repartition = new HorizontalLayout();
        final VerticalLayout coteGauche = new VerticalLayout();
        final VerticalLayout coteDroit = new VerticalLayout();
        final TextField texteLongueur = new TextField();
        final TextField texteLargeur = new TextField();
        final TextField surname = new TextField();
        Button button = new Button("Créer pièce") ;
        final GridLayout gLayout = new GridLayout(2,3);
        Button buttonFormeCarre = new Button("") ;
        Button buttonFormeRond = new Button("") ;
        Button buttonFormeTriangle = new Button("") ;
        Button buttonFormePentagone = new Button("") ;
        Button buttonFormeHexagone = new Button("") ;
        Button buttonFormeLigne = new Button("") ;
        Label fdp = new Label("Forme de la pièce");
        Label es = new Label("Elements Structurels");
        Button buttonESCarre = new Button("") ;
        Button buttonESRond = new Button("") ;

        Button buttonFermer = new Button("Fermer") ;
        Button buttonSauvegarder = new Button("Sauvegarder la pièce") ;

        Button arriere = new Button("") ;
        Button avant = new Button("") ;

        Label bienvenue = new Label("Bienvenue !");

        Button deconnecter = new Button("") ;

        final VerticalLayout elementsBasGauche = new VerticalLayout();

        final HorizontalLayout barreDuBas = new HorizontalLayout();

        final HorizontalLayout barreDuHautGauche = new HorizontalLayout();

        final HorizontalLayout barreDuHautDroit = new HorizontalLayout();

        final HorizontalLayout boutonsES = new HorizontalLayout();

        Label simul = new Label();

        Slider sld = new Slider();

        Controller ctr = new Controller(simul, buttonFormeRond, buttonFormeCarre, buttonFormeTriangle, buttonFormeHexagone, buttonFormePentagone, buttonFormeLigne);

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


        sld.setImmediate(true);
        sld.setMin(0.0);
        sld.setMax(100.0);
        sld.setValue(50.0);
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
        button.addClickListener( callback );
        gLayout.setMargin(true);
        gLayout.addComponents(buttonFormeCarre,buttonFormeRond,buttonFormeTriangle,buttonFormePentagone,buttonFormeHexagone,buttonFormeLigne);

        arriere.addStyleName("arriere");
        avant.addStyleName("avant");

        deconnecter.addStyleName("deconnecter");

        simul.addStyleName("simul");

        boutonsES.addComponents(buttonESCarre, buttonESRond);

        buttonFormeRond.addStyleName("buttonFormeRond");
        buttonFormeCarre.addStyleName("buttonFormeCarre");
        buttonFormeTriangle.addStyleName("buttonFormeTriangle");
        buttonFormePentagone.addStyleName("buttonFormePentagone");
        buttonFormeHexagone.addStyleName("buttonFormeHexagone");
        buttonFormeLigne.addStyleName("buttonFormeLigne");

        buttonESCarre.addStyleName("buttonESCarre");
        buttonESRond.addStyleName("buttonESRond");

        elementsBasGauche.addComponents(texteLongueur,texteLargeur, button);
        elementsBasGauche.addStyleName("elementsBasGauche");

        coteGauche.addComponents(fdp,gLayout,es,boutonsES,elementsBasGauche);

        bienvenue.addStyleName("bienvenue");

        barreDuHautDroit.addStyleName("barreDuHautDroit");
        barreDuHautGauche.addStyleName("barreDuHautGauche");

        barreDuHautGauche.addComponents(arriere,avant);
        barreDuHautDroit.addComponents(bienvenue,deconnecter);

        buttonFermer.addStyleName("buttonFermer");
        buttonSauvegarder.addStyleName("buttonSauvegarder");
        barreDuBas.addComponents(sld, buttonFermer, buttonSauvegarder);

        barreDuBas.addStyleName("barreDuBas");

        coteDroit.addComponents(barreDuBas, barreDuHautGauche, barreDuHautDroit, simul);

        coteGauche.addStyleName("coteGauche");
        coteDroit.addStyleName("coteDroit");

        repartition.addComponents(coteGauche, coteDroit);

        content.addComponents(repartition);

        setContent(content);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
