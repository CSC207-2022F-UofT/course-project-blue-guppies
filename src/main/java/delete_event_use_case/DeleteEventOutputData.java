package delete_event_use_case;

/**
 * Delete Event OutputData class.
 * @author : Khizer Ahmad
 * @created: November 19th 2022
 * @since : 2022-11-21, Mon.
 **/
public class DeleteEventOutputData {
    private String label;
    private int dayIndex;
    private boolean success = true; //there's no possibility for a "failed" deletion, you either delete or not.

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

    //not sure if the below are needed? no need to toggle failure
//    public void setSuccess(boolean success) {
//        this.success = success;
//    }
//
//    public String getFailure() {
//        return failure;
//    }
//
//    public void setFailure(String failure) {
//        this.failure = failure;
//    }
}
