package task_modification_use_case;
import entities.TaskFactory;

public class TaskModificationInteractor implements TaskModificationInputBoundary {

    private TaskModificationOutputBoundary taskModificationOutputBoundary;
    private TaskModificationDsGateway taskModificationDsGateway;

    public TaskModificationInteractor(
            TaskModificationPresenter taskModificationOutputBoundary,
            TaskModificationDataAccess taskModificationDsGateway,
    ) {
        this.taskModificationOutputBoundary = taskModificationOutputBoundary;
        this.taskModificationDsGateway = taskModificationDsGateway;
    }

    @Override
    TaskModificationResponseModel modifyTask(TaskModificationRequestModel requestModel) {
        if (taskModificationDsGateway.taskExistsByTitle(requestModel.getTitle(), requestModel.getDayID())) {
            return taskModificationOutputBoundary.prepareFailView(
                    "Task with name: " + requestModel.getTitle() + " already exists for day " + requestModel.getDayID();
            );
        } else {

        }
    }

}
