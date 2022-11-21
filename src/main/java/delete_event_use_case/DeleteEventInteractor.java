package delete_event_use_case;

/**
 * Delete Event Interactor class.
 * @author : Khizer Ahmad
 * @created: November 19th 2022
 * @since : 2022-11-21, Mon.
 **/
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

//        if (!dsGateway.taskExists(inputData.getDayIndex(), inputData.getTaskTitle())) {
//            outputData.setSuccess(false);
//            outputData.setFailure("noTask");
//            return outputBoundary.prepareFailView(outputData);
//        }
//        DeleteEveDataAccessInput dataAccessInput = new DeleteTaskDataAccessInput(
//                inputData.getDayIndex(), inputData.getTaskTitle());
        dsGateway.save(outputData);

        return outputBoundary.prepareSuccessView(outputData);
    }
}