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
        super.Save();
    }
}
