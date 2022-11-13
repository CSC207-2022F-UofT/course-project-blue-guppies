package task_modification_use_case;

public interface TaskModificationOutputBoundary {
    TaskModificationResponseModel prepareSuccessView(TaskModificationResponseModel task);
    TaskModificationResponseModel prepareFailView(String error);
}
