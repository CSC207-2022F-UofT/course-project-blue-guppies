/**
 * Task Modification Interactor Class.
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 12, 2022
 * Last Modified: Nov 19, 2022
 */
package task_modification_use_case;

public class TaskModificationInteractor implements TaskModificationInputBoundary {

    private TaskModificationOutputBoundary outputBoundary;
    private TaskModificationDsGateway dsGateway;

    public TaskModificationInteractor(
            TaskModificationOutputBoundary outputBoundary,
            TaskModificationDsGateway dsGateway
    ) {
        this.outputBoundary = outputBoundary;
        this.dsGateway = dsGateway;
    }

    @Override
    public TaskModificationOutputData modifyTask(TaskModificationInputData inputData) {
        if (dsGateway.taskExistsByTitle(inputData.getNewTitle(), inputData.getDayID())) {
            return outputBoundary.prepareFailView(
                    "Task with name: " + inputData.getTitle() + " already exists for day " + inputData.getDayID()
            );
        }
        TaskModificationDsInputData dsInputData = new TaskModificationDsInputData(
                inputData.getDayID(), inputData.getNewTitle(), inputData.getTitle()
        );
        dsGateway.save(dsInputData);
        TaskModificationOutputData task = new TaskModificationOutputData(
                inputData.getNewTitle(), inputData.getDayID()
        );
        return outputBoundary.prepareSuccessView(task);
    }

}
