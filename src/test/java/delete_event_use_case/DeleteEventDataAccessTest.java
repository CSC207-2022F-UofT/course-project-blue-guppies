/**
 * Delete Event Interactor Testing class.
 * @author : Khizer Ahmad
 * @created: November 19th 2022
 * @since : 2022-11-28, Mon.
 **/
package delete_event_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class DeleteEventDataAccessTest {
    DeleteEventDataAccess dataAccess = new DeleteEventDataAccess();

    @Test
    void testSave() {
        DeleteEventOutputData outputData = new DeleteEventOutputData(1, "MAT237");
        dataAccess.save(outputData);
        assertEquals("MAT237", dataAccess.getDays().get(1).getEvents().get("MAT237").getTitle());
    }
}
