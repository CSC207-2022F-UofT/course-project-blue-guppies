/**
 * Event class.
 *
 * Author: Anna Myllyniemi
 * Date created: Nov 9 2022
 *
 */
package entities;

import java.sql.Time;

public class Event{
    private String title;
    private Time startTime;
    private Time endTime;

    protected Event(String title, Time startTime, Time endTime) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getTitle() {
        return title;
    }

    public Time getEndTime() {
        return endTime;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
