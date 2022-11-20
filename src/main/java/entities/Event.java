/**
 * Event class.
 * Author: Anna Myllyniemi
 * Modified by: Daniel Livshits
 * Date created: Nov 9 2022
 * Last modified: Nov 9 2022
 */
package entities;

import java.io.Serializable;
import java.time.LocalTime;

public class Event implements Serializable {
    private String title;
    private LocalTime startTime;
    private LocalTime endTime;

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
