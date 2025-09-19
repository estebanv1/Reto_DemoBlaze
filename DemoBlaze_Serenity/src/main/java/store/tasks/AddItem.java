package store.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import store.models.Item;


import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static store.userinterfaces.DemoblazeHomePage.ITEM;
import static store.userinterfaces.DemoblazeHomePage.SECTION;
import static store.userinterfaces.ItemPage.ADD_BUTTON;
import static store.userinterfaces.ItemPage.HOME_BUTTON;

public class AddItem implements Task{

    private final Logger LOGGER = LoggerFactory.getLogger(AddItem.class);
    private final Item item;

    public AddItem(Item item) {
        this.item = item;
    }

    public void tearDown() {

        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Ensure.that(alert.getText()).isEqualTo("Product added");
        alert.accept();
    }

    @Override
    public <T extends Actor> void performAs(@NotNull T actor) {
        actor.attemptsTo(
                Click.on(String.format(SECTION.getCssOrXPathSelector(), item.getSection())),
                WaitUntil.the(String.format(ITEM.getCssOrXPathSelector(), item.getName()), isPresent()).forNoMoreThan(30).seconds(),
                WaitUntil.the(String.format(ITEM.getCssOrXPathSelector(), item.getName()), isVisible()).forNoMoreThan(30).seconds().then(
                        Click.on(String.format(ITEM.getCssOrXPathSelector(), item.getName()))),
                WaitUntil.the(ADD_BUTTON, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(ADD_BUTTON, isVisible()).forNoMoreThan(30).seconds().then(
                        Click.on(ADD_BUTTON))
        );
        tearDown();
        LOGGER.info("Se agregó el ítem '{}' exitosamente al carrito", item.getName());
        actor.attemptsTo(
                WaitUntil.the(HOME_BUTTON, isVisible()).forNoMoreThan(30).seconds().then(
                        Click.on(HOME_BUTTON))
        );
    }

    public static AddItem toTheShoppingCart(Item item) {
        return instrumented(AddItem.class, item);
    }

}
