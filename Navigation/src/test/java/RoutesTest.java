import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import gladios.navigation.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by victor on 2017/03/22.
 */
class RoutesTest {

    Routes roos = new Routes();

    /**
     *
     * This test method sends new Route named "roo" as a parameter via addRoute() and returns a Boolean.
     * If returned Boolean is true - route has been successfully added.
     * If returned Boolean is false - route could not be added.
     */

    @Test
    void addRoute() {
        Route roo = new Route("roo");
        roos.addRoute(roo);
    }

    /**
     *
     * This test method sends new Route named "roo" as a parameter via removeRoute() and returns a Boolean.
     * If returned Boolean is true - route has been successfully removed.
     * If returned Boolean is false - route could not be removed.
     */

    @Test
    void removeRoute() {
        Route roo = new Route("roo");
        assertTrue(roos.removeRoute(roo));
    }

    /**
     *
     * This test method sends String "roo" as a parameter via getRoute() and returns a Route object or null.
     * If route with name "roo" is found - the Route object is returned, else null is returned.
     */

    @Test
    void getRoute() {
        roos.getRoute("roo");
    }

    /**
     *
     * This test method sends String "roo" as a parameter via search() and returns a Route object or null.
     * If route with name "roo" is found - the Route object is returned, else null is returned.
     */

    @Test
    void search() {
        //roos.search("roo");
    }

    /**
     *
     * This test method sends Locations object "loc" as a parameter via getRoutes() and returns an ArrayList<Route> or null.
     * If returned object is not null - an ArrayList containing valid routes have been found.
     */

    @Test
    void getRoutes() {
        GPSObject n2 = new GPSObject("Centenary 2");
        Location n1 = new Location("Centenary 2","0",n2);
        GPSObject n3 = new GPSObject("Thuto 1-5");
        Location n4 = new Location("Thuto 1-5","1",n3);
        Locations loc = new Locations();
        assertNotNull(roos.getRoutes(loc));
    }

    /**
     *
     * This test method sends Locations object "loc" as a parameter via getPreferedRoute() and returns a Locations object or null.
     * If returned object is not null - a valid Location object has been returned.
     */

    @Test
    void getPreferedRoute() {
        GPSObject n2 = new GPSObject("Centenary 2");
        Location n1 = new Location("Centenary 2","0",n2);
        GPSObject n3 = new GPSObject("Thuto 1-5");
        Location n4 = new Location("Thuto 1-5","1",n3);
        Locations loc = new Locations();
        assertNotNull(roos.getPreferedRoute(loc));
    }

    /**
     *
     * This test method sends String "ShortestRoute" as a parameter via savePreference() and returns a Boolean.
     * If returned Boolean is true - preference has been saved successfully.
     */

    @Test
    void savePreference() {
        assertTrue(roos.savePreference("ShortestRoute"));
    }

    /**
     *
     * This test method sends a new Route object named "roo" as a parameter and returns a Route object.
     * If returned object is not null - the route has been successfully modified.
     */

    @Test
    void modifyRoute() {
        Route roo = new Route("roo");
        assertNotNull(roos.modifyRoute(roo));
    }

}