package delete_task_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessEvent;
import data_access.DataAccessTask;
import data_access.WeekDataAccess;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeleteTaskInteractorTest extends WeekDataAccess {
    private final static DeleteTaskInputData inputData = new DeleteTaskInputData(
            5, "Task");

    private final static DeleteTaskPresenter outputBoundary = new DeleteTaskPresenter();
    private final static DeleteTaskDataAccess dataAccess = new DeleteTaskDataAccess();

    @Test
    void testDeleteTaskInteractor() {
        DataAccessTask task = new DataAccessTask("Task");
        HashMap<String, DataAccessTask> tasks = new HashMap<>();
        HashMap<String, DataAccessEvent> events = new HashMap<>();
        tasks.put("Task", task);
        DataAccessDay day = new DataAccessDay(tasks, events);
        WeekDataAccess.days.set(5, day);

        DeleteTaskInputBoundary inputBoundary = new DeleteTaskInteractor(outputBoundary, dataAccess);
        DeleteTaskOutputData outputData = inputBoundary.deleteTask(inputData);

        assertEquals(5, outputData.getDayIndex());
        assertEquals("Task", outputData.getTaskTitle());
        assertTrue(day.getTasks().isEmpty());
        assertTrue(outputData.getSuccess());
    }
}
