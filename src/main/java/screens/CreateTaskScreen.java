/**
 * Creates a screen with the form a user fills out when making a new task consisting of 7 radio
 * buttons representing the days of the week; a text field for the task title; and create and cancel
 * buttons. When the user clicks either the window's x button or the cancel button, the fields of the
 * form reset in preparation for the next time the form is used and
 * the window is hidden.
 * Author: Anna Myllyniemi
 * Modified by:
 * Date created: Nov 20 2022
 * Last modified:
 */

package screens;

import create_task_use_case.CreateTaskController;
import create_task_use_case.CreateTaskOutputData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CreateTaskScreen extends FormScreen{
    // Array containing all the radio buttons representing the day of the week
    protected final JRadioButton[] daysOfTheWeekRadioButtons;

    private final CreateTaskController createTaskController;

    /**
     * Creates a JPanel with 7 radio buttons, a JTextFields and its label, and two JButtons
     *
     * @param controller the controller to call when the user hits the create button
     */
    public CreateTaskScreen(CreateTaskController controller) {
        super("New Task");
        createTaskController = controller;
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = initializeConstraints();
        addHeader(panel, c, "CREATE A NEW TASK");

        daysOfTheWeekRadioButtons = createRadioButtons();
        addDaysOfTheWeekRadioButtons(panel, c, daysOfTheWeekRadioButtons);

        addTitleField(panel, c, 2, "Task Title:");

        addFormButtons(panel, c, 3, "Create");

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
     * Create radio buttons for each day of the week with Sunday selected by default
     * @return an array of JRadioButtons representng the days of the week
     */
    private JRadioButton[] createRadioButtons() {
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
     * @param evt the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        if ("Create".equals(evt.getActionCommand())) {
            String day = getSelectedDay();

            System.out.println("create");
            System.out.println(title.getText());
            System.out.println(day);

            // call controller
            CreateTaskOutputData outputData = createTaskController.create(day, title.getText());
            // TODO check my controller against Fardin's

            String message;
            if (outputData.isSuccessfullyCreated()) {
                resetForm();
                this.setVisible(false);
                message = "Task successfully created";
            } else {
                // TODO update message with Fardin's finalized use case and output data
                message = "A task with the same title already exists on " + day;
            }
            JFrame messageBox = new JFrame();
            JOptionPane.showMessageDialog(messageBox, message);

        } else if ("Cancel".equals(evt.getActionCommand())) {
            System.out.println("cancel");
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
        for (int i = 1; i < daysOfTheWeekRadioButtons.length; i++) {
            daysOfTheWeekRadioButtons[i].setSelected(false);
        }
        daysOfTheWeekRadioButtons[0].setSelected(true);
    }

    private String getSelectedDay() {
        for (JRadioButton radioButton: daysOfTheWeekRadioButtons) {
            if (radioButton.isSelected()) {
                return radioButton.getText();
            }
        }
        return "Sunday";
    }


}
