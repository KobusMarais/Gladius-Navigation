import org.junit.jupiter.api.Test;
import gladios.navigation.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by victor on 2017/03/22.
 */
class RouteTest {

    Route roo = new Route("roo");

    /**
     *
     * This test method uses getName() to return the name of Route object "roo" and compares it to String "roo".
     * If these Strings match, the test was successful.
     */

    @Test
    void getName() {
        assertEquals("roo", roo.getName());
    }

    /**
     *
     * This test method sends Locations object "loc" as a parameter via calculateRoute(),
     * calculates the route and returns a new Locations object or null.
     * If returned object is not null - a Locations object containing wayPoints is returned.
     */

    @Test
    void calculateRoute() {
        GPSObject n2 = new GPSObject("Centenary 2");
        Location n1 = new Location("Centenary 2","0",n2);
        GPSObject n3 = new GPSObject("Thuto 1-5");
        Location n4 = new Location("Thuto 1-5","1",n3);
        Locations loc = new Locations();
        assertNotNull(roo.calculateRoute(loc));
    }

    /**
     *
     * This test method uses getLocations() that returns a Locations object and compares it to loc.
     * If these objects match, the test was successful.
     */

    @Test
    void getLocations() {
        GPSObject n2 = new GPSObject("Centenary 1");
        Location n1 = new Location("Centenary 1","0",n2);
        GPSObject n3 = new GPSObject("Thuto 1");
        Location n4 = new Location("Thuto 1","1",n3);
        Locations loc = new Locations();
        Route roo = new Route("roo", loc);
        assertTrue(roo.getLocations().equals(loc));
    }

}