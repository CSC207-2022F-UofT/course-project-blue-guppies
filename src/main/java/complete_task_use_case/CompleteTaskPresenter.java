package complete_task_use_case;
/**
 * Task Completion Presenter Class. Implements the prepareSuccessView and prepareFailView
 * methods in the output boundary, by mutating the CompleteTaskOutputData object that is
 * passed on as a parameter, appropriately.
 * @author Fardin Faruk
 */
public class CompleteTaskPresenter implements CompleteTaskOutputBoundary {
    /**
     * Mutate the CompleteTaskOutputData instance provided by setting its
     * isSuccessfullyModified attribute to true, and errorMessage to the empty string.
     *
     * @param task A CompleteTaskOutputData instance which contains the title of the new task
     * as well as the corresponding dayIndex.
     * @return The same CompleteTaskOutputData object with its isSuccessfullyModified attribute
     * set to True, and errorMessage set to an empty string.
     */
    @Override
    public CompleteTaskOutputData prepareSuccessView(CompleteTaskOutputData task) {
        // View Model Update
        task.setSuccessfullyCreated(true);
        task.setTaskCompleted(!task.isTaskCompleted());
        return task;
    }

    /**
     * Mutate the CompleteTaskOutputData instance provided by setting its
     * isSuccessfullyModified attribute to false, and errorMessage to a non-empty string.
     *
     * @param task A CompleteTaskOutputData instance which contains the title of the task modified
     * as well as the corresponding dayIndex.
     * @return The same CompleteTaskOutputData object with its isSuccessfullyModified attribute
     * set to True, and errorMessage set to an empty string.
     */
    @Override
    public CompleteTaskOutputData prepareFailView(CompleteTaskOutputData task, String error) {
        // View Model Update
        task.setSuccessfullyCreated(false);
        task.setErrorMessage(error);
        return task;
    }
}
