package create_event_use_case;

public class CreateEventPresenter implements CreateEventOutputBoundary {
    @Override
    public CreateEventOutputData prepareSuccessView(CreateEventOutputData outputData) {
        outputData.setSuccessfullyCreated(true);
        return outputData;
    }

    @Override
    public CreateEventOutputData prepareFailView(CreateEventOutputData outputData, String errorMessage) {
        outputData.setErrorMessage(errorMessage);
        return outputData;
    }
}
