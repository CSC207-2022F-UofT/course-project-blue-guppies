package data_access;

import entities.Day;

import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * The superclass for data access, with a static attribute and private method to be shared across all create_event_use_case.CreateEventPresenter.data_access.DataAccess
 * classes.
 * @author Daniel Livshits, Khizer Ahmad
 */
public class WeekDataAccess implements Serializable {

    /**
     * The ArrayList of days to be used for data persistence. The state of this data structure is saved
     * to a .ser file.
     */
    protected static ArrayList<Day> days = new ArrayList<Day>();
    private static final long serialVersionUID = 1L;


    /**
     * Initializes days to a week with 7 empty days if it hasn't already been initialized.
     */
    public WeekDataAccess() {
        if(days.isEmpty()){
            for(int i = 0; i < 7; i++){
                Day emptyDay = new Day(new HashMap<>(), new HashMap<>());
                days.add(emptyDay);
            }
        }
    }

    /**
     * Sets days to the week specified by dataDays
     * Precondition: dataDays is an ArrayList containing 7 dataDay instances
     * @param dataDays - a representation of a week.
     */
    public WeekDataAccess(ArrayList<Day> dataDays){
        days = dataDays;
    }

    public ArrayList<Day> getDays() {
        return days;
    }

    public static void setDays(ArrayList<Day> days) {
        WeekDataAccess.days = days;
    }

    /**
     * Writes the contents of the days class variable onto a .ser file, persisting data
     * @param days an ArrayList whose indices contain two hashmaps that contain events and tasks separately, representing the
     *             week schedule
     * @throws IOException
     */
    public static void writeObject(ArrayList<Day> days) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("storage.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(new ArrayList<Day>(days));
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    /**
     * Reads the object from the .ser file and reinitialized day
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public static void readObject() throws ClassNotFoundException, IOException {
        File file = new File("storage.txt");
        if (file.length() != 0) {//program has been initialized, assuming some content has been added
            FileInputStream fileInputStream = new FileInputStream("storage.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            WeekDataAccess.days = (ArrayList<Day>) objectInputStream.readObject();
            objectInputStream.close();
        }
        else { //initializing program for the very first time, so file days with empty days
            for(int i = 0; i < 7; i++) {
                Day emptyDay = new Day(new HashMap<>(), new HashMap<>());
                days.add(emptyDay);
            }
        }
    }

    protected void save() {

    }
}
