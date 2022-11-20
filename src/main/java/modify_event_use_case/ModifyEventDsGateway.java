package modify_event_use_case;

import java.time.LocalTime;

public interface ModifyEventDsGateway {
    boolean titleExistsInDay(int dayIndex, String title);

    boolean isTimeConflict(int dayIndex, String title, LocalTime newStart, LocalTime newEnd);
    void save(ModifyEventDataAccessInput dataAccessInput);
}
