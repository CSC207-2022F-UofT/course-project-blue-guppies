package create_task_use_case;

public interface CreateTaskDsGateway {
    boolean existsByTitle(String title);

    void save(CreateTaskDsOutputData taskData);
}
