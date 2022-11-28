package create_event_use_case;

public class CreateEventController {
    private final CreateEventInputBoundary createEventInteractor;

    public CreateEventController(CreateEventInputBoundary createEventInteractor) {
        this.createEventInteractor = createEventInteractor;
    }

    public void create(String day, String text, String text1, String text2) {

    }
}
