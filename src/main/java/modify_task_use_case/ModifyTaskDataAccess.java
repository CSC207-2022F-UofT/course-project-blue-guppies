package modify_task_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessTask;
import data_access.WeekDataAccess;
import java.util.HashMap;

/** Task Modification Data Access Class. Implements methods specified by the DsGateway:
 * 1. checking whether we can change the name of a Task to the given (new) title and, 2.
 * mutating the days instance of WeekDataAccess to modify the name of the appropriate Task.
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 12, 2022
 * Last Modified: Dec 2, 2022
 */
public class ModifyTaskDataAccess extends WeekDataAccess implements ModifyTaskDsGateway {

    /** Check whether a Task with the given title already exists for the specified day.
     * Precondition: title is a non-empty string
     * @param title The title the user wants to change the name of a selected task to
     * @param dayIndex The ID of the day instance the selected task belongs to
     * @return whether there already exists a task in the given day with the same name
     */
    @Override
    public boolean taskExistsByTitle(String title, int dayIndex) {
        DataAccessDay day = days.get(dayIndex);
        return day.getTasks().containsKey(title);
    }

    /** Mutates the days instance attribute of the parent class WeekDataAccess by
     * modifying the tasks instance attribute of the Day object located at dayIndex. Then
     * invokes the save() method of parent class to save changes into a serializable file.
     * @param dsInputData Contains the dayIndex which contains the Task to be modified,
     * the existing title of the Task, and the new title of the task.
     */
    @Override
    public void save(ModifyTaskDsInputData dsInputData) {
        String title = dsInputData.getTitle();
        String newTitle = dsInputData.getNewTitle();
        int dayIndex = dsInputData.getDayIndex();

        /* Remove the association of the task to be modified to key title, and instead
        associate it with newTitle */
        DataAccessDay day = days.get(dayIndex);
        HashMap<String, DataAccessTask> tasks = day.getTasks();
        DataAccessTask modifiedTask = tasks.remove(title);
        modifiedTask.setTitle(newTitle);
        tasks.put(newTitle, modifiedTask);

        // update the tasks for the given day
        day.setTasks(tasks);
        days.set(dayIndex, day);
        super.save();
    }
}
