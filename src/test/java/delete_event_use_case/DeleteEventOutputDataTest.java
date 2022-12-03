package delete_event_use_case;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeleteEventOutputDataTest {
    private final static DeleteEventOutputData outputData = new DeleteEventOutputData(3, "CSC317 Mass Springs");

    @Test
    void testGetDayIndex() {
        assertEquals(3, outputData.getDayIndex());
    }

    @Test
    void testGetTaskTitle() {
        assertEquals("CSC317 Mass Springs", outputData.getLabel());
    }

    @Test
    void testGetSuccess() {
        assertFalse(outputData.getSuccess());
    }

    @Test
    void testSetSuccess() {
        outputData.setSuccess(true);
        assertTrue(outputData.getSuccess());
    }

    @Test
    void testGetErrorMessage() {
        assertNull(outputData.getErrorMessage());
    }

    @Test
    void testSetErrorMessage() {
        outputData.setErrorMessage("Error");
        assertEquals("Error", outputData.getErrorMessage());
    }
}