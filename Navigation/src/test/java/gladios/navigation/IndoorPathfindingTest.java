package gladios.navigation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by victor on 2017/04/20.
 */
class IndoorPathfindingTest {
    IndoorPathfinding in = new IndoorPathfinding();
    @Test
    void findIndoor() {
        GPSObject n2 = new GPSObject("Centenary 6");
        Location n1 = new Location("Centenary 6","0",n2);
        GPSObject n3 = new GPSObject("Thuto 1-2");
        Location n4 = new Location("Thuto 1-2","1",n3);
        Locations loc = new Locations();
        loc.addLocation(n1);
        loc.addLocation(n4);
        assertNotNull(in.findIndoor(loc));
    }

    @Test
    void distanceBetweenTwoPoints() {
        assertEquals(0.002018205588683486,in.distanceBetweenTwoPoints((float)-25.756001,(float)28.233321,(float)-25.754001,(float)28.233042));
    }

    @Test
    void arePointsOnSamePlane() {
        assertTrue(in.arePointsOnSamePlane("3","3"));
    }

    @Test
    void heightDifference() {
        assertEquals(in.heightDifference("3","1"),2);
    }

    @Test
    void isPointInvalid() {
        assertFalse(in.isPointInvalid((float)-25.756001,(float)28.233321,(float)-25.754001,(float)28.233042,(float)-25.854001,(float)28.333042));
    }

    @Test
    void createDefaultRoute() {
        ArrayList<ArrayList<Float>> temp = new ArrayList<ArrayList<Float>>(0);
        assertNotNull(in.createDefaultRoute((float)-25.756001,(float)28.233321,(float)-25.754001,(float)28.233042,(float)-25.854001,(float)28.333042,temp));
    }

    @Test
    void addStaircase() {
        assertNotNull(in.addStaircase());
    }

}