/**
 * Event class for use in data access.
 * Author: Daniel Livshits
 * Modified by: Daniel Livshits
 * Date created: Nov 14, 2022
 * Last modified: Nov 19, 2022
 */
package data_access;

import java.io.Serializable;
import java.time.LocalTime;

public class DataAccessEvent implements Serializable {
    private String title;
    private LocalTime startTime;
    private LocalTime endTime;

    public DataAccessEvent(String title, LocalTime startTime, LocalTime endTime) {
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
