package create_event_use_case;

public class CreateEventOutputData {
    private boolean success = false;
    private String errorMessage = "You messed up :(";

    public boolean isSuccess() {
        return success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
