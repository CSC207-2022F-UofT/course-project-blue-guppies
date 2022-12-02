/**
 * Complete Task Interactor Class.
 * Author: Fardin Faruk
 * Modified By: N/A
 * Created: Nov 26, 2022
 * Last Modified: N/A
 */
package complete_task_use_case;

public class CompleteTaskInteractor implements CompleteTaskInputBoundary {

    private final CompleteTaskOutputBoundary outputBoundary;
    private final CompleteTaskDsGateway dsGateway;

    final private String[] DAYSOFWEEK = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
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
                inputData.getDayIndex(), inputData.getTitle()
        );
        dsGateway.save(dsInputData);
        CompleteTaskOutputData task = new CompleteTaskOutputData(
                inputData.getTitle(), inputData.getDayIndex(), ""
        );
        if(!dsGateway.existsByTitle(inputData.getTitle(), inputData.getDayIndex())){
            return outputBoundary.prepareFailView(task,"There does not exist a task with name: " +
                    "'" + inputData.getTitle() +"' on " + DAYSOFWEEK[inputData.getDayIndex()]);
        }
        return outputBoundary.prepareSuccessView(task);
    }
}
