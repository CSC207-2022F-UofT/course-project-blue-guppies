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
        CompleteTaskOutputData createTaskOutputData = new CompleteTaskOutputData("Test Task",  2,
                "");
        CompleteTaskPresenter createTaskPresenter = new CompleteTaskPresenter();
        CompleteTaskOutputData outputData = createTaskPresenter.prepareSuccessView(createTaskOutputData);
        assertTrue(outputData.isSuccessfullyCreated);
    }
    @Test
    public void TestPrepareFailView(){
        CompleteTaskOutputData createTaskOutputData = new CompleteTaskOutputData("Test Task", 3,
                "");
        CompleteTaskPresenter createTaskPresenter = new CompleteTaskPresenter();
        CompleteTaskOutputData outputData = createTaskPresenter.prepareFailView(createTaskOutputData,
                "There does not exist a take with name: 'Test Task' on Wednesday");
        assertFalse(outputData.isSuccessfullyCreated);
        assertEquals(outputData.getErrorMessage(),
                "There does not exist a take with name: 'Test Task' on Wednesday");
    }
}
