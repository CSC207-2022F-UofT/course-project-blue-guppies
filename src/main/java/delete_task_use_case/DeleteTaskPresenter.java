package delete_task_use_case;

import screens.ViewModelBoundary;

/**
 * Implements the prepareSuccessView and prepareFailView methods in DeleteTaskOutputBoundary.
 *
 * @author Ricky Fung
 */
public class DeleteTaskPresenter implements DeleteTaskOutputBoundary {

    private final ViewModelBoundary viewModelBoundary;

    public DeleteTaskPresenter(ViewModelBoundary viewModelBoundary) {
        this.viewModelBoundary = viewModelBoundary;
    }

    /**
     * Sets success of the DeleteTaskOutputData instance to true,
     * with no ErrorMessage.
     *
     * @param outputData An instance of DeleteTaskOutputData which contains the
     *                   taskTitle of the task for deletion as well as the corresponding
     *                   dayIndex.
     * @return The DeleteTaskOutputData object with the success attribute set to true.
     */
    @Override
    public DeleteTaskOutputData prepareSuccessView(DeleteTaskOutputData outputData) {
        viewModelBoundary.deleteTask(outputData.getDayIndex(), outputData.getTaskTitle());
        outputData.setSuccess(true);
        return outputData;
    }

    /**
     * Sets success of the DeleteTaskOutputData instance to false,
     * and sets ErrorMessage to a non-empty/non-null string.
     *
     * @param outputData An instance of DeleteTaskOutputData which contains the
     *                   taskTitle of the task for deletion as well as the corresponding
     *                   dayIndex.
     * @return The DeleteTaskOutputData object with the success attribute set to false
     * and ErrorMessage a non-empty string/non-null.
     */
    @Override
    public DeleteTaskOutputData prepareFailView(DeleteTaskOutputData outputData, String error) {
        outputData.setSuccess(false);
        outputData.setErrorMessage(error);
        return outputData;
    }
}
