package modify_task_use_case;

import entities.Day;
import entities.Event;
import entities.Task;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import org.junit.jupiter.api.AfterEach;
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
        Task task1 = new Task("Sample Task");
        Task task2 = new Task("Another Sample Task");
        HashMap<String, Task> tasks = new HashMap<>();
        HashMap<String, Event> events = new HashMap<>();
        tasks.put("Sample Task", task1);
        tasks.put("Another Sample Task", task2);
        Day day = new Day(tasks, events);
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
        Day day0 = dataAccess.getDays().get(0);
        assertTrue(day0.getTasks().containsKey("Sample Task"));
    }

    @Test
    public void testModifyTaskSuccess() {
        // Initialize a week with a day instance which has a task named "Sample Task"
        Task task = new Task("Sample Task");
        HashMap<String, Task> tasks = new HashMap<>();
        HashMap<String, Event> events = new HashMap<>();
        tasks.put("Sample Task", task);
        Day day = new Day(tasks, events);
        dataAccess.getDays().set(0, day);

        // Should be able to change the name of "Sample Task" to "New Sample Task"
        ModifyTaskOutputData outputData = inputBoundary.modifyTask(
                inputData2
        );
        assertEquals("", outputData.getErrorMessage());
        assertTrue(outputData.getIsSuccessfullyModified());

        // Day 0 should 1. not have a task named "Sample Task" and, 2. instead
        // have a task named "New Sample Task"
        Day day0 = dataAccess.getDays().get(0);
        assertFalse(day0.getTasks().containsKey("Sample Task"));
        assertTrue(day0.getTasks().containsKey("New Sample Task"));
    }

    @AfterEach
    public void clearStorage(){
        try {
            PrintWriter pw = new PrintWriter("CleanCalendarStorage.txt"); //deleting the contents of the file
            pw.close();
        }
        catch(IOException e){
            return;
        }
    }
}
