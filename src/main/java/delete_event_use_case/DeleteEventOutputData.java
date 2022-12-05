package delete_event_use_case;

/**
 * Output Data that is sent back to controller.
 * errorMessage and success status indicating the results of deletion.
 * @author Khizer Ahmad
 */
public class DeleteEventOutputData {
    private final String label;
    private final int dayIndex;
    private boolean success;


    private String errorMessage;

    public DeleteEventOutputData(int dayIndex, String label) {
        this.dayIndex = dayIndex;
        this.label = label;
    }

    int getDayIndex() {
        return dayIndex;
    }

    String getLabel() {
        return label;
    }

    public boolean getSuccess() {
        return success;
    }

    public String getErrorMessage() {return errorMessage;}

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setErrorMessage(String message) {
        this.errorMessage = message;
    }
}
