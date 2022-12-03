package create_task_use_case;

/**
 * Task Creation DsGateway Interface. Provides methods which are implemented
 * by CreateTaskDataAccess to perform the application logic for this use case.
 * @author Fardin Faruk
 */
public interface CreateTaskDsGateway {
    boolean existsByTitle(String title, int dayIndex);

    void save(CreateTaskDsInputData taskData);
}
