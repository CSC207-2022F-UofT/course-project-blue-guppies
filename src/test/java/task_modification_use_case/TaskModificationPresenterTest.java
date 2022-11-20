package task_modification_use_case;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class TaskModificationPresenterTest {
    //task and event instances (and maps) to be used across tests.
    private final static TaskModificationOutputData outputData = new TaskModificationOutputData(
            "Sample Task", 0
    );
    private final static String error = "ERROR!";

    @Test
    public void testPrepareSuccessView(){
        TaskModificationOutputBoundary outputBoundary = new TaskModificationPresenter();
        TaskModificationOutputData response = outputBoundary.prepareSuccessView(
                outputData
        );
        assertEquals(0, response.getDayId());
        assertEquals("Sample Task", response.getTitle());
    }

    @Test
    public void testPrepareFailView(){
        TaskModificationOutputBoundary outputBoundary = new TaskModificationPresenter();
        try {
            TaskModificationOutputData response = outputBoundary.prepareFailView(
                    error
            );
        } catch (TaskModificationFailed e) {
            assertEquals("ERROR!", e.getMessage());
        }
    }
}
