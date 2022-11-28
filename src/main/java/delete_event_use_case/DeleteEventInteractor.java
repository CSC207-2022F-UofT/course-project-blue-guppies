/**
 * Delete Event Interactor class.
 * @author : Khizer Ahmad
 * @created: November 19th 2022
 * @since : 2022-11-28, Mon.
 **/

package delete_event_use_case;
public class DeleteEventInteractor implements DeleteEventInputBoundary {

    private DeleteEventOutputBoundary outputBoundary;
    private DeleteEventDsGateway dsGateway;

    public DeleteEventInteractor(
            DeleteEventOutputBoundary outputBoundary, DeleteEventDsGateway dsGateway) {
        this.outputBoundary = outputBoundary;
        this.dsGateway = dsGateway;
    }

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