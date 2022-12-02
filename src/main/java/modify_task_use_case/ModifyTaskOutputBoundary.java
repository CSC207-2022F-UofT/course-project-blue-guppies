package modify_task_use_case;

/** Task Modification Output Boundary Interface. Provides the prepareSuccessView and
 * prepareFailView methods which are implemented by ModifyTaskPresenter.
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 12, 2022
 * Last Modified: Dec 2, 2022
 */
public interface ModifyTaskOutputBoundary {
    ModifyTaskOutputData prepareSuccessView(ModifyTaskOutputData outputData);
    ModifyTaskOutputData prepareFailView(ModifyTaskOutputData outputData, String error);
}
