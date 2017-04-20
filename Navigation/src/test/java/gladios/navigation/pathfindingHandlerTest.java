package gladios.navigation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Created by victor on 2017/04/20.
 */
class pathfindingHandlerTest {
    pathfindingHandler pathfindingHandler;
    @Test
    void calculatePath() {
        GPSObject n2 = new GPSObject("Centenary 6");
        Location n1 = new Location("Centenary 6","0",n2);
        GPSObject n3 = new GPSObject("Thuto 1-2");
        Location n4 = new Location("Thuto 1-2","1",n3);
        Locations loc = new Locations();
        loc.addLocation(n1);
        loc.addLocation(n4);
        assertNotNull(pathfindingHandler.calculatePath(loc));
    }

}