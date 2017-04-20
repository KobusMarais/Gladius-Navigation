import org.junit.jupiter.api.Test;
import gladios.navigation.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by victor on 2017/03/22.
 */
class LocationsTest {
    @Test
    void addLocation() {
//        GPSObject gpsObject = new GPSObject("start");
//        Location location = new Location("start", "1", gpsObject);
//        addLocation(Location location);
    }

    /**
     *
     * This test method sends Location object 'inLoc' for modification via the modifyLocation() method from the locations class.
     * If successful, the method will return a new modified Location object.
     * If unsuccessful, the method will return null.
     */

    @Test
    void modifyLocation() {
        Locations locations = new Locations();
        GPSObject obj = new GPSObject("obj");
        Location inLoc = new Location("start", "1", obj);
        assertNotNull(locations.modifyLocation(inLoc, "location", "1", obj));
    }

    @Test
    void removeLocation() {
//        Location inLoc = new Location("start", "1", obj);
//        removeLocation(inLoc);
    }

}