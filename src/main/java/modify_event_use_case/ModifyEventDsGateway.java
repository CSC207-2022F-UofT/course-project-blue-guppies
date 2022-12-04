package modify_event_use_case;

import java.time.LocalTime;

/**
 * Data Access Gateway interface. Contains methods to interact with the database.
 * @author Daniel Livshits
 */
public interface ModifyEventDsGateway {
    boolean titleExistsInDay(int dayIndex, String title);

    boolean isTimeConflict(int dayIndex, String title, LocalTime newStart, LocalTime newEnd);

    void save(ModifyEventDsInputData dataAccessInput);
}
