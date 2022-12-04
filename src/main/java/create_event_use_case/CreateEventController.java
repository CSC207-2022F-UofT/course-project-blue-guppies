package create_event_use_case;

/**
 *
 * @author Anna Myllyniemi, Raghav Arora
 */
public class CreateEventController {
    private final CreateEventInputBoundary inputBoundary;

    public CreateEventController(CreateEventInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public CreateEventOutputData createEvent(String title, String startTime, String endTime, String day) {
        CreateEventInputData inputData = new CreateEventInputData(
                title, startTime, endTime, day
        );
        return inputBoundary.createEvent(inputData);
    }
}
