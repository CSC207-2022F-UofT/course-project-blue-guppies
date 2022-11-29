package delete_event_use_case;

public class DeleteEventOutputData {
    private String label;
    private int dayIndex;
    private boolean success = true;
    private String errorMessage = "";

    protected DeleteEventOutputData(int dayIndex, String label) {
        this.dayIndex = dayIndex;
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public int getDayIndex() {
        return dayIndex;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
