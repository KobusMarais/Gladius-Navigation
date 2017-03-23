import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by victor on 2017/03/22.
 */
class RoutesTest {

    Routes roos = new Routes();

    @Test
    void addRoute() {
        Route roo = new Route("roo");
        assertTrue(roos.addRoute(roo));
    }

    @Test
    void removeRoute() {
        Route roo = new Route("roo");
        assertTrue(roos.removeRoute(roo));
    }

    @Test
    void getRoute() {
        assertNotNull(roos.getRoute("roo"));
    }

    @Test
    void search() {
        assertNotNull(roos.search("roo"));
    }

    @Test
    void getRoutes() {
        ArrayList<Location> loc = new ArrayList<>();
        assertNotNull(roos.getRoutes(loc));
    }

    @Test
    void getPreferedRoute() {
        ArrayList<Location> loc = new ArrayList<>();
        assertNotNull(roos.getPreferedRoute(loc));
    }

    @Test
    void savePreference() {
        assertTrue(roos.savePreference());
    }

    @Test
    void modifyRoute() {
        Route roo = new Route("roo");
        assertNotNull(roos.modifyRoute(roo));
    }

}