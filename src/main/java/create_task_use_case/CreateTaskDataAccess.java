package create_task_use_case;

import data_access.WeekDataAccess;
import entities.Day;
import entities.Task;

import java.util.HashMap;

/**
 * Task Creation Data Access Class. Implements methods specified by the DsGateway:
 * 1. Checking whether we can add a Task to the given dayIndex and,
 * 2. Mutating the days instance of WeekDataAccess to add a Task to the intended day.
 *
 * @author Fardin Faruk
 */

public class CreateTaskDataAccess extends WeekDataAccess implements CreateTaskDsGateway {

    /**
     * @param title    The title of the task will be created
     * @param dayIndex The index of the Day object where the task will be contained.
     * @return whether there are already an existing task of the same name in the dayIndex day
     */
    @Override
    public boolean existsByTitle(String title, int dayIndex) {
        Day referenceDay = days.get(dayIndex);
        HashMap<String, Task> tasks = referenceDay.getTasks();
        return tasks.containsKey(title);
    }


    /**
     * Inserts a new task in the day instance attribute of the parent class WeekDataAccess by
     * Then invokes the save() method of parent class to save changes into a serializable file.
     *
     * @param taskData instance which contains the dayIndex of the Day object
     *                 containing the Task to be added to the correct day.
     */
    @Override
    public void save(CreateTaskDsInputData taskData) {
        Day referenceDay = days.get(taskData.getDayIndex());
        HashMap<String, Task> tasks = referenceDay.getTasks();
        Task newTask = taskData.getTask();
        tasks.put(newTask.getTitle(), newTask);
        super.save();
    }
}
