/**
 * Delete Event OutputData class.
 * @author : Khizer Ahmad
 * @created: November 19th 2022
 * @since : 2022-11-28, Mon.
 **/

package delete_event_use_case;

public class DeleteEventOutputData {
    private String label;
    private int dayIndex;
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
