package store.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import store.userinterfaces.DemoblazeHomePage;

public class NavigateTo {

    private static final Logger LOGGER = LoggerFactory.getLogger(NavigateTo.class);

    public static Performable theSearchHomePage() {
        LOGGER.info("Abriendo la página de inicio de DemoBlaze");
        return Task.where("{0} opens the Demoblaze home page",
                Open.browserOn().the(DemoblazeHomePage.class));
    }
}
