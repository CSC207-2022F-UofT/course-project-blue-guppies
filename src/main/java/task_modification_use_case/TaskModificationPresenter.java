package task_modification_use_case;

public class TaskModificationPresenter implements TaskModificationOutputBoundary {
    @Override
    public TaskModificationResponseModel prepareSuccessView(TaskModificationResponseModel task) {
        TaskModificationResponseModel responseModel = new TaskModificationResponseModel(
                task.getTitle(), task.getDayId()
        );
        return responseModel;
    }

    @Override
    public TaskModificationResponseModel prepareFailView(String error) {
        TaskModificationResponseModel responseModel = new TaskModificationResponseModel(
                "", -1
        );
        return responseModel;
    }
}
