import org.junit.jupiter.api.Test;
import com.gladius.navup.navigation.*;
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
        GPSObject n2 = new GPSObject("Centenary 2");
        Location n1 = new Location("Centenary 2","0",n2);
        GPSObject n3 = new GPSObject("Thuto 1-5");
        Location n4 = new Location("Thuto 1-5","1",n3);
        Locations loc = new Locations();
        assertNotNull(roo.calculateRoute(loc));
    }

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