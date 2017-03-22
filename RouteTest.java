import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by victor on 2017/03/22.
 */
class RouteTest {
    @Test
    void calculateRoute() {
        GPSObject gpsObjectStart = new GPSObject("start");
        GPSObject gpsObjectEnd = new GPSObject("end");
        Location start = new Location("start", "1", gpsObjectStart);
        Location end = new Location("end", "1", gpsObjectEnd);
        assertNotNull(calculateRoute(Location start, Location end));
    }

}