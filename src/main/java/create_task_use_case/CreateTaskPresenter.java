package create_task_use_case;

public class CreateTaskPresenter implements CreateTaskOutputBoundary {
    @Override
    public CreateTaskOutputData prepareSuccessView(CreateTaskOutputData response) {
        //TODO: View Model Update?
        return response;
    }

    @Override
    public CreateTaskOutputData prepareFailView(String error) {
        //TODO: View Model Update?
        //throw new CreateTaskFailed(error);
        return null;
    }
}
