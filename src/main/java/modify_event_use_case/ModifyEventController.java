package modify_event_use_case;

/**
 * Controller Class. Will be used by the event modification screen to execute modification. Calls methods
 * from the input boundary.
 * @author Daniel Livshits
 */
public class ModifyEventController {
    private final ModifyEventInputBoundary inputBoundary;

    public ModifyEventController(ModifyEventInputBoundary inputBound){
        this.inputBoundary = inputBound;
    }

    /**
     * Calls the input boundary to execute the application logic for event modification.
     *
     * @param title - The title of the event being modified.
     * @param dayIndex - The index representing the day the event is associated with.
     * @param newTitle - The new title for the event being modified.
     * @param newStart - The new start time for the event being modified.
     * @param newEnd - The new end time for the event being modified.
     * @return An instance of outputdata with the necessary information about the modification of the event.
     */
    public ModifyEventOutputData modify(String title, int dayIndex, String newTitle, String newStart, String newEnd){
        ModifyEventInputData inputData = new ModifyEventInputData(title, dayIndex, newTitle, newStart, newEnd);
        return inputBoundary.modify(inputData);
    }
}
