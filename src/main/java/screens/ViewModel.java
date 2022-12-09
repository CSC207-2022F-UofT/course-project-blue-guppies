package screens;


import entities.Day;
import entities.Event;
import entities.Task;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * View Model class. Contains all the data used by the WeekViewScreen, and tells WeekViewScreen to update whenever a
 * use case changes the state of the program. Similar to an Observer pattern and MVVM pattern.
 *
 * @author Anna Myllyniemi
 */
public class ViewModel implements ViewModelBoundary {
    private final ArrayList<ViewModelObserver> observers = new ArrayList<>();

    private final List<List<ViewModelEvent>> events = new ArrayList<>(7);

    private final List<List<ViewModelTask>> tasks = new ArrayList<>(7);

    /**
     * On startup, the ViewModel is initialized with all existing data and tells the WeekViewScreen to update to reflect
     * the state of the program.
     *
     * @param days The Array of Day entities which contain all the tasks and events for the week.
     */
    public ViewModel(ArrayList<Day> days) {
        for (int i = 0; i < 7; i++) {
            HashMap<String, Event> loadedEvents = days.get(i).getEvents();
            events.add(i, new ArrayList<>());
            for (String title : loadedEvents.keySet()) {
                this.events.get(i).add(new ViewModelEvent(title, loadedEvents.get(title).getStartTime(),
                        loadedEvents.get(title).getEndTime()));
            }
            HashMap<String, Task> loadedTasks = days.get(i).getTasks();
            tasks.add(i, new ArrayList<>());
            for (String title : loadedTasks.keySet()) {
                this.tasks.get(i).add(new ViewModelTask(title, loadedTasks.get(title).getCompleted()));
            }
            Collections.sort(events.get(i));
            Collections.sort(tasks.get(i));
        }
    }

    public void initializeWeekViewScreen() {
        for (int i = 0; i < 7; i++) {
            updateInfoForAllEventsOnDay(i);
            updateInfoForAllTasksOnDay(i);
        }
    }

    /**
     * An entity similar to Event for use in the ViewModel
     */
    private static class ViewModelEvent implements Comparable<ViewModelEvent> {
        private String title;
        private String startTime;
        private String endTime;

        private ViewModelEvent(String title, LocalTime startTime, LocalTime endTime) {
            this.title = title;
            this.startTime = startTime.toString();
            this.endTime = endTime.toString();
        }

        private ViewModelEvent() {

        }

        @Override
        public int compareTo(ViewModelEvent o) {
            return LocalTime.parse(this.startTime).compareTo(LocalTime.parse(o.startTime));
        }
    }

    /**
     * An entity similar to Task for use within the ViewModel
     */
    private static class ViewModelTask implements Comparable<ViewModelTask> {
        private String title;
        private boolean completed;

        private ViewModelTask(String title, boolean completed) {
            this.title = title;
            this.completed = completed;
        }

        private ViewModelTask() {

        }

        @Override
        public int compareTo(ViewModelTask o) {
            return title.compareTo(o.title);
        }
    }

    public void addObserver(ViewModelObserver o) {
        observers.add(o);
    }

    public void newEvent(int dayIndex, String title, LocalTime startTime, LocalTime endTime) {
        events.get(dayIndex).add(new ViewModelEvent(title, startTime, endTime));
        Collections.sort(events.get(dayIndex));
        updateInfoForAllEventsOnDay(dayIndex);
    }

    public void newTask(int dayIndex, String title) {
        tasks.get(dayIndex).add(new ViewModelTask(title, false));
        Collections.sort(tasks.get(dayIndex));
        updateInfoForAllTasksOnDay(dayIndex);
    }

    @Override
    public void modifyEvent(int dayIndex, String oldTitle, String newTitle, LocalTime newStartTime, LocalTime newEndTime) {
        ViewModelEvent existingEvent = getEventByDayAndTitle(dayIndex, oldTitle);
        existingEvent.title = newTitle;
        existingEvent.startTime = newStartTime.toString();
        existingEvent.endTime = newEndTime.toString();
        Collections.sort(events.get(dayIndex));
        updateInfoForAllEventsOnDay(dayIndex);
    }

    @Override
    public void modifyTask(int dayIndex, String oldTitle, String newTitle) {
        ViewModelTask existingTask = getTaskByDayAndTitle(dayIndex, oldTitle);
        existingTask.title = newTitle;
        Collections.sort(tasks.get(dayIndex));
        updateInfoForAllTasksOnDay(dayIndex);
    }

    @Override
    public void completeTask(int dayIndex, String title, boolean completed) {
        ViewModelTask existingTask = getTaskByDayAndTitle(dayIndex, title);
        existingTask.completed = completed;
        Collections.sort(tasks.get(dayIndex));
        updateInfoForAllTasksOnDay(dayIndex);
    }

    @Override
    public void deleteEvent(int dayIndex, String title) {
        ViewModelEvent existingEvent = getEventByDayAndTitle(dayIndex, title);
        events.get(dayIndex).remove(existingEvent);
        updateInfoForAllEventsOnDay(dayIndex);
    }

    @Override
    public void deleteTask(int dayIndex, String title) {
        ViewModelTask existingTask = getTaskByDayAndTitle(dayIndex, title);
        tasks.get(dayIndex).remove(existingTask);
        updateInfoForAllTasksOnDay(dayIndex);
    }

    @Override
    public void clearAll() {
        for (int i = 0; i < 7; i++) {
            tasks.get(i).clear();
            events.get(i).clear();
            updateInfoForAllTasksOnDay(i);
            updateInfoForAllEventsOnDay(i);
        }

    }

    private void updateInfoForAllEventsOnDay(int dayIndex) {
        ArrayList<String> titles = new ArrayList<>();
        ArrayList<String> startTimes = new ArrayList<>();
        ArrayList<String> endTimes = new ArrayList<>();
        for (ViewModelEvent event : events.get(dayIndex)) {
            titles.add(event.title);
            startTimes.add(event.startTime);
            endTimes.add(event.endTime);
        }
        for (ViewModelObserver observer : observers) {
            observer.updateEventSectionOnDay(dayIndex, titles, startTimes, endTimes);
        }
    }

    private void updateInfoForAllTasksOnDay(int dayIndex) {
        ArrayList<String> titles = new ArrayList<>();
        ArrayList<Boolean> completionStatuses = new ArrayList<>();
        for (ViewModelTask task : tasks.get(dayIndex)) {
            titles.add(task.title);
            completionStatuses.add(task.completed);
        }
        for (ViewModelObserver observer : observers) {
            observer.updateTaskSectionOnDay(dayIndex, titles, completionStatuses);
        }
    }

    private ViewModelEvent getEventByDayAndTitle(int dayIndex, String title) {
        for (ViewModelEvent event : events.get(dayIndex)) {
            if (event.title.equals(title)) {
                return event;
            }
        }
        return new ViewModelEvent();
    }

    protected String getEventStartTime(int dayIndex, String title) {
        return getEventByDayAndTitle(dayIndex, title).startTime;
    }

    protected String getEventEndTime(int dayIndex, String title) {
        return getEventByDayAndTitle(dayIndex, title).endTime;
    }

    protected boolean getTaskCompletion(int dayIndex, String title) {
        return getTaskByDayAndTitle(dayIndex, title).completed;
    }

    private ViewModelTask getTaskByDayAndTitle(int dayIndex, String title) {
        for (ViewModelTask task : tasks.get(dayIndex)) {
            if (task.title.equals(title)) {
                return task;
            }
        }
        return new ViewModelTask();
    }
}
