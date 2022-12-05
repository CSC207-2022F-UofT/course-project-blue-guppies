package clear_all_use_case;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ClearAllPresenterTest {

    private final static ClearAllOutputData OUTPUT_DATA = new ClearAllOutputData();
    private final static ClearAllOutputBoundary OUTPUT_BOUNDARY = new ClearAllPresenter();

    @Test
    void testPrepareSuccessView() {
        ClearAllOutputData outputData = OUTPUT_BOUNDARY.prepareSuccessView(OUTPUT_DATA);

        assertTrue(outputData.getSuccess());
    }
}
