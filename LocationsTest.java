import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by victor on 2017/03/22.
 */
class LocationsTest {
    @Test
    void addLocation() {
        GPSObject gpsObject = new GPSObject("start");
        Location location = new Location("start", "1", gpsObject);
        addLocation(Location location);
    }

    @Test
    void modifyLocation() {
        GPSObject obj = new GPSObject("obj");
        Location inLoc = new Location("start", "1", obj);
        assertNotNull(modifyLocation(inLoc, "roo", "001", GPSObject obj));
    }

    @Test
    void removeLocation() {
        Location inLoc = new Location("start", "1", obj);
        removeLocation(inLoc);
    }

}