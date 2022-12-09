package complete_task_use_case;

/**
 * Task Completion DsGateway Interface. Provides methods which are implemented
 * by CompleteTaskDataAccess to perform the application logic for this use case.
 *
 * @author Fardin Faruk
 */
public interface CompleteTaskDsGateway {
    void save(CompleteTaskDsInputData dsInputData);

    boolean existsByTitle(String title, int dayIndex);
}
