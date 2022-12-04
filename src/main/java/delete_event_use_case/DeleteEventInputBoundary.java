package delete_event_use_case;

/**
 *
 *  Input boundary interface. Contains a delete method that returns output data.
 *  Method is called by DeleteEventController and implemented in DeleteEventInteractor
 *  @author Khizer Ahmad
 */
public interface DeleteEventInputBoundary {
    DeleteEventOutputData delete(DeleteEventInputData eventData);
}