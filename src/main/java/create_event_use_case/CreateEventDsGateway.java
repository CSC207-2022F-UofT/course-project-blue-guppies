package create_event_use_case;

import java.time.LocalTime;

public interface CreateEventDsGateway {
    boolean eventExistsByTitle(String title, int dayIndex);

    boolean isTimeConflict(int dayIndex, LocalTime startTime, LocalTime endTime);

    void save(CreateEventDsInputData dsInputData);
}
