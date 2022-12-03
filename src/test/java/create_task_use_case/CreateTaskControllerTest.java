package create_task_use_case;

import entities.TaskFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Task Creation Controller Test Cases.
 * @author Fardin Faruk
 */
public class CreateTaskControllerTest {
    private final static CreateTaskPresenter PRESENTER = new CreateTaskPresenter();
    private final static CreateTaskDataAccess DATA_ACCESS = new CreateTaskDataAccess();
    private final static TaskFactory TASK_FACTORY = new TaskFactory();

    @Test
    public void testCreateTask(){
        CreateTaskInteractor interactor = new CreateTaskInteractor(
                TASK_FACTORY, PRESENTER, DATA_ACCESS
        );
        CreateTaskController controller = new CreateTaskController(interactor);
        CreateTaskOutputData outputData = controller.createTask(
                "Sunday",  "Sampled Task"
        );
        assertEquals("Sampled Task", outputData.getTitle());
        assertEquals(0, outputData.getDayIndex());
        assertTrue(outputData.isSuccessfullyCreated());
        assertTrue(DATA_ACCESS.existsByTitle("Sampled Task", 0));
    }
}
