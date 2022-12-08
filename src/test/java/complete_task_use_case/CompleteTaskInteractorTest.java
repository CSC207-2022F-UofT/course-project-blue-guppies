package complete_task_use_case;

import entities.Task;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintWriter;

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
        CompleteTaskInputData inputData = new CompleteTaskInputData(0, "Cricket", false);
        CompleteTaskOutputData outputData = interactor.completeTask(inputData);
        assertTrue(accessTask.getCompleted());
        assertTrue(outputData.isSuccessfullyCompleted());
    }
    @Test
    public void testFailCompleteTask(){
        DATA_ACCESS.getDays().get(0).getTasks().clear();
        CompleteTaskInteractor interactor = new CompleteTaskInteractor(PRESENTER, DATA_ACCESS);
        CompleteTaskInputData inputData = new CompleteTaskInputData(0, "Cricket", true);
        CompleteTaskOutputData outputData = interactor.completeTask(inputData);
        assertFalse(outputData.isSuccessfullyCompleted());
    }

    @AfterEach
    public void clearStorage(){
        try {
            PrintWriter pw = new PrintWriter("CleanCalendarStorage.txt"); //deleting the contents of the file
            pw.close();
        }
        catch(IOException e){
            return;
        }
    }
}
