package delete_event_use_case;

/**
 * Controller Class.
 * Invokes the implementations of deleteEvent given by DeleteEventInteractor, where it will be
 * used to execute a deletion of an event, calling methods from the input boundary.
 * @author Ricky Fung
 */
public class DeleteEventController {

    private DeleteEventInputBoundary deleteEventInput;

    public DeleteEventController(DeleteEventInputBoundary deleteEventInput) {
        this.deleteEventInput = deleteEventInput;
    }


    /**
     * Called by the inputBoundary to execute steps necessary for event deletion
     * @param eventTitle The title of the to-be deleted event.
     * @param dayIndex The index of the day the task is associated with for WeekDataAccess days.
     * @return An instance of DeleteEventOutputData which reveals if the task
     * for deletion was successful.
     */    public DeleteEventOutputData delete(String eventTitle, int dayIndex){
        DeleteEventInputData eventInputData = new DeleteEventInputData(dayIndex, eventTitle);

        return deleteEventInput.delete(eventInputData);
    }
}