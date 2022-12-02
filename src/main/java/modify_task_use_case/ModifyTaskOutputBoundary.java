/**
 * Task Modification Output Boundary Interface.
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 12, 2022
 * Last Modified: Dec 1, 2022
 */
package modify_task_use_case;

public interface ModifyTaskOutputBoundary {
    ModifyTaskOutputData prepareSuccessView(ModifyTaskOutputData outputData);
    ModifyTaskOutputData prepareFailView(ModifyTaskOutputData outputData, String error);
}
