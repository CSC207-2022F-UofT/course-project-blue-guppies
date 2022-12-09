package delete_event_use_case;

/**
 * Implements the delete method and calls outputBoundary and dsGateway to delete task.
 *
 * @author Khizer Ahmad
 */
public class DeleteEventInteractor implements DeleteEventInputBoundary {

    private final DeleteEventOutputBoundary outputBoundary;
    private final DeleteEventDsGateway dsGateway;

    public DeleteEventInteractor(
            DeleteEventOutputBoundary outputBoundary, DeleteEventDsGateway dsGateway) {
        this.outputBoundary = outputBoundary;
        this.dsGateway = dsGateway;
    }

    /**
     * Deletes the desired event by making calls to the outputBoundary and dsGateway, if saved properly within DataAccess.
     *
     * @param inputData Contains the dayIndex which contains the event to be removed and title of the event.
     * @return an instance of DeleteEventOutputData, containing the necessary information about the success or failure of
     * the modification.
     */
    @Override
    public DeleteEventOutputData delete(DeleteEventInputData inputData) {
        DeleteEventOutputData outputData = new DeleteEventOutputData(inputData.getDayIndex(), inputData.getEventTitle());

        if (!dsGateway.eventExists(inputData.getDayIndex(), inputData.getEventTitle())) {
            return outputBoundary.prepareFailureView(outputData, "The event does not exist.");
        }
        dsGateway.save(outputData);

        return outputBoundary.prepareSuccessView(outputData);

    }
}