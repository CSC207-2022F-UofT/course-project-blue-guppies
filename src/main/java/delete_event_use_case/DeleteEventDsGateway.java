package delete_event_use_case;

/**
 * Delete Event DsGateway Interface.
 * @author : Khizer Ahmad
 * @created: November 19th 2022
 * @since : 2022-11-21, Mon.
 **/
public interface DeleteEventDsGateway {
    boolean eventExists(int dayIndex, String eventTitle);

    void save(DeleteEventOutputData eventData);
}
