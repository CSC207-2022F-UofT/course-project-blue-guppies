/**
 * Delete Task Interactor Class.
 * Author: Ricky Fung
 * Modified By: Ricky Fung
 * Created: Nov 19, 2022
 * Last Modified: Nov 19, 2022
 */
package task_deletion_use_case;


public class DeleteTaskInteractor implements DeleteTaskInputBoundary {

    private DeleteTaskOutputBoundary outputBoundary;
    private DeleteTaskDsGateway dsGateway;

    public DeleteTaskInteractor(
            DeleteTaskOutputBoundary outputBoundary, DeleteTaskDsGateway dsGateway) {
        this.outputBoundary = outputBoundary;
        this.dsGateway = dsGateway;
    }

    @Override
    public DeleteTaskOutputData deleteTask(DeleteTaskInputData inputData) {
        DeleteTaskOutputData outputData = new DeleteTaskOutputData(inputData.getDayIndex(), inputData.getTaskTitle());

        if (!dsGateway.taskExists(inputData.getDayIndex(), inputData.getTaskTitle())) {
            outputData.setSuccess(false);
            outputData.setFailure("noTask");
            return outputBoundary.prepareFailView(outputData);
        }
        DeleteTaskDataAccessInput dataAccessInput = new DeleteTaskDataAccessInput(
                inputData.getDayIndex(), inputData.getTaskTitle());
        dsGateway.save(dataAccessInput);

        return outputBoundary.prepareSuccessView(outputData);
    }
}
