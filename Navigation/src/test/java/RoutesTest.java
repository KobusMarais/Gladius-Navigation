import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import com.gladius.navup.navigation.*;

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
        roos.getRoute("roo");
    }

    @Test
    void search() {
        roos.search("roo");
    }

    @Test
    void getRoutes() {
        GPSObject n2 = new GPSObject("Centenary 2");
        Location n1 = new Location("Centenary 2","0",n2);
        GPSObject n3 = new GPSObject("Thuto 1-5");
        Location n4 = new Location("Thuto 1-5","1",n3);
        Locations loc = new Locations();
        assertNotNull(roos.getRoutes(loc));


    }

    @Test
    void getPreferedRoute() {
        GPSObject n2 = new GPSObject("Centenary 2");
        Location n1 = new Location("Centenary 2","0",n2);
        GPSObject n3 = new GPSObject("Thuto 1-5");
        Location n4 = new Location("Thuto 1-5","1",n3);
        Locations loc = new Locations();
        assertNotNull(roos.getPreferedRoute(loc));
    }

    @Test
    void savePreference() {
        assertTrue(roos.savePreference("ShortestRoute"));
    }

    @Test
    void modifyRoute() {
        Route roo = new Route("roo");
        assertNotNull(roos.modifyRoute(roo));
    }

}