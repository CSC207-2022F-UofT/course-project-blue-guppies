/**
 * Task Modification Presenter Test Cases.
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 19, 2022
 * Last Modified: Nov 26, 2022
 */
package modify_task_use_case;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ModifyTaskPresenterTest {
    private final static ModifyTaskOutputData outputData = new ModifyTaskOutputData(
            "Sample Task", 0
    );
    private final static String error = "ERROR!";
    private final static ModifyTaskPresenter outputBoundary = new ModifyTaskPresenter();

    @Test
    public void testPrepareSuccessView(){
        ModifyTaskOutputData response = outputBoundary.prepareSuccessView(
                outputData
        );
        assertEquals(0, response.getDayID());
        assertEquals("Sample Task", response.getTitle());
    }

    @Test
    public void testPrepareFailView(){
        try {
            ModifyTaskOutputData response = outputBoundary.prepareFailView(
                    error
            );
        } catch (ModifyTaskFailed e) {
            assertEquals("ERROR!", e.getMessage());
        }
    }
}
