/**
 * Input boundary interface. Contains a modify method that returns Output Data.
 * Author: Daniel Livshits
 * Created: Nov 19, 2022
 * Modified by:
 * Last Modified: Nov 19, 2022
 */
package modify_event_use_case;

public interface ModifyEventInputBoundary {
    ModifyEventOutputData modify(ModifyEventInputData inputData);
}
