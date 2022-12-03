package complete_task_use_case;

/**
 * Task Complete Output Boundary Interface. Provides the prepareSuccessView and
 * prepareFailView methods which are implemented by CompleteTaskPresenter.
 * @author Fardin Faruk
 */
public interface CompleteTaskOutputBoundary {
    CompleteTaskOutputData prepareSuccessView(CompleteTaskOutputData task);
    CompleteTaskOutputData prepareFailView(CompleteTaskOutputData task, String error);
}
