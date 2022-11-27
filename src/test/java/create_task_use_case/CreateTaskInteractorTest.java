package create_task_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessTask;
import entities.TaskFactory;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class CreateTaskInteractorTest {
    private final static CreateTaskOutputBoundary createTaskPresenter = new CreateTaskPresenter();
    private final static CreateTaskDataAccess createTaskDataAccess = new CreateTaskDataAccess();
    private final static TaskFactory taskFactory = new TaskFactory();
    @Test
    public void createTestSuccess(){
        CreateTaskInputData inputData = new CreateTaskInputData("Finish Unit Test", false, 3);
        CreateTaskInteractor createTaskInteractor = new CreateTaskInteractor(taskFactory, createTaskPresenter,
                createTaskDataAccess);
        CreateTaskOutputData createTaskOutputData = createTaskInteractor.create(inputData);
        DataAccessDay day = createTaskDataAccess.getDays().get(3);
        HashMap<String, DataAccessTask> tasks = day.getTasks();
        DataAccessTask refrenceTask = tasks.get("Finish Unit Test");
        assertTrue(createTaskOutputData.isSuccessfullyCreated());
        assertEquals(3, createTaskOutputData.getDayIndex());
        assertTrue(createTaskDataAccess.existsByTitle("Finish Unit Test", 3));
        assertEquals("Finish Unit Test", refrenceTask.getTitle());
    }
    @Test
    public void createTestFail(){
        CreateTaskInputData inputData = new CreateTaskInputData("Update", false, 3);
        CreateTaskInteractor createTaskInteractor = new CreateTaskInteractor(taskFactory, createTaskPresenter,
                createTaskDataAccess);
        // Add Task twice to mock adding duplicate task on the same day
        CreateTaskOutputData createTaskOutputDataTemp = createTaskInteractor.create(inputData);
        CreateTaskOutputData createTaskOutputData = createTaskInteractor.create(inputData);
        assertEquals("There already exists a task with name: 'Update' on Wednesday",
                createTaskOutputData.getErrorMessage());
    }
}
