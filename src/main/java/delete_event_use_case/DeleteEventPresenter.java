/**
 * Delete Event Presenter class.
 * @author : Khizer Ahmad
 * @created: November 19th 2022
 * @since : 2022-11-21, Mon.
 **/

package delete_event_use_case;
public class DeleteEventPresenter implements DeleteEventOutputBoundary {
    @Override
    public DeleteEventOutputData prepareSuccessView(DeleteEventOutputData eventOutputData) {
        eventOutputData.setSuccess(true);
        return eventOutputData;
    }

    public DeleteEventOutputData prepareFailureView(DeleteEventOutputData eventOutputData, String errorMessage) {
        eventOutputData.setErrorMessage(errorMessage);
        eventOutputData.setSuccess(false);
        return eventOutputData;
    }

}
