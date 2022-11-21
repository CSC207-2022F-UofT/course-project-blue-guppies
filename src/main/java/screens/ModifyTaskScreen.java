/**
 * Creates a screen with the form a user fills out to modify an existing task.
 * Contains a text field autofilled with the original task name, a modify
 * button and a cancel button.
 * Author: Anna Myllyniemi
 * Modified by:
 * Date created: Nov 20 2022
 * Last modified:
 */
package screens;

import modify_task_use_case.ModifyTaskController;
import modify_task_use_case.ModifyTaskFailed;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ModifyTaskScreen extends FormScreen{
    private final ModifyTaskController modifyTaskController;
    private String oldTitle = "";
    private int day = 0;

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
        this.day = 0;
    }

    /**
     * @param evt the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        if ("Modify".equals(evt.getActionCommand())) {
            System.out.println("modify");
            System.out.println("new title: " + title.getText());
            System.out.println("old title: " + this.oldTitle);
            System.out.println("day: " + day);

            String message;
            try {
                modifyTaskController.modifyTask(day, title.getText(), this.oldTitle);
                message = "Task successfully modified";
                resetForm();
                this.setVisible(false);
            } catch (ModifyTaskFailed e) {
                message = e.getMessage();
            } catch (Exception e2) {
                message = "unexpected error";
            }

            JFrame messageBox = new JFrame();
            JOptionPane.showMessageDialog(messageBox, message);
        } else if ("Cancel".equals(evt.getActionCommand())) {
            System.out.println("cancel");
            this.setVisible(false);
            resetForm();
        }

    }

    public void setOldTitle(String oldTitle) {
        this.oldTitle = oldTitle;
        this.title.setText(this.oldTitle);
    }

    public void setDay(int day) {
        this.day = day;
    }
}
