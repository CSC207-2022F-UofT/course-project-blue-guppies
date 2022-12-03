package delete_task_use_case;

/**
 * Contains deleteTask method. Method is invoked
 * in DeleteTaskController, and implemented in DeleteTaskInteractor.
 * @author Ricky Fung
 */
public interface DeleteTaskInputBoundary {
    DeleteTaskOutputData deleteTask(DeleteTaskInputData inputData);
}
