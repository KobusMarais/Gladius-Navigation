import com.google.gson.*;
import org.junit.jupiter.api.Test;

import com.gladius.navup.navigation.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by victor on 2017/03/22.
 */
class NavigationIHandlerTest {

    NavigationIHandler navHandler = NavigationIHandler.getInstance();
    //Route roo = new Route("roo");

    /**
     *
     * This test method sends Location object 'loc' and String n "Centenary to Thuto" as parameters to retrieve a corresponding route.
     * If successful, the method will return a JSON String that contains a route.
     * If unsuccessful, the method will throw IncompleteInformation().
     *
     * @throws NavigationExceptions - IncompleteInformation()
     */

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

        GsonBuilder b = new GsonBuilder();
        Gson g = b.create();

        String[] str = {"IT 4-1","Centenary 4"};


        System.out.println(navHandler.getRoute(g.toJson(str)));


    }

    /**
     *
     * This test method sends String rN "IT 4-4" as a parameter and returns a new Route object.
     */

    @Test
    void accessRoute() {
        assertNotNull(navHandler.accessRoute("IT 4-4"));
    }

    /**
     *
     * This test method sends String rt "test2" as a parameter and returns a Boolean.
     * If returned Boolean is true - route has been successfully deleted.
     * If returned Boolean is false - route deletion was unsuccessful.
     */

    @Test
    void deleteRoute() {
        assertNotNull(navHandler.deleteRoute("test2"));
    }

    /**
     *
     * This test method sends String rN "test3" as a parameter and returns a Boolean.
     * If returned Boolean is true - route has been successfully recorded.
     * If returned Boolean is false - route could not be recorded.
     */

    @Test
    void recordRoute() {
        assertNotNull(navHandler.recordRoute(new Route("test3")));
    }

    /**
     *
     * This test method sends a new Route object named "test4" to be saved and returns a new Routes object with Route object "test4" added.
     */

    @Test
    void saveRoute() {
        assertNotNull(navHandler.saveRoute(new Route("test4")));
    }

    /**
     *
     * This test method sends a new Route object named "test5" and String rN "test4" and returns a Boolean.
     * "test5" will replace "test4"
     * If returned Boolean is true - route has been successfully modified.
     * If returned Boolean is false - route could not be modified.
     */

    @Test
    void modifyRoute() {
        assertNotNull(navHandler.modifyRoute(new Route("test5"),"test4"));
    }

    /**
     *
     * This test method sends Locations object "loc", calculates route and returns a new Routes object.
     */

    @Test
    void calculateRoute() {
        GPSObject n2 = new GPSObject("Centenary 6");
        Location n1 = new Location("Centenary 6","0",n2);
        GPSObject n3 = new GPSObject("Thuto 1-2");
        Location n4 = new Location("Thuto 1-2","1",n3);
        Locations loc = new Locations();
        assertNotNull(navHandler.calculateRoute(loc));

    }

    /**
     *
     * This test method sends String "ShortestRoute" as a parameter, saves it as the shortest route and returns a Boolean.
     * If returned Boolean is true - preference has been saved successfully.
     * If returned Boolean is false - preference could not be saved.
     */

    @Test
    void safePreferences() {
        assertTrue(navHandler.savePreferences("ShortestRoute"));
    }

}