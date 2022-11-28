package delete_task_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessEvent;
import data_access.DataAccessTask;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

class DeleteTaskDataAccessTest {

    DeleteTaskDataAccess dataAccess = new DeleteTaskDataAccess();
    DeleteTaskDsInputData inputData = new DeleteTaskDsInputData(3, "Homework");

    @Test
    void testSave() {
        DataAccessTask task1 = new DataAccessTask("Homework");
        DataAccessTask task2 = new DataAccessTask("Test");
        HashMap<String, DataAccessTask> tasks = new HashMap<>();
        HashMap<String, DataAccessEvent> events = new HashMap<>();
        tasks.put("Homework", task1);
        tasks.put("Test", task2);
        DataAccessDay day = new DataAccessDay(tasks, events);
        dataAccess.getDays().set(3, day);
        dataAccess.save(inputData);

        assertFalse(dataAccess.getDays().get(3).getTasks().containsKey("Homework"));
        assertTrue(dataAccess.getDays().get(3).getTasks().containsKey("Test"));
    }
}
