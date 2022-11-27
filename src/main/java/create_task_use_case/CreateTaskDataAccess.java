/**
 * Create Task Data Access Class.
 * Author: Fardin Faruk
 * Modified By: Fardin Faruk
 * Created: Nov 19, 2022
 * Last Modified: Nov 27, 2022
 */
package create_task_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessTask;
import data_access.WeekDataAccess;

import java.util.ArrayList;
import java.util.HashMap;

public class CreateTaskDataAccess extends WeekDataAccess implements CreateTaskDsGateway {

    @Override
    public boolean existsByTitle(String title, int dayIndex) {
        DataAccessDay referenceDay = days.get(dayIndex);
        HashMap<String, DataAccessTask> tasks = referenceDay.getTasks();
        return tasks.containsKey(title);
    }


    @Override
    public void save(CreateTaskDsInputData taskData) {
        DataAccessDay referenceDay = days.get(taskData.getDayIndex());
        HashMap<String, DataAccessTask> tasks = referenceDay.getTasks();
        DataAccessTask newTask = new DataAccessTask(taskData.getTitle());
        tasks.put(taskData.getTitle(), newTask);
        super.save();
    }
}
