package delete_task_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessEvent;
import data_access.DataAccessTask;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

class DeleteTaskDataAccessTest {

    private final static DeleteTaskDataAccess DATA_ACCESS = new DeleteTaskDataAccess();
    private final static DeleteTaskDsInputData INPUT_DATA = new DeleteTaskDsInputData(3, "Homework");

    @Test
    void testSave() {
        DataAccessTask task1 = new DataAccessTask("Homework");
        DataAccessTask task2 = new DataAccessTask("Test");
        HashMap<String, DataAccessTask> tasks = new HashMap<>();
        HashMap<String, DataAccessEvent> events = new HashMap<>();
        tasks.put("Homework", task1);
        tasks.put("Test", task2);
        DataAccessDay day = new DataAccessDay(tasks, events);
        DATA_ACCESS.getDays().set(3, day);
        DATA_ACCESS.save(INPUT_DATA);

        assertFalse(DATA_ACCESS.getDays().get(3).getTasks().containsKey("Homework"));
        assertTrue(DATA_ACCESS.getDays().get(3).getTasks().containsKey("Test"));
    }

    @Test
    void testTaskExistsInDay() {
        DataAccessTask task1 = new DataAccessTask("Homework");
        DataAccessTask task2 = new DataAccessTask("Test");
        HashMap<String, DataAccessTask> tasks = new HashMap<>();
        HashMap<String, DataAccessEvent> events = new HashMap<>();
        tasks.put("Homework", task1);
        tasks.put("Test", task2);
        DataAccessDay day = new DataAccessDay(tasks, events);
        DATA_ACCESS.getDays().set(3, day);

        assertTrue(DATA_ACCESS.taskExistsInDay(3, "Homework"));
        assertFalse(DATA_ACCESS.taskExistsInDay(3, "Clean Room"));
    }
}
