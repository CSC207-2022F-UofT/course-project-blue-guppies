package create_task_use_case;

import entities.TaskFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreateTaskControllerTest {
    private final static CreateTaskPresenter createTaskPresenter = new CreateTaskPresenter();
    private final static CreateTaskDataAccess createTaskDataAccess = new CreateTaskDataAccess();
    private final static TaskFactory taskFactory = new TaskFactory();

    @Test
    public void testCreateTask(){
        CreateTaskInteractor createTaskInteractor = new CreateTaskInteractor(
                taskFactory, createTaskPresenter, createTaskDataAccess
        );
        CreateTaskController createTaskController = new CreateTaskController(createTaskInteractor);
        CreateTaskOutputData createTaskOutputData = createTaskController.createTask(
                "Sample Task", false, 0
        );
        assertEquals("Sample Task", createTaskOutputData.getTitle());
        //assertFalse(createTaskOutputData.isCompleted());
        assertEquals(0, createTaskOutputData.getDayID());
    }
}
