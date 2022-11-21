/**
 * Task Modification Presenter Class.
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 12, 2022
 * Last Modified: Nov 19, 2022
 */
package modify_task_use_case;

public class ModifyTaskPresenter implements ModifyTaskOutputBoundary {
    @Override
    public ModifyTaskOutputData prepareSuccessView(ModifyTaskOutputData task) { return task; }

    @Override
    public ModifyTaskOutputData prepareFailView(String error) {
        throw new ModifyTaskFailed(error);
    }
}
