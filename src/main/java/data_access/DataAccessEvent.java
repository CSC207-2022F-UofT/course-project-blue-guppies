package data_access;

import java.time.LocalTime;

public class DataAccessEvent {
    private String title;
    private LocalTime startTime;
    private LocalTime endTime;

    protected DataAccessEvent(String title, LocalTime startTime, LocalTime endTime) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getTitle() {
        return title;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
