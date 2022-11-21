package delete_event_use_case;

/**
 * Delete Event Controller class.
 * @author : Khizer Ahmad
 * @created: November 19th 2022
 * @since : 2022-11-21, Mon.
 **/
public class DeleteEventController {

    private DeleteEventInputBoundary deleteEventInput;

    public DeleteEventController(DeleteEventInputBoundary deleteEventInput) {
        this.deleteEventInput = deleteEventInput;
    }

    DeleteEventOutputData delete(String eventTitle, int dayIndex){
        DeleteEventInputData eventInputData = new DeleteEventInputData(dayIndex, eventTitle);

        return deleteEventInput.delete(eventInputData);
    }
}