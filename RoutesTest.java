import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by victor on 2017/03/22.
 */
class RoutesTest {
    @Test
    void addRoute() {
        Route roo = new Route("roo");
        assertTrue(addRoute(roo));
    }

    @Test
    void removeRoute() {
        Route roo = new Route("roo");
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
    void getRoutes() {
        GPSObject startGPS = new GPSObject("start");
        GPSObject destinationGPS = new GPSObject("destination");
        Location start = new Location("start", "1", startGPS);
        Location destination = new Location("destination", "2", destinationGPS);
        assertNotNull(getRoutes(start, destination));
    }

    @Test
    void getRoutes() {
        GPSObject startGPS = new GPSObject("start");
        GPSObject destinationGPS = new GPSObject("destination");
        Location start = new Location("start", "1", startGPS);
        Location destination = new Location("destination", "2", destinationGPS);
        assertNotNull(getPreferedRoute(start, destination));
    }

    @Test
    void savePreference() {
        assertTrue(savePreference());
    }

    @Test
    void modifyRoute() {
        Route roo = new Route("roo");
        assertNotNull(modifyRoute("roo"));
    }

}