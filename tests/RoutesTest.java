package Navigation.tests;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by victor on 2017/03/22.
 */
class RoutesTest {
    @Test
    void addRoute() {
        Navigation.Route roo = new Navigation.Route("roo");
        assertTrue(addRoute(roo));
    }

    @Test
    void removeRoute() {
        Navigation.Route roo = new Navigation.Route("roo");
        assertTrue(removeRoute(roo));
    }

    @Test
    void getRoute() {
        assertNotNull(getRoute("roo"));
    }

    @Test
    void search() {
        assertNotNull(search("roo"));
    }

    @Test
    void savePreference() {
    }

    @Test
    void modifyRoute() {
    }

}