package delete_task_use_case;

/**
 * Implements the prepareSuccessView and prepareFailView methods in DeleteTaskOutputBoundary.
 * @author Ricky Fung
 */
public class DeleteTaskPresenter implements DeleteTaskOutputBoundary {

    /**
     * @param outputData An instance of DeleteTaskOutputData which contains the
     *                   taskTitle of the task for deletion as well as the corresponding
     *                   dayIndex.
     * @return The DeleteTaskOutputData object with the success attribute set to true.
     */
    @Override
    public DeleteTaskOutputData prepareSuccessView(DeleteTaskOutputData outputData) {
        outputData.setSuccess(true);
        return outputData;
    }

    /**
     * @param outputData An instance of DeleteTaskOutputData which contains the
     *                   taskTitle of the task for deletion as well as the corresponding
     *                   dayIndex.
     * @return The DeleteTaskOutputData object with the success attribute set to false.
     */
    @Override
    public DeleteTaskOutputData prepareFailView(DeleteTaskOutputData outputData, String error) {
        outputData.setSuccess(false);
        outputData.setErrorMessage(error);
        return outputData;
    }
}
