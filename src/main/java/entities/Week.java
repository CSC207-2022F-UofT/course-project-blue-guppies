package entities;

import java.util.ArrayList;
import java.util.HashMap;

public class Week{
    private final ArrayList<Day> days;

    public Week(ArrayList<Day> days){
        this.days = days;
    }

    public ArrayList<Day> getDays(){
        return days;
    }
}
