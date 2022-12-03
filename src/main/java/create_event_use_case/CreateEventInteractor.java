package create_event_use_case;

import entities.EventFactory;
import entities.Event;

public class CreateEventInteractor implements CreateEventInputBoundary {
    private final CreateEventDsGateway dsGateway;
    private final CreateEventOutputBoundary outputBoundary;
    private final EventFactory factory;

    final private String[] DAYSOFWEEK = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public CreateEventInteractor(CreateEventDsGateway dsGateway,
                                 CreateEventOutputBoundary outputBoundary,
                                 EventFactory factory) {
        this.dsGateway = dsGateway;
        this.outputBoundary = outputBoundary;
        this.factory = factory;
    }

    @Override
    public CreateEventOutputData create(CreateEventInputData inputData) {
        CreateEventOutputData outputData;
        if (!inputData.getStartTime().matches("[01][0-9][:][0-5][0-9]") &&
                !inputData.getStartTime().matches("[2][0-3][:][0-5][0-9]")) {
            outputData

        }

        if (dsGateway.eventExistsByTitle(inputData.getTitle(), inputData.getDayIndex())) {
            return outputBoundary.prepareFailView(outputData,
                    "Event with name '" + inputData.getTitle() + "' already exists on " +
                            DAYSOFWEEK[inputData.getDayIndex()]
                    );
        }
        Event event = factory.createEvent(
                inputData.getTitle(), inputData.getStartTime(), inputData.getEndTime()
        );

        outputData = new CreateEventOutputData(
                inputData.getTitle(), inputData.getStartTime(),
                inputData.getEndTime(), inputData.getDayIndex()
        );

        CreateEventDsInputData dsInputData = new CreateEventDsInputData(
                event.getTitle(), event.getStartTime(),
                event.getEndTime(), inputData.getDayIndex()
        );
        dsGateway.save(dsInputData);
        return outputBoundary.prepareSuccessView(outputData);
    }
}
