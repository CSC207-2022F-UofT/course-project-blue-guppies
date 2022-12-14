package delete_event_use_case;

import data_access.WeekDataAccess;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.*;

class DeleteEventDataAccessTest {
    final DeleteEventDataAccess dataAccess = new DeleteEventDataAccess();

    @Test
    void testSave() {
        DeleteEventOutputData outputData = new DeleteEventOutputData(1, "MAT237");
        dataAccess.save(outputData);
        assertFalse(WeekDataAccess.getDays().get(1).getEvents().containsKey("MAT237"));
    }

    @AfterEach
    public void clearStorage(){
        try {
            PrintWriter pw = new PrintWriter("CleanCalendarStorage.txt"); //deleting the contents of the file
            pw.close();
        }
        catch(IOException ignored){
        }
    }
}
