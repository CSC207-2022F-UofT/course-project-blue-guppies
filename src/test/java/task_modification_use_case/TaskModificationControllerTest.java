package task_modification_use_case;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskModificationControllerTest {
    private final static TaskModificationPresenter outputBoundary = new TaskModificationPresenter();
    private final static TaskModificationDataAccess dsGateway = new TaskModificationDataAccess();
    private final static int dayId = 0;
    private final static String newTitle = "New Sample Task";
    private final static String title = "Sample Task";

    @Test
    public void testModifyTask(){
        TaskModificationInteractor inputBoundary = new TaskModificationInteractor(
                outputBoundary, dsGateway
        );
        TaskModificationController controller = new TaskModificationController(inputBoundary);
        TaskModificationOutputData outputData = controller.modifyTask(
                dayId, newTitle, title
        );
        assertEquals(0, outputData.getDayId());
        assertEquals("New Sample Task", outputData.getTitle());
    }
}