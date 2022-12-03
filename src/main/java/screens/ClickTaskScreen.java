package screens;

import complete_task_use_case.CompleteTaskController;
import complete_task_use_case.CompleteTaskOutputData;
import delete_task_use_case.DeleteTaskController;
import delete_task_use_case.DeleteTaskOutputData;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The menu a user sees when they click on a task in the week view with the options to delete, modify or toggle
 * the completion status of a task.
 * @author Anna Myllyniemi
 */
public class ClickTaskScreen extends JFrame implements ActionListener {
    private final ModifyTaskScreen modifyTaskScreen;
    private final DeleteTaskController deleteTaskController;
    private final CompleteTaskController completeTaskController;

    /**
     * The button for toggling task completion status.
     */
    private final JButton toggleCompletionStatus =
            new JButton("\u00A0\u00A0\u00A0Mark task as completed\u00A0\u00A0\u00A0");
    // nbsp added to ensure both possible button texts will fit in the button (uncompleted vs completed)
    // as button size is determined when it is created and the button should start with completed, the shorter version

    private int dayIndex;
    private String taskTitle;
    private boolean taskCompleted = false;

    /**
     * Creates a menu with delete button, modify button, and complete or uncomplete task button.
     *
     * @param modifyTaskScreen Screen used for task modification
     * @param deleteTaskController Controller for delete task use case
     * @param completeTaskController Controller for complete task use case
     */
    public ClickTaskScreen(ModifyTaskScreen modifyTaskScreen, DeleteTaskController deleteTaskController,
                           CompleteTaskController completeTaskController) {
        super("Task Menu");
        this.modifyTaskScreen = modifyTaskScreen;
        this.deleteTaskController = deleteTaskController;
        this.completeTaskController = completeTaskController;

        JPanel panel = new JPanel(new GridLayout(1, 3, 10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Create and setup buttons
        JButton modify = new JButton("modify task");
        JButton delete = new JButton("delete task");

        toggleCompletionStatus.addActionListener(this);
        toggleCompletionStatus.setActionCommand("toggle completion");
        modify.addActionListener(this);
        modify.setActionCommand("modify");
        delete.addActionListener(this);
        delete.setActionCommand("delete");

        panel.add(toggleCompletionStatus);
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
        if ("toggle completion".equals(e.getActionCommand())) {
            CompleteTaskOutputData outputData = completeTaskController.completeTask(dayIndex, taskTitle);
            String message;
            if (outputData.isSuccess()) {
                message = "Task marked as " + ((taskCompleted) ? "incomplete" : "completed");
            } else {
                message = outputData.getErrorMessage();
            }
            JFrame messageBox = new JFrame();
            JOptionPane.showMessageDialog(messageBox, message);
            setTaskCompleted(!taskCompleted);
        } else if ("modify".equals(e.getActionCommand())) {

            // Set the variables in modifyTaskScreen to the values of the task clicked
            modifyTaskScreen.setOldTitle(taskTitle);
            modifyTaskScreen.setDayIndex(dayIndex);

            modifyTaskScreen.setVisible(true);
        } else if ("delete".equals(e.getActionCommand())) {

            // confirm the user wants to delete
            int confirmed = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to delete this task?", "Delete Task Message Box",
                    JOptionPane.YES_NO_OPTION);

            if (confirmed == JOptionPane.YES_OPTION) {
                DeleteTaskOutputData outputData = deleteTaskController.deleteTask(dayIndex, taskTitle);

                // Check success of use case
                String message;
                if (outputData.isSuccess()) {
                    this.setVisible(false);
                    message = "Task successfully deleted";
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
     * Set the dayIndex variable.
     *
     * @param dayIndex The index of the day the task is on
     */
    public void setDayIndex(int dayIndex) {
        this.dayIndex = dayIndex;
    }

    /**
     * Set the taskTitle variable.
     *
     * @param taskTitle The title of the task
     */
    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    /**
     * Set the toggle task completed button to show the correct text and set the taskCompleted variable.
     *
     * @param completed True if the task is currently marked as completed and false otherwise
     */
    public void setTaskCompleted(boolean completed) {
        this.taskCompleted = completed;
        if (completed) {
            toggleCompletionStatus.setText("Mark task as uncompleted");
        } else {
            toggleCompletionStatus.setText("Mark task as completed");
        }

    }
}
