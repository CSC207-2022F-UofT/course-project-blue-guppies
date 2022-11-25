package complete_task_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessTask;
import data_access.WeekDataAccess;

import java.util.HashMap;

public class CompleteTaskDataAccess extends WeekDataAccess implements CompleteTaskDsGateway {

    @Override
    public void save(CompleteTaskDsInputData dsInputData) {
        int DayID = dsInputData.getDayID();
        DataAccessDay day = this.getDays().get(DayID);
        HashMap<String, DataAccessTask> tasksList = day.getTasks();
        DataAccessTask task = tasksList.get(dsInputData.getTitle());
        task.setCompleted(!task.getCompleted());
        super.save();
    }
}
