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
    @Override
    public boolean existsByTitle(String title, int dayIndex) {
        DataAccessDay referenceDay = days.get(dayIndex);
        HashMap<String, DataAccessTask> tasks = referenceDay.getTasks();
        return tasks.containsKey(title);
    }
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
