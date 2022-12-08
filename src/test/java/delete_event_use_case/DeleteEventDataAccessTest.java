package delete_event_use_case;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteEventDataAccessTest {
    final DeleteEventDataAccess dataAccess = new DeleteEventDataAccess();

    @Test
    void testSave() {
        DeleteEventOutputData outputData = new DeleteEventOutputData(1, "MAT237");
        dataAccess.save(outputData);
        assertFalse(dataAccess.getDays().get(1).getEvents().containsKey("MAT237"));
    }
}
