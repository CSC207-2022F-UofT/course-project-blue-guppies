package entities;

import java.util.HashMap;

public class DayFactory {
    public Day createDay(){return new Day();}
    public Day createDay(HashMap<String, Task> tasks, HashMap<String, Event> events){
        return new Day(tasks, events);
    }
}
