package create_task_use_case;

import entities.Day;
import entities.Task;
import entities.TaskFactory;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Task Creation Interactor Test Cases.
 * @author Fardin Faruk
 */
public class CreateTaskInteractorTest {
    private final static CreateTaskOutputBoundary PRESENTER = new CreateTaskPresenter();
    private final static CreateTaskDataAccess DATA_ACCESS = new CreateTaskDataAccess();
    private final static TaskFactory TASK_FACTORY = new TaskFactory();
    @Test
    public void createTestSuccess(){
        CreateTaskInputData inputData = new CreateTaskInputData("Finish Unit Test", "Tuesday");
        CreateTaskInteractor createTaskInteractor = new CreateTaskInteractor(TASK_FACTORY, PRESENTER,
                DATA_ACCESS );
        CreateTaskOutputData createTaskOutputData = createTaskInteractor.create(inputData);
        Day day = DATA_ACCESS .getDays().get(2);
        HashMap<String, Task> tasks = day.getTasks();
        Task referenceTask = tasks.get("Finish Unit Test");
        assertTrue(createTaskOutputData.isSuccessfullyCreated());
        assertEquals(2, createTaskOutputData.getDayIndex());
        assertTrue(DATA_ACCESS.existsByTitle("Finish Unit Test", 2));
        assertEquals("Finish Unit Test", referenceTask.getTitle());
    }
    @Test
    public void createTestFail(){
        CreateTaskInputData inputData = new CreateTaskInputData("Update", "Tuesday");
        CreateTaskInteractor createTaskInteractor = new CreateTaskInteractor(TASK_FACTORY, PRESENTER,
                DATA_ACCESS);
        // Add Task twice to mock adding duplicate task on the same day
        createTaskInteractor.create(inputData);
        CreateTaskOutputData createTaskOutputData = createTaskInteractor.create(inputData);
        assertEquals("There already exists a task with name: 'Update' on Tuesday",
                createTaskOutputData.getErrorMessage());
    }
}
