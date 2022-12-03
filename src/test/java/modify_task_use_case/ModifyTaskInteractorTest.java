package modify_task_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessEvent;
import data_access.DataAccessTask;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Task Modification Interactor Test Cases.
 * @author Raghav Arora
 */
class ModifyTaskInteractorTest {
    private final static ModifyTaskInputData inputData1 = new ModifyTaskInputData(
            0,"Another Sample Task", "Sample Task"
    );

    private final static ModifyTaskInputData inputData2 = new ModifyTaskInputData(
            0,"New Sample Task", "Sample Task"
    );
    private final static ModifyTaskDataAccess dataAccess = new ModifyTaskDataAccess();
    private final static ModifyTaskDsGateway dsGateway = dataAccess;
    private final static ModifyTaskOutputBoundary outputBoundary = new ModifyTaskPresenter();
    private final static ModifyTaskInputBoundary inputBoundary = new ModifyTaskInteractor(
            outputBoundary, dsGateway
    );


    @Test
    public void testModifyTaskFailed(){
        // Initialize a week with a day instance which has a task named "Sample Task"
        DataAccessTask task1 = new DataAccessTask("Sample Task");
        DataAccessTask task2 = new DataAccessTask("Another Sample Task");
        HashMap<String, DataAccessTask> tasks = new HashMap<>();
        HashMap<String, DataAccessEvent > events = new HashMap<>();
        tasks.put("Sample Task", task1);
        tasks.put("Another Sample Task", task2);
        DataAccessDay day = new DataAccessDay(tasks, events);
        dataAccess.getDays().set(0, day);

        // Cannot change the title of "Sample Task" to "Another Sample Task"
        // because a Task by that name already exists for day 0!
        ModifyTaskOutputData outputData = inputBoundary.modifyTask(
                inputData1
        );
        assertEquals(
                "Task with name: 'Another Sample Task' already exists for Sunday",
                outputData.getErrorMessage()
        );
        assertFalse(outputData.getIsSuccessfullyModified());

        // Day 0 should continue to have a task called "Sample Task"
        DataAccessDay day0 = dataAccess.getDays().get(0);
        assertTrue(day0.getTasks().containsKey("Sample Task"));
    }

    @Test
    public void testModifyTaskSuccess() {
        // Initialize a week with a day instance which has a task named "Sample Task"
        DataAccessTask task = new DataAccessTask("Sample Task");
        HashMap<String, DataAccessTask> tasks = new HashMap<>();
        HashMap<String, DataAccessEvent > events = new HashMap<>();
        tasks.put("Sample Task", task);
        DataAccessDay day = new DataAccessDay(tasks, events);
        dataAccess.getDays().set(0, day);

        // Should be able to change the name of "Sample Task" to "New Sample Task"
        ModifyTaskOutputData outputData = inputBoundary.modifyTask(
                inputData2
        );
        assertEquals("", outputData.getErrorMessage());
        assertTrue(outputData.getIsSuccessfullyModified());

        // Day 0 should 1. not have a task named "Sample Task" and, 2. instead
        // have a task named "New Sample Task"
        DataAccessDay day0 = dataAccess.getDays().get(0);
        assertFalse(day0.getTasks().containsKey("Sample Task"));
        assertTrue(day0.getTasks().containsKey("New Sample Task"));
    }
}
