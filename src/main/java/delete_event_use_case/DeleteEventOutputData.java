package delete_event_use_case;

public class DeleteEventOutputData {
    private String label;
    private int dayIndex;
    private boolean success;
    private String errorMessage = "";

    protected DeleteEventOutputData(int dayIndex, String label) {
        this.dayIndex = dayIndex;
        this.label = label;
    }
}
