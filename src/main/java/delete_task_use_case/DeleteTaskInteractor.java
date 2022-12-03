package delete_task_use_case;

/**
 * Implements the deleteTask method and calls
 * outputBoundary and dsGateway to delete task.
 * @author Ricky Fung
 */
public class DeleteTaskInteractor implements DeleteTaskInputBoundary {

    private final DeleteTaskOutputBoundary outputBoundary;
    private final DeleteTaskDsGateway dsGateway;
    private final String[] DAYSOFWEEK = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public DeleteTaskInteractor(
            DeleteTaskOutputBoundary outputBoundary, DeleteTaskDsGateway dsGateway) {
        this.outputBoundary = outputBoundary;
        this.dsGateway = dsGateway;
    }


    /**
     * Checks the required needs to delete a given Task in a given dayIndex by calling
     * OutputBoundary and dsGateway methods.
     * Modifies a given Task by making calls to the OutputBoundary and dsGateway methods.
     * @param inputData Contains the dayIndex which contains the Task to be removed,
     *                  and title of the Task.
     * @return DeleteTaskOutputData instance attributes which contains the information
     * of the success or failure of the Task that is to be deleted.
     */
    @Override
    public DeleteTaskOutputData deleteTask(DeleteTaskInputData inputData) {
        DeleteTaskOutputData outputData = new DeleteTaskOutputData(inputData.getDayIndex(), inputData.getTaskTitle());
        if (!dsGateway.taskExistsInDay(inputData.getDayIndex(),inputData.getTaskTitle())){
            return outputBoundary.prepareFailView(outputData,
                    "Task Title: " + "\"" + inputData.getTaskTitle() + "\"" + " does not exist for day " +
                            DAYSOFWEEK[inputData.getDayIndex()]);

        }

        DeleteTaskDsInputData dsInputData = new DeleteTaskDsInputData(
                inputData.getDayIndex(), inputData.getTaskTitle());
        dsGateway.save(dsInputData);
        return outputBoundary.prepareSuccessView(outputData);
    }
}
