package modify_task_use_case;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModifyTaskOutputBoundaryTest {
    // task and event instances (and maps) to be used across tests.
    private final static ModifyTaskOutputBoundary outputBoundary = new ModifyTaskPresenter();
    private final static ModifyTaskOutputData outputData = new ModifyTaskOutputData(
            "Sample Task", 0
    );
    private final static String error = "ERROR!";

    @Test
    public void testPrepareSuccessView(){
        ModifyTaskOutputData response = outputBoundary.prepareSuccessView(
                outputData
        );
        assertEquals(0, response.getDayID());
        assertEquals("Sample Task", response.getTitle());
    }

    @Test
    public void testPrepareFailView(){
        try {
            ModifyTaskOutputData response = outputBoundary.prepareFailView(
                    error
            );
        } catch (ModifyTaskFailed e) {
            assertEquals("ERROR!", e.getMessage());
        }
    }
}
