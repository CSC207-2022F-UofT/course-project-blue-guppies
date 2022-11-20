package modify_task_use_case;

import data_access.WeekDataAccess;
import entities.Day;
import entities.Event;
import entities.Task;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModifyTaskInteractorTest extends WeekDataAccess {
    private final static ModifyTaskInputData inputData = new ModifyTaskInputData(
            0,"New Sample Task", "Sample Task"
    );
    private final static ModifyTaskPresenter outputBoundary = new ModifyTaskPresenter();
    private final static ModifyTaskDataAccess dsGateway = new ModifyTaskDataAccess();


    @Test
    public void testModifyTask(){
        Task task = new Task("Sample Task");
        HashMap<String, Task> tasks = new HashMap<>();
        HashMap<String, Event> events = new HashMap<>();
        tasks.put("Sample Task", task);
        Day day = new Day(tasks, events);
        days.set(0, day);

        ModifyTaskInputBoundary inputBoundary = new ModifyTaskInteractor(
                outputBoundary, dsGateway
        );
        ModifyTaskOutputData outputData = inputBoundary.modifyTask(
                inputData
        );

        assertEquals("New Sample Task", outputData.getTitle());
        assertEquals(0, outputData.getDayId());
        assertEquals("New Sample Task", task.getTitle());
    }
}
