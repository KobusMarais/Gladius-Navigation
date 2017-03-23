package Navigation.tests;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by victor on 2017/03/22.
 */
class GPSObjectTest {
    @Test
    void getCoords() {
        assertNotNull(getCoords("roo"));
    }

}