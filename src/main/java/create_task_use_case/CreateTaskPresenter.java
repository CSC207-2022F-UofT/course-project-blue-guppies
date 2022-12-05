package create_task_use_case;

import screens.ViewModelBoundary;

/**
 * Task Creation Presenter Class. Implements the prepareSuccessView and prepareFailView
 * methods in the output boundary, by mutating the CreateTaskOutputData object that is
 * passed on as a parameter, appropriately.
 * @author Fardin Faruk
 */
public class CreateTaskPresenter implements CreateTaskOutputBoundary {
    private final ViewModelBoundary viewModelBoundary;

    public CreateTaskPresenter() {
        viewModelBoundary = null;
    }

    public CreateTaskPresenter(ViewModelBoundary viewModelBoundary) {
        this.viewModelBoundary = viewModelBoundary;
    }

    /**
     * Mutate the CreateTaskOutputData instance provided by setting its
     * isSuccessfullyModified attribute to true, and errorMessage to the empty string.
     *
     * @param response A CreateTaskOutputData instance which contains the title of the new task
     * as well as the corresponding dayIndex.
     * @return The same CreateTaskOutputData object with its isSuccessfullyModified attribute
     * set to True, and errorMessage set to an empty string.
     */
    @Override
    public CreateTaskOutputData prepareSuccessView(CreateTaskOutputData response) {
        if (viewModelBoundary != null) {
            viewModelBoundary.newTask(response.getDayIndex(), response.getTitle());
        }
        response.setSuccessfullyCreated(true);
        return response;
    }

    /**
     * Mutate the CreateTaskOutputData instance provided by setting its
     * isSuccessfullyModified attribute to false, and errorMessage to a non-empty string.
     *
     * @param response A CreateTaskOutputData instance which contains the title of the task modified
     * as well as the corresponding dayIndex.
     * @return The same CreateTaskOutputData object with its isSuccessfullyModified attribute
     * set to True, and errorMessage set to an empty string.
     */
    @Override
    public CreateTaskOutputData prepareFailView(CreateTaskOutputData response, String error) {
        //View Model Update
        response.setSuccessfullyCreated(false);
        response.setErrorMessage(error);
        return response;
    }
}
