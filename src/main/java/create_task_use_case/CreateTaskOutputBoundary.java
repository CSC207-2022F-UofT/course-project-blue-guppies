package create_task_use_case;

public interface CreateTaskOutputBoundary {
    CreateTaskResponseModel prepareSuccessView(CreateTaskResponseModel response);

    CreateTaskResponseModel prepareFailView(String error);
}
