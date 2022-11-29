/**
 * Clearing DataAccess Class.
 * Author: Ricky Fung
 * Modified By: Ricky Fung
 * Created: Nov 29, 2022
 * Last Modified: Nov 29, 2022
 */
package clearing_use_case;

import data_access.DataAccessDay;
import data_access.WeekDataAccess;

public class ClearingDataAccess extends WeekDataAccess implements ClearingDsGateway {

    @Override
    public void saveInfo() {
        for(DataAccessDay day : days){
            day.getEvents().clear();
            day.getTasks().clear();
        }
        this.save();
    }
}
