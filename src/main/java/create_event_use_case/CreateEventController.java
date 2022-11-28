package create_event_use_case;

import java.time.LocalTime;

public class CreateEventController {
    private final CreateEventInputBoundary inputBoundary;

    public CreateEventController(CreateEventInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public void create(String title, LocalTime startTime, LocalTime endTime, int dayIndex) {
        CreateEventInputData inputData = new CreateEventInputData(
                title, startTime, endTime, dayIndex
        );
        return inputBoundary.create(inputData);
    }
}
