package create_event_use_case;

/**
 * Output Boundary for the Create EVent use case. Methods in this interface are
 * implemented by the Presenter.
 *
 * @author Anna Myllyniemi, Raghav Arora
 */
public interface CreateEventOutputBoundary {
    CreateEventOutputData prepareSuccessView(CreateEventOutputData outputData);

    CreateEventOutputData prepareFailView(CreateEventOutputData outputData, String errorMessage);
}
