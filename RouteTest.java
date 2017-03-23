import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by victor on 2017/03/22.
 */
class RouteTest {

    Route roo = new Route("roo");

    @Test
    void getName() {
        assertEquals("roo", roo.getName());
    }

    @Test
    void calculateRoute() {
        ArrayList<Location> path = new ArrayList<>();
        assertNotNull(roo.calculateRoute(path));
    }

    @Test
    void getLocations() {
        ArrayList<Location> path = new ArrayList<>();
        Route roo = new Route("roo", path);
        assertTrue(roo.getLocations().equals(path));
    }

}