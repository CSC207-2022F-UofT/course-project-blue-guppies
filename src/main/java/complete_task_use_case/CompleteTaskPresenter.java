package complete_task_use_case;
/**
 * Task Completion Presenter Class. Implements the prepareSuccessView and prepareFailView
 * methods in the output boundary, by mutating the CompleteTaskOutputData object that is
 * passed on as a parameter, appropriately.
 * @author Fardin Faruk
 */
public class CompleteTaskPresenter implements CompleteTaskOutputBoundary {
    @Override
    public CompleteTaskOutputData prepareSuccessView(CompleteTaskOutputData task) {
        // View Model Update
        task.setSuccessfullyCreated(true);
        return task;
    }

    @Override
    public CompleteTaskOutputData prepareFailView(CompleteTaskOutputData task, String error) {
        // View Model Update
        task.setSuccessfullyCreated(false);
        task.setErrorMessage(error);
        return task;
    }
}
