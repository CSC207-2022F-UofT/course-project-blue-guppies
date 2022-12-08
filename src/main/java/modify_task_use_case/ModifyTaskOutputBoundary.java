package modify_task_use_case;

/**
 * Task Modification Output Boundary Interface. Provides the prepareSuccessView and
 * prepareFailView methods which are implemented by ModifyTaskPresenter.
 *
 * @author Raghav Arora
 */
public interface ModifyTaskOutputBoundary {
    ModifyTaskOutputData prepareSuccessView(ModifyTaskOutputData outputData);

    ModifyTaskOutputData prepareFailView(ModifyTaskOutputData outputData, String error);
}
