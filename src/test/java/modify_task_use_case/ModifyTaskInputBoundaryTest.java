package modify_task_use_case;

import entities.Day;
import entities.Event;
import entities.Task;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Task Modification Input Boundary Test Cases.
 * @author Raghav Arora
 */
public class ModifyTaskInputBoundaryTest {
    private final static ModifyTaskPresenter presenter = new ModifyTaskPresenter();
    private final static ModifyTaskOutputBoundary outputBoundary = presenter;
    private final static ModifyTaskDataAccess dataAccess = new ModifyTaskDataAccess();
    private final static ModifyTaskDsGateway dsGateway = dataAccess;

    private final static ModifyTaskInputBoundary inputBoundary = new ModifyTaskInteractor(
            outputBoundary, dsGateway
    );
    private final static ModifyTaskInputData inputData = new ModifyTaskInputData(
            0,"New Sample Task", "Sample Task"
    );

    @Test
    public void testModifyTask() {
        Task task = new Task("Sample Task");
        HashMap<String, Task> tasks = new HashMap<>();
        HashMap<String, Event> events = new HashMap<>();
        tasks.put("Sample Task", task);
        Day day = new Day(tasks, events);
        dataAccess.getDays().set(0, day);

        ModifyTaskOutputData outputData = inputBoundary.modifyTask(
                inputData
        );

        // Day 0 should not have a task named "Sample Task", and instead
        // have "New Sample Task"
        assertEquals("New Sample Task", outputData.getTitle());
        assertEquals(0, outputData.getDayIndex());
        Day day0 = dataAccess.getDays().get(0);
        assertFalse(day0.getTasks().containsKey("Sample Task"));
        assertTrue(day0.getTasks().containsKey("New Sample Task"));
    }
}
