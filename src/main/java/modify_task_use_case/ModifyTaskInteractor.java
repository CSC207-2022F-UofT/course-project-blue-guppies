/**
 * Task Modification Interactor Class.
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 12, 2022
 * Last Modified: Dec 1, 2022
 */
package modify_task_use_case;

public class ModifyTaskInteractor implements ModifyTaskInputBoundary {

    private final ModifyTaskOutputBoundary outputBoundary;
    private final ModifyTaskDsGateway dsGateway;

    public ModifyTaskInteractor(
            ModifyTaskOutputBoundary outputBoundary,
            ModifyTaskDsGateway dsGateway
    ) {
        this.outputBoundary = outputBoundary;
        this.dsGateway = dsGateway;
    }

    /**
     * @param inputData contains the dayIndex which contains the Task to be modified,
     * the existing title of the Task, and the new title of the task.
     *
     * @return A ModifyTaskOutputData instance which contains title, dayIndex, errorMessage
     * and isSuccessfully modified attributes, such that the latter two indicate whether the
     * use case was successful.
     */
    @Override
    public ModifyTaskOutputData modifyTask(ModifyTaskInputData inputData) {
        ModifyTaskOutputData outputData = new ModifyTaskOutputData(
                inputData.getNewTitle(), inputData.getDayIndex()
        );
        if (dsGateway.taskExistsByTitle(inputData.getNewTitle(), inputData.getDayIndex())) {
            return outputBoundary.prepareFailView(
                    outputData,
                    "Task with name: " + inputData.getNewTitle() + " already exists for day " + inputData.getDayIndex()
            );
        }
        ModifyTaskDsInputData dsInputData = new ModifyTaskDsInputData(
                inputData.getDayIndex(), inputData.getNewTitle(), inputData.getTitle()
        );
        dsGateway.save(dsInputData);
        return outputBoundary.prepareSuccessView(outputData);
    }

}
