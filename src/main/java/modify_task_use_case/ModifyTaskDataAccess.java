/**
 * Task Modification Data Access Class.
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 12, 2022
 * Last Modified: Nov 19, 2022
 */
package modify_task_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessTask;
import data_access.WeekDataAccess;
import java.util.HashMap;

public class ModifyTaskDataAccess extends WeekDataAccess implements ModifyTaskDsGateway {

    /**
     * Check whether a task with the given title already exists for the pertinent day.
     * Precondition: title is a non-empty string
     * @param title the title the user wants to change the name of a selected task to
     * @param dayID the ID of the day instance the selected task belongs to
     * @return whether there already exists a task in the given day with the same name
     */
    @Override
    public boolean taskExistsByTitle(String title, int dayID) {
        DataAccessDay day = this.getDays().get(dayID);
        return day.getTasks().containsKey(title);
    }

    @Override
    public void save(ModifyTaskDsInputData dsInputData) {
        String title = dsInputData.getTitle();
        String newTitle = dsInputData.getNewTitle();
        int dayID = dsInputData.getDayID();

        /* Remove the association of the task to be modified to key title, and instead
        associate it with newTitle */
        DataAccessDay day = this.getDays().get(dayID);
        HashMap<String, DataAccessTask> tasks = day.getTasks();
        DataAccessTask modifiedTask = tasks.remove(title);
        modifiedTask.setTitle(newTitle);
        tasks.put(newTitle, modifiedTask);

        // update the tasks for the given day
        day.setTasks(tasks);
        this.days.set(dayID, day);
        this.save();
    }
}
