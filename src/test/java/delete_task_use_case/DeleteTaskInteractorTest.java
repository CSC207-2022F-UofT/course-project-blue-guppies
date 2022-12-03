package delete_task_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessEvent;
import data_access.DataAccessTask;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeleteTaskInteractorTest {
    private final static DeleteTaskInputData inputData1 = new DeleteTaskInputData(
            5, "Task");
    private final static DeleteTaskInputData inputData2 = new DeleteTaskInputData(
            0,"Task2");
    private final static DeleteTaskDataAccess dataAccess = new DeleteTaskDataAccess();
    private final static DeleteTaskDsGateway dsGateway = dataAccess;
    private final static DeleteTaskPresenter outputBoundary = new DeleteTaskPresenter();

    @Test
    void testDeleteTaskSuccess() {
        DataAccessTask task = new DataAccessTask("Task");
        HashMap<String, DataAccessTask> tasks = new HashMap<>();
        HashMap<String, DataAccessEvent> events = new HashMap<>();
        tasks.put("Task", task);
        DataAccessDay day = new DataAccessDay(tasks, events);
        dataAccess.getDays().set(5, day);

        DeleteTaskInputBoundary inputBoundary = new DeleteTaskInteractor(outputBoundary, dsGateway);
        DeleteTaskOutputData outputData = inputBoundary.deleteTask(inputData1);

        assertEquals(5, outputData.getDayIndex());
        assertEquals("Task", outputData.getTaskTitle());
        assertFalse(dataAccess.getDays().get(5).getTasks().containsKey("Task"));
        assertFalse(dataAccess.getDays().get(5).getTasks().containsValue(task));
        assertTrue(outputData.isSuccess());
    }

    @Test
    void testDeleteTaskFail() {

        DataAccessTask task = new DataAccessTask("Task");
        HashMap<String, DataAccessTask> tasks = new HashMap<>();
        HashMap<String, DataAccessEvent> events = new HashMap<>();
        tasks.put("Task", task);
        DataAccessDay day = new DataAccessDay(tasks, events);
        dataAccess.getDays().set(5, day);

        DeleteTaskInputBoundary inputBoundary = new DeleteTaskInteractor(outputBoundary, dsGateway);
        DeleteTaskOutputData outputData = inputBoundary.deleteTask(inputData2);

        assertEquals("Task Title: \"Task2\" does not exist for day Sunday", outputData.getErrorMessage());
        assertFalse(outputData.isSuccess());
        assertTrue(dataAccess.getDays().get(5).getTasks().containsKey("Task"));
    }
}
