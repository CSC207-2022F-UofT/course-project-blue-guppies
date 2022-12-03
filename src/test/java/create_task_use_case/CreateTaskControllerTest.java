package create_task_use_case;

import entities.TaskFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Task Creation Controller Test Cases.
 * @author Fardin Faruk
 */
public class CreateTaskControllerTest {
    private final static CreateTaskPresenter presenter = new CreateTaskPresenter();
    private final static CreateTaskDataAccess dataAccess = new CreateTaskDataAccess();
    private final static TaskFactory taskFactory = new TaskFactory();

    @Test
    public void testCreateTask(){
        CreateTaskInteractor interactor = new CreateTaskInteractor(
                taskFactory, presenter, dataAccess
        );
        CreateTaskController controller = new CreateTaskController(interactor);
        CreateTaskOutputData outputData = controller.createTask(
                "Sample Task",  "Sunday"
        );
        assertEquals("Sample Task", outputData.getTitle());
        assertEquals(0, outputData.getDayIndex());
        assertTrue(outputData.isSuccessfullyCreated());
        assertTrue(dataAccess.existsByTitle("Sample Task", 0));
    }
}
