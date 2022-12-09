package create_event_use_case;

import strategies.DayToIndexConverter;

/**
 * Controller class for the Create Event use case. Invokes the application logic
 * given by the input boundary.
 *
 * @author Anna Myllyniemi, Fardin Faruk
 */
public class CreateEventController {
    private final CreateEventInputBoundary inputBoundary;
    private final DayToIndexConverter converter;

    public CreateEventController(CreateEventInputBoundary inputBoundary, DayToIndexConverter converter) {
        this.inputBoundary = inputBoundary;
        this.converter = converter;
    }

    /**
     * Invokes the implementation of create() given by the input boundary, which contains
     * the application logic.
     *
     * @return An instance of CreateEventOutputData whose instance attributes indicate
     * whether the event was successfully created.
     */
    public CreateEventOutputData create(String day, String title, String startTime, String endTime) {
        int dayIndex = this.converter.convertDayNameToIndex(day);
        CreateEventInputData inputData = new CreateEventInputData(
                title, startTime, endTime, dayIndex
        );
        return inputBoundary.createEvent(inputData);
    }
}
