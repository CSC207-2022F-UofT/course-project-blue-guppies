package create_event_use_case;

/**
 * Controller class for the Create Event use case. Invokes the application logic
 * given by the input boundary.
 *
 * @author Anna Myllyniemi
 */
public class CreateEventController {
    private final CreateEventInputBoundary inputBoundary;

    public CreateEventController(CreateEventInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Invokes the implementation of create() given by the input boundary, which contains
     * the application logic.
     *
     * @return An instance of CreateEventOutputData whose instance attributes indicate
     * whether the event was successfully created.
     */
    public CreateEventOutputData create(String day, String title, String startTime, String endTime) {
        CreateEventInputData inputData = new CreateEventInputData(
                title, startTime, endTime, day
        );
        return inputBoundary.createEvent(inputData);
    }
}
