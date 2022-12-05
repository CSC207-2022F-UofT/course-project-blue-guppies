package screens;


import data_access.DataAccessDay;
import data_access.DataAccessEvent;
import data_access.DataAccessTask;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * View Model class using observer pattern for updating WeekViewScreen. Mimics structure of deprecated Observable class.
 * @author Anna Myllyniemi
 */
public class ViewModel{
    private final ArrayList<ViewModelObserver> observers = new ArrayList<>();

    private final List<List<Object[]>> events = new ArrayList<>(7);

    private final List<List<Object[]>> tasks = new ArrayList<>(7);

    public ViewModel(ArrayList<DataAccessDay> days) {
        for (int i = 0; i < 7; i++) {
            HashMap<String, DataAccessEvent> loadedEvents = days.get(i).getEvents();
            for (String title: loadedEvents.keySet()) {
                this.events.get(i).add(new Object[]{title, loadedEvents.get(title).getStartTime(),
                        loadedEvents.get(title).getEndTime()});
            }
            HashMap<String, DataAccessTask> loadedTasks = days.get(i).getTasks();
            for (String title: loadedTasks.keySet()) {
                this.tasks.get(i).add(new Object[]{title, loadedTasks.get(title).getCompleted()});
            }
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

    public Object[] getEventInformation(int dayIndex, String title) {
        for (Object[] event: events.get(dayIndex)) {
            if (event[0].equals(title)) {
                return event;
            }
        }
        return new Object[]{};
    }
}
