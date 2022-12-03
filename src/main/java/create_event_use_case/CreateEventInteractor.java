package create_event_use_case;

import entities.EventFactory;
import entities.Event;

public class CreateEventInteractor implements CreateEventInputBoundary {
    private final CreateEventDsGateway dsGateway;
    private final CreateEventOutputBoundary outputBoundary;
    private final EventFactory factory;
    public CreateEventInteractor(CreateEventDsGateway dsGateway,
                                 CreateEventOutputBoundary outputBoundary,
                                 EventFactory factory) {
        this.dsGateway = dsGateway;
        this.outputBoundary = outputBoundary;
        this.factory = factory;
    }

    @Override
    public CreateEventOutputData create(CreateEventInputData inputData) {
        Event event = factory.createEvent(
                inputData.getTitle(), inputData.getStartTime(), inputData.getEndTime()
        );
        CreateEventOutputData outputData = new CreateEventOutputData(
                inputData.getTitle(), inputData.getStartTime(),
                inputData.getEndTime(), inputData.getDayIndex()
        );
        if (dsGateway.eventExistsByTitle(inputData.getTitle(), inputData.getDayIndex())) {
            return outputBoundary.prepareFailView(
                    outputData,
                    "Event with name " + inputData.getTitle() + " already exists for day " + inputData.getDayIndex()
                    );
        }
        CreateEventDsInputData dsInputData = new CreateEventDsInputData(
                event.getTitle(), event.getStartTime(),
                event.getEndTime(), inputData.getDayIndex()
        );
        dsGateway.save(dsInputData);
        return outputBoundary.prepareSuccessView(outputData);
    }
}
