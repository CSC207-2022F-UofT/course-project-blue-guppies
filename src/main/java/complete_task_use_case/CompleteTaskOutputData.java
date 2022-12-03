package complete_task_use_case;

public class CompleteTaskOutputData {
    private boolean success = true;
    private String errorMessage = "";

    public CompleteTaskOutputData() {

    }


    public boolean isSuccess() {
        return success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
