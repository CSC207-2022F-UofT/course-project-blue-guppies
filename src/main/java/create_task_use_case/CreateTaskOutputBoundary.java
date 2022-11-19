package create_task_use_case;

public interface CreateTaskOutputBoundary {
    CreateTaskOutputData prepareSuccessView(CreateTaskOutputData response);

    CreateTaskOutputData prepareFailView(String error);
}
