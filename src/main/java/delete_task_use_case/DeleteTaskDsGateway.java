package delete_task_use_case;

/**
 * Contains save and taskExistsInDay methods. Methods are implemented in
 * the DeleteTaskDataAccess class.
 * to be implemented
 * @author Ricky Fung
 */
public interface DeleteTaskDsGateway {
    void save(DeleteTaskDsInputData dataAccessInput);

    boolean taskExistsInDay(int dayIndex, String taskTitle);
}
