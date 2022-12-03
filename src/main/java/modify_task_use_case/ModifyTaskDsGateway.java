package modify_task_use_case;

/**
 * Task Modification DsGateway Interface. Provides methods which are implemented
 * by ModifyTaskDataAccess to perform the application logic for this use case.
 * @author Raghav Arora
 */
public interface ModifyTaskDsGateway {
    boolean taskExistsByTitle(String title, int dayIndex);
    void save(ModifyTaskDsInputData dsInputData);
}
