package create_event_use_case;

import data_access.WeekDataAccess;

public class CreateEventDataAccess extends WeekDataAccess implements CreateEventDsGateway {
    @Override
    public boolean eventExistsByTitle(String title, int dayIndex) {
        return true;
    }

    @Override
    public void save(CreateEventDsInputData event) { }
}
