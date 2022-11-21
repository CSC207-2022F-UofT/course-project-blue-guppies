/**
 * Delete Task DataAccess Class.
 * Author: Ricky Fung
 * Modified By: Ricky Fung
 * Created: Nov 19, 2022
 * Last Modified: Nov 21, 2022
 */
package delete_task_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessTask;
import data_access.WeekDataAccess;
import java.util.HashMap;

public class DeleteTaskDataAccess extends WeekDataAccess implements DeleteTaskDsGateway {
    @Override
    public void save(DeleteTaskDataAccessInput dataAccessInput) {
        DataAccessDay day = super.getDays().get(dataAccessInput.getDayIndex());
        HashMap<String, DataAccessTask> tasks = day.getTasks();
        tasks.remove(dataAccessInput.getTaskTitle());

        super.save();
    }
}