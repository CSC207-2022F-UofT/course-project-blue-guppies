package delete_task_use_case;

/**
 * Invokes the implementations of deleteTask given by DeleteTaskInteractor to execute application logic
 * @author Ricky Fung
 */
public class DeleteTaskController {
    private final DeleteTaskInputBoundary inputBoundary;

    public DeleteTaskController(DeleteTaskInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * @param dayIndex The index of the day the task is associated with.
     * @param taskTitle The title for the task that is to be removed.
     * @return An instance of DeleteTaskOutputData which shows if the task
     * for deletion was successful.
     */
    public DeleteTaskOutputData deleteTask(int dayIndex, String taskTitle) {
        DeleteTaskInputData inputData = new DeleteTaskInputData(dayIndex, taskTitle);
        return inputBoundary.deleteTask(inputData);
    }
}
