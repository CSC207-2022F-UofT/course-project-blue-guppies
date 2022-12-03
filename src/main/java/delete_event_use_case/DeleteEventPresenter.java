package delete_event_use_case;

/**
 * Implements the prepareSuccessView and prepareFailView methods in DeleteTaskOutputBoundary.
 * @author Khizer Ahmad
 */
public class DeleteEventPresenter implements DeleteEventOutputBoundary {
    /**
     * Sets success of the DeleteEventOutputData instance to true, errorMessage left unmodified.
     * @param eventOutputData An instance of DeleteEventOutputData which contains the
     * eventTitle of the event for deletion as well as the corresponding dayIndex.
     * @return The DeleteTaskOutputData object with the success attribute set to true.
     */
    @Override
    public DeleteEventOutputData prepareSuccessView(DeleteEventOutputData eventOutputData) {
        eventOutputData.setSuccess(true);
        return eventOutputData;
    }

    /**
     * Sets success of the DeleteEventOutputData instance to false, errorMessage modified to represent failure
     * @param eventOutputData the instance of OutputData for a failing modification.
     * @return outputData with successState changed to false
     */
    public DeleteEventOutputData prepareFailureView(DeleteEventOutputData eventOutputData, String errorMessage) {
        eventOutputData.setErrorMessage(errorMessage);
        eventOutputData.setSuccess(false);
        return eventOutputData;
    }

}
