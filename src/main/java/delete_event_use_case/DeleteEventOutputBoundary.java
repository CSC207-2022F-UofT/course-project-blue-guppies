package delete_event_use_case;

/**
 * Output Boundary interface for deleting events.
 * Contains methods for preparing success and failure views, implemented in DeleteEventPresenter.
 *
 * @author Khizer Ahmad
 */
public interface DeleteEventOutputBoundary {
    DeleteEventOutputData prepareSuccessView(DeleteEventOutputData eventOutputData);

    DeleteEventOutputData prepareFailureView(DeleteEventOutputData eventOutputData, String errorMessage);
}
