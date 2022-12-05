package complete_task_use_case;

import entities.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Task Completion Interactor Test Cases.
 * @author Fardin Faruk
 */
public class CompleteTaskInteractorTest {
    public final static CompleteTaskOutputBoundary PRESENTER = new CompleteTaskPresenter();
    public final static CompleteTaskDataAccess DATA_ACCESS = new CompleteTaskDataAccess();

    @Test
    public void testSuccessCompleteTask(){
        Task accessTask = new Task("Cricket");
        DATA_ACCESS.getDays().get(0).getTasks().put(accessTask.getTitle(),accessTask);
        CompleteTaskInteractor interactor = new CompleteTaskInteractor(PRESENTER, DATA_ACCESS);
        CompleteTaskInputData inputData = new CompleteTaskInputData(0, "Cricket", taskCompleted);
        CompleteTaskOutputData outputData = interactor.completeTask(inputData);
        assertTrue(accessTask.getCompleted());
        assertTrue(outputData.isSuccessfullyCompleted());
    }
    @Test
    public void testFailCompleteTask(){
        Task accessTask = new Task("Cricket1");
        DATA_ACCESS.getDays().get(0).getTasks().clear();
        CompleteTaskInteractor interactor = new CompleteTaskInteractor(PRESENTER, DATA_ACCESS);
        CompleteTaskInputData inputData = new CompleteTaskInputData(0, "Cricket", taskCompleted);
        CompleteTaskOutputData outputData = interactor.completeTask(inputData);
        assertFalse(outputData.isSuccessfullyCompleted());
    }
}
