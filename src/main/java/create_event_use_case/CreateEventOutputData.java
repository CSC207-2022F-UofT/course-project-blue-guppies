package create_event_use_case;

public class CreateEventOutputData {
    private boolean success = false;
    private String errorMessage = "You messed up :(";

    public CreateEventOutputData() {
    }

    public boolean isSuccess() {
        return success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
