/**
 * Delete Event DsGateway Interface.
 * @author : Khizer Ahmad
 * @created: November 19th 2022
 * @since : 2022-11-28, Mon.
 **/

package delete_event_use_case;
public interface DeleteEventDsGateway {
    boolean eventExists(int dayIndex, String eventTitle);

    void save(DeleteEventOutputData eventData);
}
