package data_access;

import entities.Day;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * The superclass for data access, with a static attribute and private method to be shared across all create_event_use_case.CreateEventPresenter.data_access.DataAccess
 * classes.
 *
 * @author Daniel Livshits, Khizer Ahmad
 */
public class WeekDataAccess implements Serializable {

    /**
     * The ArrayList of days to be used for data persistence. The state of this data structure is saved
     * to a .ser file.
     */
    protected static ArrayList<Day> days = new ArrayList<>();
    private static long serialVersionUID = 1L;

    /**
     * Initializes days to a week with 7 empty days if it hasn't already been initialized.
     */
    public WeekDataAccess() {
        if (days.isEmpty()) {
            for (int i = 0; i < 7; i++) {
                Day emptyDay = new Day(new HashMap<>(), new HashMap<>());
                days.add(emptyDay);
            }
        }
    }

    public static ArrayList<Day> getDays() {
        return days;
    }

    public static void setDays(ArrayList<Day> days) {
        WeekDataAccess.days = days;
    }

    /**
     * Writes the contents of the days class variable onto a .ser file, persisting data
     *
     * @param days an ArrayList whose indices contain Day objects that contain
     *             two hashmaps that contain events and tasks separately, representing the
     *             week schedule
     */
    protected static void writeObject(ArrayList<Day> days) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("CleanCalendarStorage.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(new ArrayList<>(days));
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    /**
     * Reads the object from the .ser file and reinitialized day
     */
    public static void readObject() throws ClassNotFoundException, IOException {
        File file = new File("CleanCalendarStorage.txt");
        if (file.length() != 0) {//program has been initialized, assuming some content has been added
            FileInputStream fileInputStream = new FileInputStream("CleanCalendarStorage.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            WeekDataAccess.days = (ArrayList<Day>) objectInputStream.readObject();
            objectInputStream.close();
        } else {
            WeekDataAccess.days = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                Day emptyDay = new Day(new HashMap<>(), new HashMap<>());
                days.add(emptyDay);
            }
        }
    }

    /**
     * Save method. Saves the contents of days into a .ser file to enforce data persistence.
     */
    protected void save() {
        try {
            WeekDataAccess.writeObject(WeekDataAccess.days);
        } catch (IOException ignored) {
        }
    }
}
