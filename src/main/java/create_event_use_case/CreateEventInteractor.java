package create_event_use_case;

import entities.EventFactory;

public class CreateEventInteractor implements CreateEventInputBoundary {

    public CreateEventInteractor(CreateEventDataAccess gateway,
                                 CreateEventOutputBoundary createEventPresenter,
                                 EventFactory eventFactory) {

    }
}
