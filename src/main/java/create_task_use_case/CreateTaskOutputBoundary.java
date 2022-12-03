package create_task_use_case;

/**
 * Task Creation Output Boundary Interface. Provides the prepareSuccessView and
 * prepareFailView methods which are implemented by CreateTaskPresenter.
 * @author Fardin Faruk
 */
public interface CreateTaskOutputBoundary {
    CreateTaskOutputData prepareSuccessView(CreateTaskOutputData response);

    CreateTaskOutputData prepareFailView(CreateTaskOutputData response, String error);
}
