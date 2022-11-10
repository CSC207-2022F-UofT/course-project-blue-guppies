package entities;

import java.util.ArrayList;
import java.util.HashMap;

public class Week{
    private final ArrayList<Day> days;

    public Week(){
        Day d = new Day(new HashMap<>(), new HashMap<>());
        days = new ArrayList<>();
        for(int i = 0; i < 7; i++){days.add(d);}
    }

    public Week(ArrayList<Day> days){
        this.days = days;
    }

    public ArrayList<Day> getDays(){
        return days;
    }
}
