package screens;

import java.util.ArrayList;

public interface ViewModelObserver {
    void updateEventSectionOnDay(int dayIndex, ArrayList<String> eventTitles, ArrayList<String> startTimes,
                                        ArrayList<String> endTimes);
    void updateTaskSectionOnDay(int dayIndex, ArrayList<String> taskTitles,
                                       ArrayList<Boolean> taskCompletionStatuses);
}
