package store.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import store.models.UserData;
import store.tasks.AddItem;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static store.userinterfaces.CartPage.*;

public class Purchase implements Question<Boolean> {

    private final Logger LOGGER = LoggerFactory.getLogger(Purchase.class);
    private UserData userData;

    public Purchase(UserData userData) {
        this.userData = userData;
    }

    public static Purchase wasSuccessful(UserData userData) {
        return new Purchase(userData);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        LOGGER.info("Inicia confirmación de compra");
        actor.attemptsTo(
                WaitUntil.the(PURCHASE_MESSAGE, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(PURCHASE_TEXT, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(PURCHASE_MESSAGE, isPresent()).forNoMoreThan(30).seconds()
        );
        boolean messagePresence = actor.asksFor(Visibility.of(PURCHASE_MESSAGE));
        String[] purchaseText = actor.asksFor(Text.of(PURCHASE_TEXT)).split("\n");
        String purchaseAmountText = purchaseText[1].replace("Amount: ", "");
        String purchaseCardText = purchaseText[2].replace("Card Number: ", "");
        String purchaseNameText = purchaseText[3].replace("Name: ", "");
        boolean purchaseName = purchaseNameText.equals(userData.getUserName());
        boolean purchaseCard = purchaseCardText.equals(userData.getCreditCard());
        String expected = actor.recall("Expected amount");
        boolean purchaseAmount = purchaseAmountText.equals(expected);
        LOGGER.info("Finaliza el proceso de compra");
        return purchaseName && purchaseCard && purchaseAmount && messagePresence;
    }
}
