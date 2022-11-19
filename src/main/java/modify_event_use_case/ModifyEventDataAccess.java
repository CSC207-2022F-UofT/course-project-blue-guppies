package modify_event_use_case;

import data_access.WeekDataAccess;

public class ModifyEventDataAccess extends WeekDataAccess {
    public void Save(ModifyEventDataAccessInput dataAccessInput){
        // mutate the days class attribute from WeekDataAccess
        super.save();
    }
}
