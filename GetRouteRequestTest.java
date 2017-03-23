import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by victor on 2017/03/22.
 */
class GetRouteRequestTest {

    @Test
    void getName() {
        Route roo = new Route("roo");
        getRouteRequest request = new getRouteRequest(roo);
        assertEquals("roo", request.getName());
    }

}