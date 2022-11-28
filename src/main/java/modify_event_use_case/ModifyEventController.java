/**
 * Controller Class. Will be used by the event modification screen to execute modification. Calls methods
 * from the input boundary.
 * Author: Daniel Livshits
 * Created: Nov 19, 2022
 * Modified by:
 * Last Modified: Nov 19, 2022
 */
package modify_event_use_case;

public class ModifyEventController {
    private final ModifyEventInputBoundary inputBoundary;

    public ModifyEventController(ModifyEventInputBoundary inputBound){
        this.inputBoundary = inputBound;
    }

    /**
     * Calls the input boundary to execute the necessary steps event modification.
     * @param title - the title of the event being modified
     * @param dayIndex - the index representing the day the event is associated with
     * @param newTitle - the new title for the event being modified.
     * @param newStart - the new start time for the event being modified.
     * @param newEnd - the new end time for the event being modified.
     * Precondition: newStart.isBefore(newEnd)
     * @return an instance of outputdata with the necessary information about the modification of the event
     */
    public ModifyEventOutputData modify(String title, int dayIndex, String newTitle, String newStart, String newEnd){
        ModifyEventInputData inputData = new ModifyEventInputData(title, dayIndex, newTitle, newStart, newEnd);
        return inputBoundary.modify(inputData);
    }
}
