/**
 * Create Task Presenter Class.
 * Author: Fardin Faruk
 * Modified By: N/A
 * Created: Nov 19, 2022
 * Last Modified: N/A
 */
package create_task_use_case;

public class CreateTaskPresenter implements CreateTaskOutputBoundary {
    @Override
    public CreateTaskOutputData prepareSuccessView(CreateTaskOutputData response) {
        //View Model Update
        response.setCompleted(true);
        return response;
    }

    @Override
    public CreateTaskOutputData prepareFailView(String error) {
        //View Model Update
        //throw new CreateTaskFailed(error);
        return null;
    }
}
