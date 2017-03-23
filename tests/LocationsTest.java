package Navigation.tests;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by victor on 2017/03/22.
 */
class LocationsTest {
    @Test
    void addLocation() {
        Navigation.GPSObject gpsObject = new Navigation.GPSObject("start");
        Navigation.Location location = new Navigation.Location("start", "1", gpsObject);
        addLocation(location);
    }

    @Test
    void modifyLocation() {
        Navigation.GPSObject obj = new Navigation.GPSObject("obj");
        Navigation.Location inLoc = new Navigation.Location("start", "1", obj);
        assertNotNull(modifyLocation(inLoc, "roo", "001", Navigation.GPSObject obj));
    }

    @Test
    void removeLocation() {
        Navigation.Location inLoc = new Navigation.Location("start", "1", obj);
        removeLocation(inLoc);
    }

}