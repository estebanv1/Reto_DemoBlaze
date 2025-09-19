package demoblaze.store;

import com.intuit.karate.junit5.Karate;

public class StoreRunner {

    @Karate.Test
    Karate StoreRunner() {
        return Karate.run("classpath:demoblaze/store/demoblaze.feature")//.tags("@")
        ;
    }
}
