package delete_task_use_case;

/**
 * Contains prepareSuccessView and prepareFailView methods,
 * which are implemented in DeleteTaskPresenter.
 *
 * @author Ricky Fung
 */
public interface DeleteTaskOutputBoundary {
    DeleteTaskOutputData prepareSuccessView(DeleteTaskOutputData outputData);

    DeleteTaskOutputData prepareFailView(DeleteTaskOutputData outputData, String error);
}
