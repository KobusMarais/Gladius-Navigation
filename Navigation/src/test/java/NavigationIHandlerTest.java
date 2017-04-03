import com.google.gson.*;
import org.junit.jupiter.api.Test;

import com.gladius.navup.navigation.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by victor on 2017/03/22.
 */
class NavigationIHandlerTest {

    NavigationIHandler navHandler = NavigationIHandler.getInstance();
    Route roo = new Route("roo");

    @Test
    void getRoute() throws NavigationExceptions {

        GPSObject n2 = new GPSObject("Centenary 6");
        Location n1 = new Location("Centenary 6","0",n2);
        GPSObject n3 = new GPSObject("Thuto 1-2");
        Location n4 = new Location("Thuto 1-2","1",n3);
        Locations loc = new Locations();
        loc.addLocation(n1);
        loc.addLocation(n4);
        assertNotNull(navHandler.getRoute(loc,"Centenary to Thuto"));

        System.out.println(navHandler.getRoute(loc,"Centenary to Thuto"));


    }

    @Test
    void accessRoute() {
        assertNotNull(navHandler.accessRoute("IT 4-4"));
    }

    @Test
    void deleteRoute() {
        assertNotNull(navHandler.deleteRoute("test2"));
    }

    @Test
    void recordRoute() {
        assertNotNull(navHandler.recordRoute(new Route("test3")));
    }

    @Test
    void saveRoute() {
        assertNotNull(navHandler.saveRoute(new Route("test4")));
    }

    @Test
    void modifyRoute() {
        assertNotNull(navHandler.modifyRoute(new Route("test5"),"test4"));
    }

    @Test
    void calculateRoute() {
        GPSObject n2 = new GPSObject("Centenary 6");
        Location n1 = new Location("Centenary 6","0",n2);
        GPSObject n3 = new GPSObject("Thuto 1-2");
        Location n4 = new Location("Thuto 1-2","1",n3);
        Locations loc = new Locations();
        assertNotNull(navHandler.calculateRoute(loc));

    }

    @Test
    void safePreferences() {
        assertTrue(navHandler.savePreferences("ShortestRoute"));
    }

}