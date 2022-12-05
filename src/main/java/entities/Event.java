package entities;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * Event class for use in data access.
 * @author Anna Myllyniemi
 */
public class Event implements Serializable {
    private String title;
    private LocalTime startTime;
    private LocalTime endTime;

    /**
     * @param title the title of this event
     * @param startTime the time that this event starts at
     * @param endTime the time that this event ends at
     */
    public Event(String title, LocalTime startTime, LocalTime endTime) {
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
