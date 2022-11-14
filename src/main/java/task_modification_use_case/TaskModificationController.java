package task_modification_use_case;

public class TaskModificationController {
    private TaskModificationInputBoundary taskModificationInputBoundary;

    public TaskModificationController(TaskModificationInteractor taskModificationInputBoundary) {
        this.taskModificationInputBoundary = taskModificationInputBoundary;
    }

    TaskModificationResponseModel modifyTask(int dayId, String newTitle, String title) {
        TaskModificationRequestModel requestModel = new TaskModificationRequestModel(
                dayId, newTitle, title
        );
        return taskModificationInputBoundary.modifyTask(requestModel);
    }
}
