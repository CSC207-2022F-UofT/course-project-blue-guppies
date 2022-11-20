/**
 * Task Modification Interactor Class.
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 12, 2022
 * Last Modified: Nov 19, 2022
 */
package modify_task_use_case;

public class ModifyTaskInteractor implements ModifyTaskInputBoundary {

    private ModifyTaskOutputBoundary outputBoundary;
    private ModifyTaskDsGateway dsGateway;

    public ModifyTaskInteractor(
            ModifyTaskOutputBoundary outputBoundary,
            ModifyTaskDsGateway dsGateway
    ) {
        this.outputBoundary = outputBoundary;
        this.dsGateway = dsGateway;
    }

    @Override
    public ModifyTaskOutputData modifyTask(ModifyTaskInputData inputData) {
        if (dsGateway.taskExistsByTitle(inputData.getNewTitle(), inputData.getDayID())) {
            return outputBoundary.prepareFailView(
                    "Task with name: " + inputData.getTitle() + " already exists for day " + inputData.getDayID()
            );
        }
        ModifyTaskDsInputData dsInputData = new ModifyTaskDsInputData(
                inputData.getDayID(), inputData.getNewTitle(), inputData.getTitle()
        );
        dsGateway.save(dsInputData);
        ModifyTaskOutputData task = new ModifyTaskOutputData(
                inputData.getNewTitle(), inputData.getDayID()
        );
        return outputBoundary.prepareSuccessView(task);
    }

}
