package clear_all_use_case;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClearAllOutputDataTest {
    private final static ClearAllOutputData OUTPUT_DATA = new ClearAllOutputData();

    @Test
    void testGetSuccess() {
        assertFalse(OUTPUT_DATA.getSuccess());
    }

    @Test
    void testSetSuccess() {
        OUTPUT_DATA.setSuccess(true);
        assertTrue(OUTPUT_DATA.getSuccess());
    }
}
