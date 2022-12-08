package modify_task_use_case;

/**
 * Task Modification Interactor Class. Implements the modifyTask method provides
 * by the input boundary and orchestrates the application logic for the use case.
 *
 * @author Raghav Arora
 */
public class ModifyTaskInteractor implements ModifyTaskInputBoundary {

    private final ModifyTaskOutputBoundary outputBoundary;
    private final ModifyTaskDsGateway dsGateway;
    private final String[] DAYSOFWEEK = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public ModifyTaskInteractor(
            ModifyTaskOutputBoundary outputBoundary,
            ModifyTaskDsGateway dsGateway
    ) {
        this.outputBoundary = outputBoundary;
        this.dsGateway = dsGateway;
    }

    /**
     * Executes the application logic required to modify a given Task by calling the appropriate
     * dsGateway and Output Boundary methods.
     *
     * @param inputData A ModifyTaskInputData instance which contains the dayIndex of the Day object which
     *                  contains the Task to be modified, the existing title of the Task, and the new title of the task.
     * @return A ModifyTaskOutputData instance which contains title, dayIndex, errorMessage
     * and isSuccessfully modified attributes, such that the latter two indicate whether the
     * use case was successful.
     */
    @Override
    public ModifyTaskOutputData modifyTask(ModifyTaskInputData inputData) {
        ModifyTaskOutputData outputData = new ModifyTaskOutputData(
                inputData.getNewTitle(), inputData.getDayIndex(), inputData.getTitle()
        );
        if (dsGateway.taskExistsByTitle(inputData.getNewTitle(), inputData.getDayIndex())) {
            return outputBoundary.prepareFailView(
                    outputData,
                    "Task with name: '" + inputData.getNewTitle() + "' already exists for " + DAYSOFWEEK[inputData.getDayIndex()]
            );
        }
        ModifyTaskDsInputData dsInputData = new ModifyTaskDsInputData(
                inputData.getDayIndex(), inputData.getNewTitle(), inputData.getTitle()
        );
        dsGateway.save(dsInputData);
        return outputBoundary.prepareSuccessView(outputData);
    }

}
