/**
 * Complete Task Output Boundary Interface.
 * Author: Fardin Faruk
 * Modified By: N/A
 * Created: Nov 26, 2022
 * Last Modified: N/A
 */
package complete_task_use_case;

public interface CompleteTaskOutputBoundary {
    CompleteTaskOutputData prepareSuccessView(CompleteTaskOutputData task);
    CompleteTaskOutputData prepareFailView(CompleteTaskOutputData task, String error);
}