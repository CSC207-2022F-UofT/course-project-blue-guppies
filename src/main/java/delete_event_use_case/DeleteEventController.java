package delete_event_use_case;

public class DeleteEventController {
    public DeleteEventOutputData delete(String eventTitle, int dayIndex) {
        return new DeleteEventOutputData(0, "blue");
    }
}
