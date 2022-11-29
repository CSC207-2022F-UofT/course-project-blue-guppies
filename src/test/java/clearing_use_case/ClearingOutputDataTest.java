package clearing_use_case;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClearingOutputDataTest {
    private final static ClearingOutputData outputData = new ClearingOutputData();

    @Test
    void getSuccess() {
        assertFalse(outputData.getSuccess());
    }

    @Test
    void setSuccess() {
        outputData.setSuccess(true);
        assertTrue(outputData.getSuccess());
    }
}
