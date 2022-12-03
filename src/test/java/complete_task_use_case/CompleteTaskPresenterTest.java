package complete_task_use_case;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Task Completion Presenter Test Cases.
 * @author Fardin Faruk
 */
public class CompleteTaskPresenterTest {
    @Test
    public void TestPrepareSuccessView(){
        CompleteTaskOutputData completeTaskOutputData = new CompleteTaskOutputData("Test Task",  2);
        CompleteTaskPresenter completeTaskPresenter = new CompleteTaskPresenter();
        CompleteTaskOutputData outputData = completeTaskPresenter.prepareSuccessView(completeTaskOutputData);
        assertTrue(outputData.isSuccessfullyCompleted());
    }

    @Test
    public void TestPrepareFailView(){
        CompleteTaskOutputData completeTaskOutputData = new CompleteTaskOutputData("Test Task", 3);
        CompleteTaskPresenter completeTaskPresenter = new CompleteTaskPresenter();
        CompleteTaskOutputData outputData = completeTaskPresenter.prepareFailView(completeTaskOutputData,
                "There does not exist a task with name: 'Test Task' on Wednesday");
        assertFalse(outputData.isSuccessfullyCompleted());
        assertEquals(outputData.getErrorMessage(),
                "There does not exist a task with name: 'Test Task' on Wednesday");
    }
}
