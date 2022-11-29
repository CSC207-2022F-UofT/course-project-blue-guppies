package create_task_use_case;

public class CreateTaskOutputData {
    private boolean successfullyCreated = true;
    private String errorMessage = "You messed up :(";

    public boolean isSuccessfullyCreated() {
        return successfullyCreated;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
