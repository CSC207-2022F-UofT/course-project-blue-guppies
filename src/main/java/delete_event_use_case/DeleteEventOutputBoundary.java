package delete_event_use_case;

/**
 * Delete Event Output Boundary interface.
 * @author : Khizer Ahmad
 * @created: November 19th 2022
 * @since : 2022-11-21, Mon.
 **/
public interface DeleteEventOutputBoundary {
    DeleteEventOutputData prepareSuccessView(DeleteEventOutputData eventOutputData);
}
