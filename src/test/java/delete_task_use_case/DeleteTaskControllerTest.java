package delete_task_use_case;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeleteTaskControllerTest {
    private final static DeleteTaskPresenter outputBoundary = new DeleteTaskPresenter();
    private final static DeleteTaskDataAccess dsGateway = new DeleteTaskDataAccess();
    private final static int dayIndex = 5;
    private final static String taskTitle = "Task";

    @Test
    public void testDeleteTask() {
        DeleteTaskInteractor inputBoundary = new DeleteTaskInteractor(outputBoundary, dsGateway);
        DeleteTaskController controller = new DeleteTaskController(inputBoundary);
        DeleteTaskOutputData outputData = controller.deleteTask(dayIndex, taskTitle);

        assertEquals(5, outputData.getInputDay());
        assertEquals("Task", outputData.getLabel());
    }
}