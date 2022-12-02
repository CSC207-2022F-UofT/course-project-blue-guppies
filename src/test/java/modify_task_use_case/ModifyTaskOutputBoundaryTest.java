package modify_task_use_case;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/** Task Modification Output Boundary Test Cases.
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 19, 2022
 * Last Modified: Dec 2, 2022
 */
public class ModifyTaskOutputBoundaryTest {
    // task and event instances (and maps) to be used across tests.
    private final static ModifyTaskOutputBoundary outputBoundary = new ModifyTaskPresenter();
    private final static ModifyTaskOutputData outputData = new ModifyTaskOutputData(
            "Sample Task", 0
    );
    private final static String ERROR = "ERROR!";

    @Test
    public void testPrepareSuccessView(){
        ModifyTaskOutputData response = outputBoundary.prepareSuccessView(
                outputData
        );
        assertEquals(0, response.getDayIndex());
        assertEquals("Sample Task", response.getTitle());
        assertEquals("", response.getErrorMessage());
        assertTrue(response.getIsSuccessfullyModified());
    }

    @Test
    public void testPrepareFailView(){
        ModifyTaskOutputData response = outputBoundary.prepareFailView(
                outputData, ERROR
        );
        assertEquals(0, response.getDayIndex());
        assertEquals("Sample Task", response.getTitle());
        assertEquals("ERROR!", response.getErrorMessage());
        assertFalse(response.getIsSuccessfullyModified());
    }
}
