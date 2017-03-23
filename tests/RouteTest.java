package Navigation.tests;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by victor on 2017/03/22.
 */
class RouteTest {
    @Test
    void calculateRoute() {
        Navigation.GPSObject gpsObjectStart = new Navigation.GPSObject("start");
        Navigation.GPSObject gpsObjectEnd = new Navigation.GPSObject("end");
        Navigation.Location start = new Navigation.Location("start", "1", gpsObjectStart);
        Navigation.Location end = new Navigation.Location("end", "1", gpsObjectEnd);
        assertNotNull(calculateRoute(Navigation.Location start,Navigation.Location end));
    }

}