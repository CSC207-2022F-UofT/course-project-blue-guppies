package data_access;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class WeekDataAccess implements Serializable {
    private static ArrayList<DataAccessDay> days = new ArrayList<DataAccessDay>();

    public WeekDataAccess() {
        if(days.isEmpty()){
            DataAccessDay emptyDay = new DataAccessDay(new HashMap<>(), new HashMap<>());
            for(int i = 0; i < 7; i++){
                days.add(emptyDay);
            }
        }
    }

    public WeekDataAccess(ArrayList<DataAccessDay> dataDays){
        days = dataDays;
    }

    public ArrayList<DataAccessDay> getDays() {
        return days;
    }

    private void Save(){
        // To be implemented later when we figure out Serializable
    }
}
