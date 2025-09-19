package store.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Visibility;

import static store.userinterfaces.CartPage.CART_ITEM_NAME;
import static store.userinterfaces.DemoblazeHomePage.CART_BUTTON;

public class TheItem implements Question<Boolean> {

    private String item;

    public TheItem(String item) {
        this.item = item;
    }

    public static TheItem isPresent(String item) {
        return new TheItem(item);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                Click.on(CART_BUTTON)
        );
        return actor.asksFor(Visibility.of(
                String.format(CART_ITEM_NAME.getCssOrXPathSelector(), item)));
    }
}
