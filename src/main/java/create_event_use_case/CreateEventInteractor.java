package create_event_use_case;

import entities.Event;
import entities.EventFactory;

import java.time.LocalTime;

/**
 * Interactor for the Create Event use case. Calls the dsGateway and Output Boundary to appropriately execute
 * application logic.
 *
 * @author Anna Myllyniemi
 */
public class CreateEventInteractor implements CreateEventInputBoundary {
    private final CreateEventDsGateway dsGateway;
    private final CreateEventOutputBoundary outputBoundary;
    private final EventFactory factory;

    private final static String[] DAYS_OF_WEEK = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
            "Saturday"};

    public CreateEventInteractor(CreateEventDsGateway dsGateway,
                                 CreateEventOutputBoundary outputBoundary,
                                 EventFactory factory) {
        this.dsGateway = dsGateway;
        this.outputBoundary = outputBoundary;
        this.factory = factory;
    }

    /**
     * Performs the core application logic for the Create Event use case: check whether there already exists
     * an event with the title given, check for time conflicts (if any), and proceed with creation of an event, if
     * appropriate.
     *
     * @param inputData The Input Data instance which contains the title of the Event the user
     *                  wants to create, its start and end times, and the index of the Day object the Event will
     *                  be created for, if at all.
     * @return An instance of CreateEventOutputData whose instance attributes indicate
     * whether the event was successfully created.
     */
    @Override
    public CreateEventOutputData createEvent(CreateEventInputData inputData) {
        CreateEventOutputData outputData = new CreateEventOutputData();
        if (!(inputData.getStartTime().matches("[01][0-9]:[0-5][0-9]|2[0-3]:[0-5][0-9]"))) {
            return outputBoundary.prepareFailView(outputData, "Start time is not a valid time. \nEx: 21:39");
        } else if (!(inputData.getEndTime().matches("[01][0-9]:[0-5][0-9]|2[0-3]:[0-5][0-9]"))) {
            return outputBoundary.prepareFailView(outputData, "End time is not a valid time. \nEx: 21:39");
        } else if (dsGateway.eventExistsByTitle(inputData.getTitle(), inputData.getDayIndex())) {
            return outputBoundary.prepareFailView(outputData,
                    "Event with name '" + inputData.getTitle() + "' already exists on " +
                            DAYS_OF_WEEK[inputData.getDayIndex()]
            );
        }
        LocalTime startTime = LocalTime.parse(inputData.getStartTime());
        LocalTime endTime = LocalTime.parse(inputData.getEndTime());

        if (!startTime.isBefore(endTime)) {
            return outputBoundary.prepareFailView(outputData, "Start time is not before end time.");
        } else if (dsGateway.isTimeConflict(inputData.getDayIndex(), startTime, endTime)) {
            return outputBoundary.prepareFailView(outputData,
                    "This event conflicts with an existing event.");
        }

        Event event = factory.createEvent(inputData.getTitle(), startTime, endTime);

        outputData = new CreateEventOutputData(
                inputData.getTitle(), startTime,
                endTime, inputData.getDayIndex()
        );

        CreateEventDsInputData dsInputData = new CreateEventDsInputData(inputData.getDayIndex(), event);
        dsGateway.save(dsInputData);
        return outputBoundary.prepareSuccessView(outputData);
    }
}