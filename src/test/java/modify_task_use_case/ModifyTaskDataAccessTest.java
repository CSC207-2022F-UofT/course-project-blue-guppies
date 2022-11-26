/**
 * Task Modification Data Access Test Cases.
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 19, 2022
 * Last Modified: Nov 26, 2022
 */
package modify_task_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessEvent;
import data_access.DataAccessTask;
import data_access.WeekDataAccess;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
class ModifyTaskDataAccessTest extends WeekDataAccess {
    private final static ModifyTaskDataAccess dsGateway = new ModifyTaskDataAccess();
    private final static ModifyTaskDsInputData dsInputData = new ModifyTaskDsInputData(
        0, "New Sample Task 1", "Sample Task 1"
    );

    @Test
    void testTaskExistsByTitle() {
        DataAccessTask task1 = new DataAccessTask("Sample Task 1");
        DataAccessTask task2 = new DataAccessTask("Sample Task 2");

        HashMap<String, DataAccessTask> tasks = new HashMap<>();
        HashMap<String, DataAccessEvent> events = new HashMap<>();
        tasks.put("Sample Task 1", task1);
        tasks.put("Sample Task 2", task2);

        DataAccessDay day = new DataAccessDay(tasks, events);
        days.set(0, day);

        assertFalse(dsGateway.taskExistsByTitle("New Sample Task 1", 0));
        assertTrue(dsGateway.taskExistsByTitle("Sample Task 2", 0));
    }

    @Test
    void testSave() {
        DataAccessTask task1 = new DataAccessTask("Sample Task 1");
        DataAccessTask task2 = new DataAccessTask("Sample Task 2");

        HashMap<String, DataAccessTask> tasks = new HashMap<>();
        HashMap<String, DataAccessEvent> events = new HashMap<>();
        tasks.put("Sample Task 1", task1);
        tasks.put("Sample Task 2", task2);

        DataAccessDay day = new DataAccessDay(tasks, events);
        days.set(0, day);

        // change the name of "Sample Task 1" to "New Sample Task 1"
        dsGateway.save(dsInputData);
        DataAccessDay day0 = this.getDays().get(0);
        assertFalse(day0.getTasks().containsKey("Sample Task 1"));
        assertTrue(day0.getTasks().containsKey("New Sample Task 1"));
    }
}
