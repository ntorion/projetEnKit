package prof.prodageo.org;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
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
public class Controller {
  private Label simul;
  private Button boutonRond;
  private Button boutonCarre;
  private Button boutonTriangle;
  private Button boutonHexagone;
  private Button boutonPentagone;
  private Button boutonLigne;

  public Controller(Label simul, Button boutonRond, Button boutonCarre, Button boutonTriangle, Button boutonHexagone, Button boutonPentagone, Button boutonLigne) {
    this.simul = simul;
    this.boutonRond = boutonRond;
    this.boutonCarre = boutonCarre;
    this.boutonTriangle = boutonTriangle;
    this.boutonHexagone = boutonHexagone;
    this.boutonPentagone = boutonPentagone;
    this.boutonLigne = boutonLigne;

    boutonRond.addClickListener(new Button.ClickListener() {
    public void buttonClick(ClickEvent event) {
      simul.setStyleName("simulRond");
    }
    });

    boutonCarre.addClickListener(new Button.ClickListener() {
    public void buttonClick(ClickEvent event) {
      simul.setStyleName("simulCarre");
    }
    });

    boutonTriangle.addClickListener(new Button.ClickListener() {
    public void buttonClick(ClickEvent event) {
      simul.setStyleName("simulTriangle");
    }
    });

    boutonHexagone.addClickListener(new Button.ClickListener() {
    public void buttonClick(ClickEvent event) {
      simul.setStyleName("simulHexagone");
    }
    });

    boutonPentagone.addClickListener(new Button.ClickListener() {
    public void buttonClick(ClickEvent event) {
      simul.setStyleName("simulPentagone");
    }
    });

    boutonLigne.addClickListener(new Button.ClickListener() {
    public void buttonClick(ClickEvent event) {
      simul.setStyleName("simulLigne");
    }
    });

  }


}
