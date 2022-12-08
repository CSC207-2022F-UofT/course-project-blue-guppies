package create_event_use_case;

import create_task_use_case.CreateTaskController;

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
        int dayIndex;
        switch (day) {
            case "Sunday":
                dayIndex = 0;
                break;
            case "Monday":
                dayIndex = 1;
                break;
            case "Tuesday":
                dayIndex = 2;
                break;
            case "Wednesday":
                dayIndex = 3;
                break;
            case "Thursday":
                dayIndex = 4;
                break;
            case "Friday":
                dayIndex = 5;
                break;
            default:
                dayIndex = 6;
                break;
            // if no match assume Saturday
        }
        CreateEventInputData inputData = new CreateEventInputData(
                title, startTime, endTime, dayIndex
        );
        return inputBoundary.createEvent(inputData);
    }
}
