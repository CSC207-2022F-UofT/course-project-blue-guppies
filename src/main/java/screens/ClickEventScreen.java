package screens;

import delete_event_use_case.DeleteEventController;
import delete_event_use_case.DeleteEventOutputData;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The menu a user sees when they click on an event in the week view with the options to delete or modify the event.
 * @author Anna Myllyniemi
 */
public class ClickEventScreen extends JFrame implements ActionListener {
    private final ModifyEventScreen modifyEventScreen;
    private final DeleteEventController deleteEventController;
    private int dayIndex;
    private String eventTitle;
    private String startTime;
    private String endTime;

    /**
     * Creates the menu with delete button and modify button
     *
     * @param modifyEventScreen Screen used for event modification
     * @param deleteEventController Controller for delete event use case
     */
    public ClickEventScreen(ModifyEventScreen modifyEventScreen, DeleteEventController deleteEventController) {
        super("Event Menu");
        this.modifyEventScreen = modifyEventScreen;
        this.deleteEventController = deleteEventController;

        JPanel panel = new JPanel(new GridLayout(1, 2, 10, 5));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Create and setup buttons
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

            // Set the variables in modifyEventScreen to the values of the event clicked
            modifyEventScreen.setOldTitle(eventTitle);
            modifyEventScreen.setDayIndex(dayIndex);
            modifyEventScreen.setOldEndTime(endTime);
            modifyEventScreen.setOldStartTime(startTime);

            modifyEventScreen.setVisible(true);
        } else if ("delete".equals(e.getActionCommand())) {

            // Confirm the user wants to delete
            int confirmed = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to delete this event?", "Delete Event Message Box",
                    JOptionPane.YES_NO_OPTION);

            if (confirmed == JOptionPane.YES_OPTION) {
                DeleteEventOutputData outputData = deleteEventController.delete(eventTitle, dayIndex);

                // Check success of use case
                String message;
                if (outputData.getSuccess()) {
                    this.setVisible(false);
                    message = "Event successfully deleted";
                } else {
                    message = outputData.getErrorMessage();
                }

                // Show success or failure message for deletion
                JFrame messageBox = new JFrame();
                JOptionPane.showMessageDialog(messageBox, message);
            }
        }
    }

    /**
     * Set dayIndex variable.
     *
     * @param dayIndex Index of the day the event is on
     */
    public void setDayIndex(int dayIndex) {
        this.dayIndex = dayIndex;
    }

    /**
     * Set eventTitle variable.
     *
     * @param eventTitle The title of the event
     */
    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    /**
     * Set startTime variable.
     *
     * @param startTime The start time of the event
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * Set endTime variable.
     *
     * @param endTime The end time of the event
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
