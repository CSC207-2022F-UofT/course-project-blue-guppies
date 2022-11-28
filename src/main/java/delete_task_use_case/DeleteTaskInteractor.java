/**
 * Delete Task Interactor Class.
 * Author: Ricky Fung
 * Modified By: Ricky Fung
 * Created: Nov 19, 2022
 * Last Modified: Nov 28, 2022
 */
package delete_task_use_case;

public class DeleteTaskInteractor implements DeleteTaskInputBoundary {

    private final DeleteTaskOutputBoundary outputBoundary;
    private final DeleteTaskDsGateway dsGateway;

    public DeleteTaskInteractor(
            DeleteTaskOutputBoundary outputBoundary, DeleteTaskDsGateway dsGateway) {
        this.outputBoundary = outputBoundary;
        this.dsGateway = dsGateway;
    }

    @Override
    public DeleteTaskOutputData deleteTask(DeleteTaskInputData inputData) {
        DeleteTaskOutputData outputData = new DeleteTaskOutputData(inputData.getDayIndex(), inputData.getTaskTitle());
        DeleteTaskDsInputData dataAccessInput = new DeleteTaskDsInputData(
                inputData.getDayIndex(), inputData.getTaskTitle());
        dsGateway.save(dataAccessInput);

        return outputBoundary.prepareSuccessView(outputData);
    }
}
