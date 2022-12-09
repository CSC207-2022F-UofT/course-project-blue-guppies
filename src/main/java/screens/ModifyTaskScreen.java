package screens;

import modify_task_use_case.ModifyTaskController;
import modify_task_use_case.ModifyTaskOutputData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Creates a screen with the form a user fills out to modify an existing task.
 * Contains a text field autofilled with the original task name, a modify
 * button, and a cancel button.
 *
 * @author Anna Myllyniemi
 */
public class ModifyTaskScreen extends FormScreen {
    private final ModifyTaskController modifyTaskController;
    private String oldTitle = "";
    private int dayIndex = 0;

    /**
     * Creates a JPanel with a JTextField and two JButtons
     *
     * @param controller the controller to call when the user hits the modify button
     */
    public ModifyTaskScreen(ModifyTaskController controller) {
        super("Modify Task");
        modifyTaskController = controller;

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = initializeConstraints();
        addHeader(panel, c, "MODIFY THE TASK");
        addTitleField(panel, c, 1, "Task Title:");
        addFormButtons(panel, c, 3, "Modify");
        this.add(panel);
    }

    /**
     * Reset the form values to the default
     */
    @Override
    protected void resetForm() {
        this.oldTitle = "";
        this.title.setText("");
        this.dayIndex = 0;
    }

    /**
     * @param evt the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        if ("Modify".equals(evt.getActionCommand())) {
            ModifyTaskOutputData outputData = modifyTaskController.modifyTask(dayIndex, title.getText(),
                    this.oldTitle);
            String message;
            if (outputData.getIsSuccessfullyModified()) {
                message = "Task successfully modified";
                resetForm();
                this.setVisible(false);
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
     * Sets the oldTitle variable and sets the text on the JTextField for the title to the value pre-modification.
     *
     * @param oldTitle The title of the task pre-modification
     */
    public void setOldTitle(String oldTitle) {
        this.oldTitle = oldTitle;
        this.title.setText(this.oldTitle);
    }

    /**
     * Sets the dayIndex variable.
     *
     * @param dayIndex The index of the day the task is on
     */
    public void setDayIndex(int dayIndex) {
        this.dayIndex = dayIndex;
    }
}
