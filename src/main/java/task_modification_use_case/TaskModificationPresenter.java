/**
 * Task Modification Presenter Class.
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 12, 2022
 * Last Modified: Nov 19, 2022
 */
package task_modification_use_case;

public class TaskModificationPresenter implements TaskModificationOutputBoundary {
    @Override
    public TaskModificationOutputData prepareSuccessView(TaskModificationOutputData task) {
        TaskModificationOutputData outputData = new TaskModificationOutputData(
                task.getTitle(), task.getDayId()
        );
        return outputData;
    }

    @Override
    public TaskModificationOutputData prepareFailView(String error) {
        throw new TaskModificationFailed(error);
    }
}
