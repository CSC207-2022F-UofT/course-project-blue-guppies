package modify_task_use_case;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/** Task Modification Output Data Test Cases.
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 26, 2022
 * Last Modified: Dec 2, 2022
 */
public class ModifyTaskOutputDataTest {
    private final static ModifyTaskOutputData outputData = new ModifyTaskOutputData(
            "Title", 0
    );

    @Test
    void testGetTitle() {
        assertEquals("Title", outputData.getTitle());
    }

    @Test
    void testGetDayID() {
        assertEquals(0, outputData.getDayIndex());
    }

    @Test
    void getErrorMessage() {
        outputData.setErrorMessage("");
        assertEquals("", outputData.getErrorMessage());
    }

    @Test
    void setErrorMessage() {
        outputData.setErrorMessage("");
        assertNotEquals("ERROR!", outputData.getErrorMessage());
        outputData.setErrorMessage("ERROR!");
        assertEquals("ERROR!", outputData.getErrorMessage());
    }

    @Test
    void getIsSuccessfullyModified() {
        outputData.setSuccessfullyModified(true);
        assertTrue(outputData.getIsSuccessfullyModified());
    }

    @Test
    void setSuccessfullyModified() {
        outputData.setSuccessfullyModified(false);
        assertFalse(outputData.getIsSuccessfullyModified());
        outputData.setSuccessfullyModified(false);
        assertFalse(outputData.getIsSuccessfullyModified());
    }
}
