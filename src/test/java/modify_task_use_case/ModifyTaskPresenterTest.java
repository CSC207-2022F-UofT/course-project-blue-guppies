package modify_task_use_case;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

/**
 * Task Modification Presenter Test Cases.
 * @author Raghav Arora
 */
class ModifyTaskPresenterTest {
    private final static ModifyTaskOutputData outputData = new ModifyTaskOutputData(
            "Sample Task", 0, "old sample task"
    );
    private final static String ERROR = "ERROR!";
    private final static ModifyTaskOutputBoundary outputBoundary = new ModifyTaskPresenter();

    @Test
    public void testPrepareSuccessView(){
        ModifyTaskOutputData response = outputBoundary.prepareSuccessView(
                outputData
        );
        assertEquals(0, response.getDayIndex());
        assertEquals("Sample Task", response.getTitle());
        assertEquals("old sample task", response.getOldTitle());
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
        assertEquals("old sample task", response.getOldTitle());
        assertEquals("ERROR!", response.getErrorMessage());
        assertFalse(response.getIsSuccessfullyModified());
    }
}
