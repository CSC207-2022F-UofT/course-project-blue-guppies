package entities;

import java.util.ArrayList;

public class Week{
    private final ArrayList<Day> days;

    public Week(){
        this.days = new ArrayList<>();
    }

    public ArrayList<Day> getDays(){
        return days;
    }
}
