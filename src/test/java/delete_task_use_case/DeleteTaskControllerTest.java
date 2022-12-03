package delete_task_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessEvent;
import data_access.DataAccessTask;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class DeleteTaskControllerTest {
    private final static DeleteTaskOutputBoundary OUTPUT_BOUNDARY = new DeleteTaskPresenter();
    private final static DeleteTaskDataAccess DATA_ACCESS = new DeleteTaskDataAccess();
    private final static DeleteTaskDsGateway DS_GATEWAY = DATA_ACCESS;
    private final static DeleteTaskInteractor INPUT_BOUNDARY = new DeleteTaskInteractor(OUTPUT_BOUNDARY, DS_GATEWAY);
    private final static DeleteTaskController CONTROLLER = new DeleteTaskController(INPUT_BOUNDARY);
    private final static int DAY_INDEX = 5;
    private final static String TASK_TITLE = "Task";

    @Test
    void testDeleteTaskController() {
        DataAccessTask task = new DataAccessTask("Task");
        HashMap<String, DataAccessTask> tasks = new HashMap<>();
        HashMap<String, DataAccessEvent> events = new HashMap<>();
        tasks.put("Task", task);

        DataAccessDay day = new DataAccessDay(tasks, events);
        DATA_ACCESS.getDays().set(5, day);
        DeleteTaskOutputData outputData = CONTROLLER.deleteTask(DAY_INDEX, TASK_TITLE);

        assertEquals(5, outputData.getDayIndex());
        assertEquals("Task", outputData.getTaskTitle());
        assertTrue(outputData.isSuccess());
        assertFalse(DATA_ACCESS.getDays().get(5).getTasks().containsKey("Task"));
        assertFalse(DATA_ACCESS.getDays().get(5).getTasks().containsValue(task));
    }
}
