package delete_event_use_case;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeleteEventOutputDataTest {
    private final static DeleteEventOutputData OUTPUT_DATA = new DeleteEventOutputData(3, "CSC317 Mass Springs");

    @Test
    void testGetDayIndex() {
        assertEquals(3, OUTPUT_DATA.getDayIndex());
    }

    @Test
    void testGetTaskTitle() {
        assertEquals("CSC317 Mass Springs", OUTPUT_DATA.getLabel());
    }

    @Test
    void testGetSuccess() {
        assertFalse(OUTPUT_DATA.getSuccess());
    }

    @Test
    void testSetSuccess() {
        OUTPUT_DATA.setSuccess(true);
        assertTrue(OUTPUT_DATA.getSuccess());
    }

    @Test
    void testGetErrorMessage() {
        assertNull(OUTPUT_DATA.getErrorMessage());
    }

    @Test
    void testSetErrorMessage() {
        OUTPUT_DATA.setErrorMessage("Error");
        assertEquals("Error", OUTPUT_DATA.getErrorMessage());
    }
}