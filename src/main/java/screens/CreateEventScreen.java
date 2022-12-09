package screens;

import create_event_use_case.CreateEventController;
import create_event_use_case.CreateEventOutputData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Creates a screen with the form a user fills out when making a new event consisting of 7 radio
 * buttons representing the days of the week; text fields for the event title, start time, and
 * end time; and create and cancel buttons. When the user clicks either the window's x button or the
 * cancel button, the fields of the form reset in preparation for the next time the form is used and
 * the window is hidden.
 *
 * @author Anna Myllyniemi
 */
public class CreateEventScreen extends FormScreen {
    /**
     * Array containing all the radio buttons representing the day of the week
     */
    protected final JRadioButton[] daysOfTheWeekRadioButtons;

    /**
     * Start time of the event
     */
    protected final JTextField startTime = new JTextField();

    /**
     * End time of the event
     */
    protected final JTextField endTime = new JTextField();

    private final CreateEventController createEventController;

    /**
     * Creates a JPanel with 7 radio buttons, 3 JTextFields and their labels, and two JButtons
     *
     * @param controller the controller to call when the user hits the create button
     */
    public CreateEventScreen(CreateEventController controller) {
        super("New Event");
        createEventController = controller;
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = initializeConstraints();
        addHeader(panel, c, "CREATE A NEW EVENT");

        daysOfTheWeekRadioButtons = createRadioButtons();
        addDaysOfTheWeekRadioButtons(panel, c, daysOfTheWeekRadioButtons);

        addTitleField(panel, c, 2, "Event Title:");
        addTimeFields(panel, c);

        addFormButtons(panel, c, 4, "Create");

        this.add(panel);
    }

    /**
     * Group the radio buttons together
     */
    private void initializeRadioButtons() {
        ButtonGroup radioGroup = new ButtonGroup();
        for (JRadioButton radioButton : daysOfTheWeekRadioButtons) {
            radioGroup.add(radioButton);
        }
    }

    private void addDaysOfTheWeekRadioButtons(JPanel panel, GridBagConstraints constraints, JRadioButton[] radioButtons) {
        initializeRadioButtons();
        // Add the radio buttons
        constraints.gridwidth = 1; // each radio button takes 1 column
        constraints.gridy = 1;
        int columnIndex = 0;
        for (JRadioButton radioButton : radioButtons) {
            constraints.gridx = columnIndex;
            panel.add(radioButton, constraints);
            columnIndex++;
        }
    }

    /**
     * Create radio buttons for each day of the week with Sunday selected by default.
     *
     * @return an array of JRadioButtons representing the days of the week
     */
    private JRadioButton[] createRadioButtons() {
        return getRadioButtons();
    }

    static JRadioButton[] getRadioButtons() {
        JRadioButton sundayButton = new JRadioButton("Sunday");
        JRadioButton mondayButton = new JRadioButton("Monday");
        JRadioButton tuesdayButton = new JRadioButton("Tuesday");
        JRadioButton wednesdayButton = new JRadioButton("Wednesday");
        JRadioButton thursdayButton = new JRadioButton("Thursday");
        JRadioButton fridayButton = new JRadioButton("Friday");
        JRadioButton saturdayButton = new JRadioButton("Saturday");

        sundayButton.setSelected(true);

        return new JRadioButton[]{sundayButton, mondayButton, tuesdayButton,
                wednesdayButton, thursdayButton, fridayButton, saturdayButton};
    }

    /**
     * Adds the time fields to the form.
     *
     * @param panel       The JPanel to and the start and end time to
     * @param constraints The GridBagConstrains to use
     */
    private void addTimeFields(JPanel panel, GridBagConstraints constraints) {
        JLabel startTimeLabel = new JLabel("Start time:");
        JLabel endTimeLabel = new JLabel("End time:");

        // add start and end time and their labels
        constraints.gridwidth = 1; // component spans 1 column
        constraints.gridy = 3; // row 3
        constraints.gridx = 1; // col 1
        panel.add(startTimeLabel, constraints);
        constraints.gridx = 4; // col 4
        panel.add(endTimeLabel, constraints);
        constraints.gridx = 2; // col 2
        panel.add(startTime, constraints);
        constraints.gridx = 5; // col 5
        panel.add(endTime, constraints);
    }

    /**
     * @param evt the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        if ("Create".equals(evt.getActionCommand())) {
            String day = getSelectedDay();

            CreateEventOutputData outputData = createEventController.create(day, title.getText(), startTime.getText(),
                    endTime.getText());

            String message;
            if (outputData.isSuccess()) {
                resetForm();
                this.setVisible(false);
                message = "Event successfully created";
            } else {
                message = outputData.getErrorMessage();
            }
            JFrame messageBox = new JFrame();
            JOptionPane.showMessageDialog(messageBox, message);
        } else if ("Cancel".equals(evt.getActionCommand())) {
            this.setVisible(false);
            resetForm();
        }

    }

    /**
     * Reset the form values to the default
     */
    @Override
    protected void resetForm() {
        title.setText("");
        startTime.setText("");
        endTime.setText("");
        for (int i = 1; i < daysOfTheWeekRadioButtons.length; i++) {
            daysOfTheWeekRadioButtons[i].setSelected(false);
        }
        daysOfTheWeekRadioButtons[0].setSelected(true);
    }

    private String getSelectedDay() {
        for (JRadioButton radioButton : daysOfTheWeekRadioButtons) {
            if (radioButton.isSelected()) {
                return radioButton.getText();
            }
        }
        return "Sunday";
    }

}