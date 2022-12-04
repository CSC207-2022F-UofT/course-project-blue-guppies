package modify_task_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessEvent;
import data_access.DataAccessTask;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Task Modification Controller Test Cases.
 * @author Raghav Arora
 */
public class ModifyTaskControllerTest {
    private final static ModifyTaskOutputBoundary outputBoundary = new ModifyTaskPresenter();
    private final static ModifyTaskDataAccess dataAccess = new ModifyTaskDataAccess();
    private final static ModifyTaskDsGateway dsGateway = dataAccess;
    private final static ModifyTaskInputBoundary inputBoundary = new ModifyTaskInteractor(
            outputBoundary, dsGateway
    );
    private final static ModifyTaskController controller = new ModifyTaskController(inputBoundary);
    private final static int dayId = 0;
    private final static String newTitle = "New Sample Task";
    private final static String title = "Sample Task";

    @Test
    public void testModifyTask() {
        DataAccessTask task = new DataAccessTask("Sample Task");
        HashMap<String, DataAccessTask> tasks = new HashMap<>();
        HashMap<String, DataAccessEvent> events = new HashMap<>();
        tasks.put("Sample Task", task);
        DataAccessDay day = new DataAccessDay(tasks, events);
        dataAccess.getDays().set(0, day);


        ModifyTaskOutputData outputData = controller.modifyTask(
                dayId, newTitle, title
        );

        // Day 0 should not have a task named "Sample Task", and instead
        // have "New Sample Task"
        assertEquals(0, outputData.getDayIndex());
        assertEquals("New Sample Task", outputData.getTitle());
        DataAccessDay day0 = dataAccess.getDays().get(0);
        assertFalse(day0.getTasks().containsKey("Sample Task"));
        assertTrue(day0.getTasks().containsKey("New Sample Task"));
    }
}
