package screens;

import modify_event_use_case.ModifyEventController;
import modify_event_use_case.ModifyEventOutputData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Creates a screen with the form a user fills out when modifying an existing event, and is autopopulated with the
 * current values of the event to be modified. When the user cancels or closes the form no changes are made. When the
 * user submits the form the modify event use case is called. User can modify the start and end time of an event, along
 * with its title. Form similar to when creating a new event.
 * @author Anna Myllyniemi
 */
public class ModifyEventScreen extends FormScreen {
    private final ModifyEventController modifyEventController;

    /**
     * Start time of the event
     */
    protected final JTextField startTime = new JTextField(20);

    /**
     * End time of the event
     */
    protected final JTextField endTime = new JTextField(20);
    private String oldTitle = "";
    private String oldStartTime = "";
    private String oldEndTime = "";
    private int dayIndex = 0;

    /**
     * Saves the controller to use for this use case and creates the modify event form.
     *
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

    /**
     * Adds the time fields to the form.
     *
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
        CreateEventScreen.addPanel(panel, constraints, startTimeLabel, endTimeLabel, startTime, endTime);
    }


    /**
     * Reset the form values to the default.
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
            String message;
            ModifyEventOutputData outputData = modifyEventController.modify(oldTitle, dayIndex, title.getText(), startTime.getText(),
                    endTime.getText());
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
            this.setVisible(false);
            resetForm();
        }

    }

    /**
     * Sets the oldStartTime variable and sets the text on the JTextField for the start time to the value
     * pre-modification.
     *
     * @param oldStartTime The start time of the event pre-modification
     */
    public void setOldStartTime(String oldStartTime) {
        this.oldStartTime = oldStartTime;
        this.startTime.setText(this.oldStartTime);
    }

    /**
     * Sets the oldEndTime variable and sets the text on the JTextField for the end time to the value
     * pre-modification.
     *
     * @param oldEndTime The end time of the event pre-modification
     */
    public void setOldEndTime(String oldEndTime) {
        this.oldEndTime = oldEndTime;
        this.endTime.setText(this.oldEndTime);
    }

    /**
     * Sets the dayIndex variable.
     *
     * @param dayIndex Index of the day the event is on
     */
    public void setDayIndex(int dayIndex) {
        this.dayIndex = dayIndex;
    }

    /**
     * Sets the oldTitle variable and sets the text on the JTextField for the title to the value pre-modification.
     *
     * @param oldTitle The title of the event pre-modification
     */
    public void setOldTitle(String oldTitle) {
        this.oldTitle = oldTitle;
        this.title.setText(this.oldTitle);
    }
}
