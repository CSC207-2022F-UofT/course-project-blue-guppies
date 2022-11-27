/**
 * Create Task Output Boundary Interface.
 * Author: Fardin Faruk
 * Modified By: Fardin Faruk
 * Created: Nov 19, 2022
 * Last Modified: Nov 27, 2022
 */
package create_task_use_case;

public interface CreateTaskOutputBoundary {
    CreateTaskOutputData prepareSuccessView(CreateTaskOutputData response);

    CreateTaskOutputData prepareFailView(CreateTaskOutputData response, String error);
}
