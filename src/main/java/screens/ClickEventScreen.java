// TODO documentation
package screens;

import delete_event_use_case.DeleteEventController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickEventScreen extends JFrame implements ActionListener {
    private final ModifyEventScreen modifyEventScreen;
    private final DeleteEventController deleteEventController;
    private int dayIndex;
    private String eventTitle;
    private String startTime;
    private String endTime;

    // TODO write ClickEventScreen

    public ClickEventScreen(ModifyEventScreen modifyEventScreen, DeleteEventController deleteEventController) {
        super("Event Menu");
        this.modifyEventScreen = modifyEventScreen;
        this.deleteEventController = deleteEventController;

        JPanel panel = new JPanel(new GridBagLayout());

        JButton modify = new JButton("modify event");
        JButton delete = new JButton("delete event");

        modify.addActionListener(this);
        modify.setActionCommand("modify");
        delete.addActionListener(this);
        delete.setActionCommand("delete");

        panel.add(modify);
        panel.add(delete);
        this.add(panel);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if ("modify".equals(e.getActionCommand())) {
            modifyEventScreen.setOldTitle(eventTitle);
            modifyEventScreen.setDayIndex(dayIndex);
            modifyEventScreen.setOldEndTime(endTime);
            modifyEventScreen.setOldStartTime(startTime);
            modifyEventScreen.setVisible(true);
        } else if ("delete".equals(e.getActionCommand())) {
            int confirmed = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to delete this event?", "Delete Event Message Box",
                    JOptionPane.YES_NO_OPTION);

            if (confirmed == JOptionPane.YES_OPTION) {
                deleteEventController.delete(eventTitle, dayIndex);
            }
        }
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
