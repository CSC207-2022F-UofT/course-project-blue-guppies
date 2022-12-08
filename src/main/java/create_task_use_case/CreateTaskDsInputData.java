package create_task_use_case;

import entities.Task;

/**
 * Task Creation DsInputData Class. Instances of type CreateTaskDsInputData are
 * passed on to the gateway to execute the use case's application logic.
 * @author Fardin Faruk
 */
public class CreateTaskDsInputData {
    private final Task task;
    private final int dayIndex;

    public CreateTaskDsInputData(Task task, int dayIndex){
        this.task = task;
        this.dayIndex = dayIndex;
    }

    public Task getTask() {
        return task;
    }

    public int getDayIndex(){
        return dayIndex;
    }

}
