package create_event_use_case;

import entities.EventFactory;

public class CreateEventInteractor implements CreateEventInputBoundary {

    public CreateEventInteractor(CreateEventDsGateway gateway,
                                 CreateEventOutputBoundary createEventPresenter,
                                 EventFactory eventFactory) {

    }
}
