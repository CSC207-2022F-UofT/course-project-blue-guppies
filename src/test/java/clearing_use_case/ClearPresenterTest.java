package clearing_use_case;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ClearPresenterTest {

    private final static ClearingOutputData success = new ClearingOutputData();

    @Test
    void testPrepareSuccessView() {
        ClearingOutputBoundary outputBoundary = new ClearingPresenter();
        ClearingOutputData response = outputBoundary.prepareSuccessView(success);

        assertTrue(response.getSuccess());
    }
}
