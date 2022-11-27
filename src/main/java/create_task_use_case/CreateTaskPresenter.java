/**
 * Create Task Presenter Class.
 * Author: Fardin Faruk
 * Modified By: Fardin Faruk
 * Created: Nov 19, 2022
 * Last Modified: Nov 27, 2022
 */
package create_task_use_case;

public class CreateTaskPresenter implements CreateTaskOutputBoundary {
    @Override
    public CreateTaskOutputData prepareSuccessView(CreateTaskOutputData response) {
        //View Model Update
        response.setSuccessfullyCreated(true);
        return response;
    }

    @Override
    public CreateTaskOutputData prepareFailView(CreateTaskOutputData response, String error) {
        //View Model Update
        response.setSuccessfullyCreated(false);
        response.setErrorMessage(error);
        return response;
    }
}
