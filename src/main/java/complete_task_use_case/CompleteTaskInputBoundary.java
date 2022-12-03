package complete_task_use_case;
/**
 * Task Completion Input Boundary Interface. Provides the completeTask method, which
 * is invoked in the CompleteTaskController class, and is implemented by CompleteTaskInteractor,
 * @author Fardin Faruk
 */
public interface CompleteTaskInputBoundary {
    CompleteTaskOutputData completeTask(CompleteTaskInputData inputData);
}
