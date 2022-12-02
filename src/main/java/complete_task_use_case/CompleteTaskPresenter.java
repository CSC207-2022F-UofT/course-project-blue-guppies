/**
 * Complete Task Presenter Class.
 * Author: Fardin Faruk
 * Modified By: N/A
 * Created: Nov 26, 2022
 * Last Modified: N/A
 */
package complete_task_use_case;

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
