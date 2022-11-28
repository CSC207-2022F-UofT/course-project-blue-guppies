// TODO documentation
package screens;

import delete_event_use_case.DeleteEventController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickEventScreen extends JFrame implements ActionListener {
    private int dayIndex;
    private String eventTitle;
    private String startTime;
    private String endTime;

    // TODO write ClickEventScreen

    public ClickEventScreen(ModifyEventScreen modifyEventScreen, DeleteEventController deleteEventController) {
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void setDayIndex(int dayIndex) {
        this.dayIndex = dayIndex;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
