package screens;


import data_access.DataAccessDay;
import data_access.DataAccessEvent;
import data_access.DataAccessTask;

import java.time.LocalTime;
import java.util.*;

/**
 * View Model class using observer pattern for updating WeekViewScreen. Mimics structure of deprecated Observable class.
 * @author Anna Myllyniemi
 */
public class ViewModel implements ViewModelObserver{
    private final ArrayList<ViewModelObserver> observers = new ArrayList<>();

    private final List<List<ViewModelEvent>> events = new ArrayList<>(7);

    private final List<List<ViewModelTask>> tasks = new ArrayList<>(7);

    public ViewModel(ArrayList<DataAccessDay> days) {
        for (int i = 0; i < 7; i++) {
            HashMap<String, DataAccessEvent> loadedEvents = days.get(i).getEvents();
            for (String title: loadedEvents.keySet()) {
                this.events.get(i).add(new ViewModelEvent(title, loadedEvents.get(title).getStartTime(),
                        loadedEvents.get(title).getEndTime()));
            }
            HashMap<String, DataAccessTask> loadedTasks = days.get(i).getTasks();
            for (String title: loadedTasks.keySet()) {
                this.tasks.get(i).add(new ViewModelTask(title, loadedTasks.get(title).getCompleted()));
            }
            Collections.sort(events.get(i));
            Collections.sort(tasks.get(i));
        }
    }

    @Override
    public void update(Object arg) {

    }

    private static class ViewModelEvent implements Comparable<ViewModelEvent> {
        String title;
        String startTime;
        String endTime;

        public ViewModelEvent(String title, LocalTime startTime, LocalTime endTime) {
            this.title = title;
            this.startTime = startTime.toString();
            this.endTime = endTime.toString();
        }

        @Override
        public int compareTo(ViewModelEvent o) {
            return LocalTime.parse(this.startTime).compareTo(LocalTime.parse(o.startTime));
        }
    }

    private static class ViewModelTask implements Comparable<ViewModelTask> {
        String title;
        boolean completed;

        public ViewModelTask(String title, boolean completed) {
            this.title = title;
            this.completed = completed;
        }

        @Override
        public int compareTo(ViewModelTask o) {
            return title.compareTo(o.title);
        }
    }


    public void addObserver(ViewModelObserver o) {
        observers.add(o);
    }

    public void deleteObserver(ViewModelObserver o) {
        observers.remove(o);
    }

    public void newEvent(int dayIndex, String title, LocalTime startTime, LocalTime endTime) {


    }

    public String getEventStartTime(int dayIndex, String title) {
        for (ViewModelEvent event: events.get(dayIndex)) {
            if (event.title.equals(title)) {
                return event.startTime;
            }
        }
        return "00:00";
    }

    public String getEventEndTime(int dayIndex, String title) {
        for (ViewModelEvent event: events.get(dayIndex)) {
            if (event.title.equals(title)) {
                return event.endTime;
            }
        }
        return "23:59";
    }

    public boolean getTaskCompletion(int dayIndex, String title) {
        for (ViewModelTask task: tasks.get(dayIndex)) {
            if (task.title.equals(title)) {
                return task.completed;
            }
        }
        return false;
    }
}
