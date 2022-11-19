package modify_event_use_case;

import java.time.LocalTime;

public interface ModifyEventDsGateway {
    boolean titleExistsInDay(int day, String title);

    boolean isTimeConflict(int day, String title, LocalTime newStart, LocalTime newEnd);
    void Save();
}
