package modify_task_use_case;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ModifyTaskOutputDataTest {
    private final static ModifyTaskOutputData outputData = new ModifyTaskOutputData(
            "Title", 0
    );

    @Test
    void testGetTitle() {
        assertEquals("Title", outputData.getTitle());
    }

    @Test
    void testGetDayID() {
        assertEquals(0, outputData.getDayID());
    }
}
