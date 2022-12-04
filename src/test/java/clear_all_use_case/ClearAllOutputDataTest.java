package clear_all_use_case;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

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
