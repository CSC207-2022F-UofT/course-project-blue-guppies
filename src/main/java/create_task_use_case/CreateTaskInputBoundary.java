package create_task_use_case;
/**
 * Task Creation Input Boundary Interface. Provides the createTask method, which
 * is invoked in the CreateTaskController class, and is implemented by CreateTaskInteractor,
 * @author Fardin Faruk
 */
public interface CreateTaskInputBoundary {
    CreateTaskOutputData create(CreateTaskInputData taskData);
}
