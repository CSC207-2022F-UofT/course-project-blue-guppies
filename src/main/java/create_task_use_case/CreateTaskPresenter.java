package create_task_use_case;

public class CreateTaskPresenter implements CreateTaskOutputBoundary {
    @Override
    public CreateTaskOutputData prepareSuccessView(CreateTaskOutputData response) {
        // TODO: create a screen to return
        return response;
    }

    @Override
    public CreateTaskOutputData prepareFailView(String error) {
        //throw new CreateTaskFailed(error);
        return null;
    }
}
