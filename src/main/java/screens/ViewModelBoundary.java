package screens;

import java.time.LocalTime;

public interface ViewModelBoundary {
    void newTask(int dayIndex, String title);
    void newEvent(int dayIndex, String title, LocalTime startTime, LocalTime endTime);
    void modifyEvent(int dayIndex, String oldTitle, String newTitle, LocalTime newStartTime, LocalTime newEndTime);
    void modifyTask(int dayIndex, String oldTitle, String newTitle);
    void completeTask(int dayIndex, String title, boolean completed);
    void deleteEvent(int dayIndex, String title);
    void deleteTask(int dayIndex, String title);
    void clearAll();
}
