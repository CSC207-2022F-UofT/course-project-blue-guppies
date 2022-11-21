/**
 * Delete Task Presenter Class.
 * Author: Ricky Fung
 * Modified By: Ricky Fung
 * Created: Nov 19, 2022
 * Last Modified: Nov 19, 2022
 */
package delete_task_use_case;

public class DeleteTaskPresenter implements DeleteTaskOutputBoundary {
    @Override
    public DeleteTaskOutputData prepareSuccessView(DeleteTaskOutputData taskOutputData) {
        return taskOutputData;
    }
}
