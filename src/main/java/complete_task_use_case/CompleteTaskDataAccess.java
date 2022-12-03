package complete_task_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessTask;
import data_access.WeekDataAccess;

import java.util.HashMap;

/**
 * Task Completion Data Access Class. Implements methods specified by the DsGateway:
 * Mutating a task and boolean reversing the completed attribute
 * @author Fardin Faruk
 */

public class CompleteTaskDataAccess extends WeekDataAccess implements CompleteTaskDsGateway {
    /**
     * @param title The title of the task will have their completed attribute mutated
     * @param dayIndex The index of the Day object where the task will be contained.
     * @return whether there are already an existing task of the same name in the dayIndex day
     */
    @Override
    public boolean existsByTitle(String title, int dayIndex) {
        DataAccessDay referenceDay = days.get(dayIndex);
        HashMap<String, DataAccessTask> tasks = referenceDay.getTasks();
        return tasks.containsKey(title);
    }
    /**
     * Mutates completed attribute of a task in the day instance of the parent class WeekDataAccess and
     * Then invokes the save() method of parent class to save changes into a serializable file.
     * @param dsInputData instance which contains the dayIndex of the Day object
     * containing the Task to be added to the correct day.
     */
    @Override
    public void save(CompleteTaskDsInputData dsInputData) {
        int dayIndex = dsInputData.getDayIndex();
        DataAccessDay day = this.getDays().get(dayIndex);
        HashMap<String, DataAccessTask> tasksList = day.getTasks();
        DataAccessTask task = tasksList.get(dsInputData.getTitle());
        task.setCompleted(!task.getCompleted());
        super.save();
    }
}