import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by victor on 2017/03/22.
 */
class NavigationIHandlerTest {

    NavigationIHandler navHandler = new NavigationIHandler();
    Route roo = new Route("roo");
    getRouteRequest request = new getRouteRequest(roo);

    @Test
    void getRoute() {
        assertNotNull(navHandler.getRoute(request));
    }

    @Test
    void accessRoute() {
        assertNotNull(navHandler.accessRoute());
    }

    @Test
    void deleteRoute() {
        assertNotNull(navHandler.deleteRoute(request));
    }

    @Test
    void recordRoute() {
        assertNotNull(navHandler.recordRoute(request));
    }

    @Test
    void saveRoute() {
        assertNotNull(navHandler.saveRoute(request));
    }

    @Test
    void modifyRoute() {
        assertNotNull(navHandler.modifyRoute(request));
    }

    @Test
    void calculateRoute() {
        assertNotNull(navHandler.calculateRoute(request));
    }

    @Test
    void safePreferences() {
        assertTrue(navHandler.savePreferences());
    }

    @Test
    void navigation_Route() {
        JSONObject returnobj = new JSONObject();
        returnobj.put("origin","-25.756462,28.231124");
        returnobj.put("destination","-25.753815,28.228808");
        returnobj.put("travelMode","WALKING");
        JSONAssert.assertEquals(returnobj, navHandler.navigation_Route(request), false);
    }
}