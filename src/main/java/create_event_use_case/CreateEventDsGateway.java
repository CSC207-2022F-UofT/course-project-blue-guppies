package create_event_use_case;

import java.time.LocalTime;

/**
 * Ds Gateway for the Create Event use case. Methods in this interface are
 * implemented by the Data Access class.
 *
 * @author Anna Myllyniemi
 */
public interface CreateEventDsGateway {
    boolean eventExistsByTitle(String title, int dayIndex);

    boolean isTimeConflict(int dayIndex, LocalTime startTime, LocalTime endTime);

    void save(CreateEventDsInputData dsInputData);
}
