package delete_task_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessTask;
import data_access.WeekDataAccess;
import java.util.HashMap;

/**
 * Implements the save and taskExistsInDay methods in DeleteTaskDsGateway. Save method mutates day instance
 * attribute of WeekDataAccess by deleting the taskTitle of the given day. TaskExistsInDay method checks whether
 * the Task exists in the given day for deletion.
 * @author Ricky Fung
 */
public class DeleteTaskDataAccess extends WeekDataAccess implements DeleteTaskDsGateway {

    /**
     * Mutates the day instance attribute of the parent class WeekDataAccess by removing
     * the Tasks instance attribute of the Day object located at dayIndex. This then invokes
     * the save() method of the parent class to save changes to serializable file.
     *
     * @param dsInputData Contains the day index which contains the Task to be deleted
     *                    and the title of the Task.
     */
    @Override
    public void save(DeleteTaskDsInputData dsInputData) {
        DataAccessDay day = days.get(dsInputData.getDayIndex());
        HashMap<String, DataAccessTask> tasks = day.getTasks();
        DataAccessTask deleted = tasks.remove(dsInputData.getTaskTitle());
        super.save();
    }

    /**
     *  Checks whether the task exists of the specified day index.
     * @param dayIndex The index of the day instance the task belongs to.
     * @param taskTitle The title of the task user wants to remove.
     * @return True if the task exists in the given day, false otherwise.
     */
    @Override
    public boolean taskExistsInDay(int dayIndex, String taskTitle) {
        return days.get(dayIndex).getTasks().containsKey(taskTitle);
    }
}
