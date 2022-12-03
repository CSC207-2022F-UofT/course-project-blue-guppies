package delete_task_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessEvent;
import data_access.DataAccessTask;
import entities.Task;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class DeleteTaskControllerTest {
    private final static DeleteTaskOutputBoundary outputBoundary = new DeleteTaskPresenter();
    private final static DeleteTaskDataAccess dataAccess = new DeleteTaskDataAccess();
    private final static DeleteTaskDsGateway dsGateway = dataAccess;
    private final static DeleteTaskInteractor inputBoundary = new DeleteTaskInteractor(outputBoundary, dsGateway);
    private final static DeleteTaskController controller = new DeleteTaskController(inputBoundary);
    private final static int dayIndex = 5;
    private final static String taskTitle = "Task";

    @Test
    void testDeleteTaskController() {
        DataAccessTask task = new DataAccessTask("Task");
        HashMap<String, DataAccessTask> tasks = new HashMap<>();
        HashMap<String, DataAccessEvent> events = new HashMap<>();
        tasks.put("Task", task);

        DataAccessDay day = new DataAccessDay(tasks, events);
        dataAccess.getDays().set(5, day);
        DeleteTaskOutputData outputData = controller.deleteTask(dayIndex, taskTitle);

        assertEquals(5, outputData.getDayIndex());
        assertEquals("Task", outputData.getTaskTitle());
        assertTrue(outputData.isSuccess());
        assertFalse(dataAccess.getDays().get(5).getTasks().containsKey("Task"));
        assertFalse(dataAccess.getDays().get(5).getTasks().containsValue(task));
    }
}
