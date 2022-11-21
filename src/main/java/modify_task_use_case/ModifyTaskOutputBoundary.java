/**
 * Task Modification Output Boundary Interface.
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 12, 2022
 * Last Modified: Nov 19, 2022
 */
package modify_task_use_case;

public interface ModifyTaskOutputBoundary {
    ModifyTaskOutputData prepareSuccessView(ModifyTaskOutputData task);
    ModifyTaskOutputData prepareFailView(String error);
}
