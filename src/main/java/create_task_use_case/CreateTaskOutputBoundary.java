/**
 * Create Task Output Boundary Interface.
 * Author: Fardin Faruk
 * Modified By: N/A
 * Created: Nov 19, 2022
 * Last Modified: N/A
 */
package create_task_use_case;

public interface CreateTaskOutputBoundary {
    CreateTaskOutputData prepareSuccessView(CreateTaskOutputData response);

    CreateTaskOutputData prepareFailView(String error);
}
