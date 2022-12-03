package delete_task_use_case;

public class DeleteTaskOutputData {
    private boolean success = true;
    private String errorMessage;

    public boolean isSuccess() {
        return success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
