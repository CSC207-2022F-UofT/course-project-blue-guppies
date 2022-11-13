package task_modification_use_case;

public interface TaskModificationInputBoundary {
    TaskModificationResponseModel modifyTask(TaskModificationRequestModel requestModel);
}
