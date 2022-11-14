package create_task_use_case;

public class CreateTaskPresenter implements CreateTaskOutputBoundary {
    @Override
    public CreateTaskResponseModel prepareSuccessView(CreateTaskResponseModel response) {
        // TODO: Edit response???
        return response;
    }

    @Override
    public CreateTaskResponseModel prepareFailView(String error) {
        //throw new CreateTaskFailed(error);
        return null;
    }
}
