package delete_event_use_case;

/**
 * Data Access Gateway interface. Contains methods such as eventExists and save to interact with the Data Access.
 * Methods are implemented in the data access class.
 *
 * @author Khizer Ahmad
 */
public interface DeleteEventDsGateway {
    boolean eventExists(int dayIndex, String eventTitle);

    void save(DeleteEventOutputData eventData);
}
