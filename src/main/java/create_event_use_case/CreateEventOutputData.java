package create_event_use_case;

import java.time.LocalTime;

public class CreateEventOutputData {
    private String title;
    private LocalTime startTime;
    private LocalTime endTime;
    private int dayIndex;
    private boolean isSuccessfullyCreated = false;
    private String errorMessage = "";

    public CreateEventOutputData(
            String title, LocalTime startTime, LocalTime endTime, int dayIndex
    ) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dayIndex = dayIndex;
    }

    public CreateEventOutputData() {

    }

    public String getTitle() {
        return title;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public int getDayIndex() {
        return dayIndex;
    }

    public boolean isSuccessfullyCreated() {
        return isSuccessfullyCreated;
    }

    public void setSuccessfullyCreated(boolean successfullyCreated) {
        isSuccessfullyCreated = successfullyCreated;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
