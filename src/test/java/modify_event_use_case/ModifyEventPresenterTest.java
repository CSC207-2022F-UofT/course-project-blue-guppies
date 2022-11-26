package modify_event_use_case;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class ModifyEventPresenterTest {
    ModifyEventPresenter samplePresenter = new ModifyEventPresenter();
    ModifyEventOutputData outputData =  new ModifyEventOutputData("Team Mtg", 6, "Blue Guppies Meeting",
                LocalTime.parse("15:00"), LocalTime.parse("16:00"));


    @Test
    void testPrepareSuccessView() {
        ModifyEventOutputData outputAfter = samplePresenter.prepareSuccessView(outputData);
        assertEquals(outputAfter, outputData);
    }

    @Test
    void testPrepareFailView() {
        outputData.setFailureMessage("more testing is required!");
        ModifyEventOutputData outputAfter = samplePresenter.prepareFailView(outputData);
        assertEquals("Team Mtg", outputAfter.getTitle());
        assertEquals(6, outputAfter.getDayIndex());
        assertEquals("Blue Guppies Meeting", outputAfter.getNewTitle());
        assertEquals(LocalTime.parse("15:00:00"), outputAfter.getNewStartTime());
        assertEquals(LocalTime.parse("16:00:00"), outputAfter.getNewEndTime());
        assertFalse(outputAfter.getSuccessfullyModified());
        assertEquals("more testing is required!", outputAfter.getFailureMessage());
    }
}