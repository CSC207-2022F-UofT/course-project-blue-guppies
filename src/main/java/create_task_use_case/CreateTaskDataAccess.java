/**
 * Create Task Data Access Class.
 * Author: Fardin Faruk
 * Modified By: N/A
 * Created: Nov 19, 2022
 * Last Modified: N/A
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
        ArrayList<DataAccessDay> days = super.getDays();
        DataAccessDay referenceDay = days.get(dayIndex);
        HashMap<String, DataAccessTask> tasks = referenceDay.getTasks();
        if(tasks.containsKey(title)){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void save(CreateTaskDsOutputData taskData) {
        ArrayList<DataAccessDay> days = super.getDays();
        DataAccessDay referenceDay = days.get(taskData.getDay());
        HashMap<String, DataAccessTask> tasks = referenceDay.getTasks();
        DataAccessTask newTask = new DataAccessTask(taskData.getTitle());
        tasks.put(newTask.getTitle(), newTask);
        super.save();
    }
}
