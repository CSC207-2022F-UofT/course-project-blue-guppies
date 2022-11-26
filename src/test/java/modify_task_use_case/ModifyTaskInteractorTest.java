/**
 * Task Modification Interactor Test Cases.
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

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ModifyTaskInteractorTest extends WeekDataAccess {
    private final static ModifyTaskInputData inputData1 = new ModifyTaskInputData(
            0,"New Sample Task", "Sample Task"
    );
    private final static ModifyTaskInputData inputData2 = new ModifyTaskInputData(
            0,"Another Sample Task", "Sample Task"
    );

    private final static ModifyTaskPresenter outputBoundary = new ModifyTaskPresenter();
    private final static ModifyTaskDataAccess dsGateway = new ModifyTaskDataAccess();
    private final static ModifyTaskInteractor inputBoundary = new ModifyTaskInteractor(
            outputBoundary, dsGateway
    );


    @Test
    public void testModifyTaskSuccess(){
        // Initialize a week with a day instance which has a task named "Sample Task"
        DataAccessTask task1 = new DataAccessTask("Sample Task");
        DataAccessTask task2 = new DataAccessTask("Another Sample Task");
        HashMap<String, DataAccessTask> tasks = new HashMap<>();
        HashMap<String, DataAccessEvent > events = new HashMap<>();
        tasks.put("Sample Task", task1);
        tasks.put("Another Sample Task", task2);
        DataAccessDay day = new DataAccessDay(tasks, events);
        days.set(0, day);

        // Cannot change the title of "Sample Task" to "Another Sample Task"
        // because a Task by that name already exists for day 0!
        try {
            ModifyTaskOutputData outputData = inputBoundary.modifyTask(
                    inputData2
            );
        } catch (ModifyTaskFailed e) {
            assertEquals(
                    "Task with name: Another Sample Task already exists for day 0",
                    e.getMessage()
            );
        }

        // Day 0 should continue to have a task called "Sample Task"
        DataAccessDay day0 = this.getDays().get(0);
        assertTrue(day0.getTasks().containsKey("Sample Task"));
    }

    @Test
    public void testModifyTaskFailed() {
        // Initialize a week with a day instance which has a task named "Sample Task"
        DataAccessTask task = new DataAccessTask("Sample Task");
        HashMap<String, DataAccessTask> tasks = new HashMap<>();
        HashMap<String, DataAccessEvent > events = new HashMap<>();
        tasks.put("Sample Task", task);
        DataAccessDay day = new DataAccessDay(tasks, events);
        days.set(0, day);
    }
}
