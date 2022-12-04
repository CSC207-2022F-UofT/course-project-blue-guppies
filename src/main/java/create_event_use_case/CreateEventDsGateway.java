package create_event_use_case;

public interface CreateEventDsGateway {
    boolean eventExistsByTitle(String title, int dayIndex);

    void save(CreateEventDsInputData event);
}
