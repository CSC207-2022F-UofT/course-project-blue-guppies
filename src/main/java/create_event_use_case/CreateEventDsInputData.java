package create_event_use_case;

import java.time.LocalTime;

class CreateEventDsInputData {
    private String title;
    private LocalTime startTime;
    private LocalTime endTime;
    private int dayIndex;

    CreateEventDsInputData(String title, LocalTime startTime, LocalTime endTime, int dayIndex) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dayIndex = dayIndex;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public int getDayIndex() {
        return dayIndex;
    }

    public void setDayIndex(int dayIndex) {
        this.dayIndex = dayIndex;
    }
}
