package create_event_use_case;

/**
 * Input Boundary for the Create Event use case. Methods in this interface are
 * implemented by the use case Interactor.
 *
 * @author Anna Myllyniemi
 */
public interface CreateEventInputBoundary {
    CreateEventOutputData createEvent(CreateEventInputData inputData);
}
