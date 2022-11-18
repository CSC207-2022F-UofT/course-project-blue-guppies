package task_modification_use_case;

public class TaskModificationInteractor implements TaskModificationInputBoundary {

    private TaskModificationOutputBoundary taskModificationOutputBoundary;
    private TaskModificationDsGateway taskModificationDsGateway;

    public TaskModificationInteractor(
            TaskModificationPresenter taskModificationOutputBoundary,
            TaskModificationDataAccess taskModificationDsGateway
    ) {
        this.taskModificationOutputBoundary = taskModificationOutputBoundary;
        this.taskModificationDsGateway = taskModificationDsGateway;
    }

    @Override
    public TaskModificationResponseModel modifyTask(TaskModificationRequestModel requestModel) {
        if (taskModificationDsGateway.taskExistsByTitle(requestModel.getTitle(), requestModel.getDayID())) {
            return taskModificationOutputBoundary.prepareFailView(
                    "Task with name: " + requestModel.getTitle() + " already exists for day " + requestModel.getDayID()
            );
        }
        TaskModificationDsRequestModel dsRequestModel = new TaskModificationDsRequestModel(
                requestModel.getDayID(), requestModel.getNewTitle(), requestModel.getTitle()
        );
        taskModificationDsGateway.save(dsRequestModel);
        TaskModificationResponseModel task = new TaskModificationResponseModel(
                requestModel.getNewTitle(), requestModel.getDayID()
        );
        return taskModificationOutputBoundary.prepareSuccessView(task);
    }

}
