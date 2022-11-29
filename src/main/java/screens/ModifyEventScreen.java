/**
 * Creates a screen with the form a user fills out when modifying an existing event, and is auto-populated with the
 * current values of the event to be modified. When the user cancels or closes the form no changes are made. When the
 * user submits the form the modify event use case is called. User can modify the start and end time of an event, along
 * with its title. Form similar to when creating a new event.
 * Author: Anna Myllyniemi
 * Modified by:
 * Date created: Nov 28 2022
 * Last modified:
 */
package screens;

import modify_event_use_case.ModifyEventController;
import modify_event_use_case.ModifyEventOutputData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ModifyEventScreen extends FormScreen {
    private final ModifyEventController modifyEventController;

    // Start time of the event
    protected final JTextField startTime = new JTextField(20);

    // End time of the event
    protected final JTextField endTime = new JTextField(20);
    private String oldTitle = "";
    private String oldStartTime = "";
    private String oldEndTime = "";
    private int dayIndex = 0;

    /** Saves the controller to use for this use case and creates the modify event form
     * @param modifyEventController The controller for the modify event use case
     */
    public ModifyEventScreen(ModifyEventController modifyEventController) {
        super("Modify Event");
        this.modifyEventController = modifyEventController;

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = initializeConstraints();
        addHeader(panel, c, "MODIFY THE EVENT");

        addTitleField(panel, c, 1, "Event Title:");
        addTimeFields(panel, c);

        addFormButtons(panel, c, 3, "Modify");
        this.add(panel);
    }

    /** Adds the time fields to the form
     * @param panel The JPanel to and the start and end time to
     * @param constraints The GridBagConstrains to use
     */
    private void addTimeFields(JPanel panel, GridBagConstraints constraints) {
        JLabel startTimeLabel = new JLabel("Start time:");
        JLabel endTimeLabel = new JLabel("End time:");

        // add start and end time and their labels
        constraints.gridwidth = 1; // component spans 1 column
        constraints.gridy = 2; // row 2
        constraints.gridx = 0; // col 0
        panel.add(startTimeLabel, constraints);
        constraints.gridx = 4; // col 4
        panel.add(endTimeLabel, constraints);
        constraints.gridx = 2; // col 2
        panel.add(startTime, constraints);
        constraints.gridx = 5; // col 5
        panel.add(endTime, constraints);
    }


    /**
     * Reset the form values to the default
     */
    @Override
    protected void resetForm() {
        this.oldTitle = "";
        this.title.setText("");
        this.dayIndex = 0;
        this.oldStartTime = "";
        this.oldEndTime = "";
    }

    /**
     * Invoked when an action occurs.
     *
     * @param evt the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        if ("Modify".equals(evt.getActionCommand())) {
            System.out.println("modify");
            System.out.println("new title: " + title.getText());
            System.out.println("old title: " + this.oldTitle);
            System.out.println("new start time: " + startTime.getText());
            System.out.println("old start time: " + this.oldStartTime);
            System.out.println("new end time: " + endTime.getText());
            System.out.println("old end time: " + this.oldEndTime);
            System.out.println("day: " + dayIndex);

            String message;
            ModifyEventOutputData outputData = modifyEventController.modify(oldTitle, dayIndex, startTime.getText(),
                    endTime.getText(), title.getText());
            if (outputData.getSuccessfullyModified()) {
                message = "Event successfully modified";
                resetForm();
                this.setVisible(false);
            } else {
                message = outputData.getFailureMessage();
            }

            JFrame messageBox = new JFrame();
            JOptionPane.showMessageDialog(messageBox, message);
        } else if ("Cancel".equals(evt.getActionCommand())) {
            System.out.println("cancel");
            this.setVisible(false);
            resetForm();
        }

    }

    public void setOldStartTime(String oldStartTime) {
        this.oldStartTime = oldStartTime;
        this.startTime.setText(this.oldStartTime);
    }

    public void setOldEndTime(String oldEndTime) {
        this.oldEndTime = oldEndTime;
        this.endTime.setText(this.oldEndTime);
    }

    public void setDayIndex(int dayIndex) {
        this.dayIndex = dayIndex;
    }

    public void setOldTitle(String oldTitle) {
        this.oldTitle = oldTitle;
        this.title.setText(this.oldTitle);
    }
}
