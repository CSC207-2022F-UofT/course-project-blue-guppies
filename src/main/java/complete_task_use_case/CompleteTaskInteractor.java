package complete_task_use_case;

/**
 * Task Completion Interactor Class. Implements the completeTask method provided
 * by the input boundary and orchestrates the application logic for the use case.
 * @author Fardin Faruk
 */
public class CompleteTaskInteractor implements CompleteTaskInputBoundary {

    private final CompleteTaskOutputBoundary outputBoundary;
    private final CompleteTaskDsGateway dsGateway;
    private final String[] DAYS_OF_WEEK = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    public CompleteTaskInteractor(
            CompleteTaskOutputBoundary outputBoundary,
            CompleteTaskDsGateway dsGateway
    ){
        this.outputBoundary = outputBoundary;
        this.dsGateway = dsGateway;
    }

    /**
     * Executes the application logic required to boolean reverse the completion attribute of a Task by
     * calling the appropriate dsGateway and Output Boundary methods.
     *
     * @param inputData A CompleteTaskOutputData instance which contains the dayIndex of the Day object which contains
     * the task and title of the Task.
     * @return A CompleteTaskOutputData instance which contains title, dayIndex, errorMessage
     * and isSuccessfully modified attributes, such that the latter two indicate whether the
     * use case was successful.
     */
    @Override
    public CompleteTaskOutputData completeTask(CompleteTaskInputData inputData) {
        CompleteTaskDsInputData dsInputData = new CompleteTaskDsInputData(
                inputData.getDayIndex(), inputData.getTitle()
        );
        CompleteTaskOutputData task = new CompleteTaskOutputData(
                inputData.getTitle(), inputData.getDayIndex()
        );
        if(!dsGateway.existsByTitle(inputData.getTitle(), inputData.getDayIndex())){
            return outputBoundary.prepareFailView(task,"There does not exist a task with name: " +
                    "'" + inputData.getTitle() +"' on " + DAYS_OF_WEEK[inputData.getDayIndex()]);
        }
        dsGateway.save(dsInputData);
        return outputBoundary.prepareSuccessView(task);
    }
}
