package create_event_use_case;

public interface CreateEventOutputBoundary {
    CreateEventOutputData prepareSuccessView(CreateEventOutputData outputData);

    CreateEventOutputData prepareFailView(CreateEventOutputData outputData, String errorMessage);
}
