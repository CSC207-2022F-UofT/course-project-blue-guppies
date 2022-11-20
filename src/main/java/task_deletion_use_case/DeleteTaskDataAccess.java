/**
 * Delete Task DataAccess Class.
 * Author: Ricky Fung
 * Modified By: Ricky Fung
 * Created: Nov 19, 2022
 * Last Modified: Nov 19, 2022
 */
package task_deletion_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessTask;
import data_access.WeekDataAccess;

import java.util.HashMap;

public class DeleteTaskDataAccess extends WeekDataAccess implements DeleteTaskDsGateway {

    @Override
    public boolean taskExists(int dayIndex, String taskTitle) {
        DataAccessDay day = super.getDays().get(dayIndex);
        return day.getTasks().containsKey(taskTitle);
    }

    @Override
    public void save(DeleteTaskDataAccessInput dataAccessInput) {
        int dayIndex = dataAccessInput.getDayIndex();
        String taskTitle = dataAccessInput.getTaskTitle();

        DataAccessDay day = super.getDays().get(dayIndex);
        HashMap<String, DataAccessTask> tasks = day.getTasks();
        DataAccessTask deletedTask = tasks.remove(taskTitle);

        super.save();
    }
}
