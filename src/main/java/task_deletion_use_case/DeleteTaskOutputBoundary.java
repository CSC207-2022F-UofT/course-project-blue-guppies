/**
 * Delete Task OutputBoundary Interface.
 * Author: Ricky Fung
 * Modified By: Ricky Fung
 * Created: Nov 19, 2022
 * Last Modified: Nov 19, 2022
 */
package task_deletion_use_case;

public interface DeleteTaskOutputBoundary {
    DeleteTaskOutputData prepareSuccessView(DeleteTaskOutputData taskOutputData);

    DeleteTaskOutputData prepareFailView(DeleteTaskOutputData taskOutputData);
}
