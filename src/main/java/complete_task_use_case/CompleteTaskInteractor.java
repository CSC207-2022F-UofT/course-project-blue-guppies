/**
 * Complete Task Interactor Class.
 * Author: Fardin Faruk
 * Modified By: N/A
 * Created: Nov 26, 2022
 * Last Modified: N/A
 */
package complete_task_use_case;

public class CompleteTaskInteractor implements CompleteTaskInputBoundary {

    private CompleteTaskOutputBoundary outputBoundary;
    private CompleteTaskDsGateway dsGateway;

    public CompleteTaskInteractor(
            CompleteTaskOutputBoundary outputBoundary,
            CompleteTaskDsGateway dsGateway
    ){
        this.outputBoundary = outputBoundary;
        this.dsGateway = dsGateway;
    }


    @Override
    public CompleteTaskOutputData completeTask(CompleteTaskInputData inputData) {
        CompleteTaskDsInputData dsInputData = new CompleteTaskDsInputData(
                inputData.getDayID(), inputData.getTitle()
        );
        dsGateway.save(dsInputData);
        CompleteTaskOutputData task = new CompleteTaskOutputData(
                inputData.getTitle(), inputData.getDayID()
        );
        return outputBoundary.prepareSuccessView(task);
    }
}
