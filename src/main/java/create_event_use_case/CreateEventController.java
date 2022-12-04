package create_event_use_case;

public class CreateEventController {
    private final CreateEventInputBoundary createEventInteractor;

    public CreateEventController(CreateEventInputBoundary createEventInteractor) {
        this.createEventInteractor = createEventInteractor;
    }

    public CreateEventOutputData create(String day, String title, String startTime, String endTime) {

        return new CreateEventOutputData();
    }
}
