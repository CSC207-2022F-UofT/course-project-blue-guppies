package screens;

import complete_task_use_case.CompleteTaskController;
import delete_task_use_case.DeleteTaskController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickTaskScreen extends JFrame implements ActionListener {
    ModifyTaskScreen modifyTaskScreen;
    DeleteTaskController deleteTaskController;
    CompleteTaskController completeTaskController;
    int dayIndex;
    String taskTitle;

    public ClickTaskScreen(ModifyTaskScreen modifyTaskScreen, DeleteTaskController deleteTaskController,
                           CompleteTaskController completeTaskController) {
        super("Menu");
        this.modifyTaskScreen = modifyTaskScreen;
        this.deleteTaskController = deleteTaskController;
        this.completeTaskController = completeTaskController;

        JPanel panel = new JPanel(new GridBagLayout());

        JButton complete = new JButton("mark task as complete");
        JButton modify = new JButton("modify task");
        JButton delete = new JButton("delete task");

        complete.addActionListener(this);
        complete.setActionCommand("complete");
        modify.addActionListener(this);
        modify.setActionCommand("modify");
        delete.addActionListener(this);
        delete.setActionCommand("delete");

        panel.add(complete);
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
        if ("complete".equals(e.getActionCommand())) {
            completeTaskController.complete(dayIndex, taskTitle);
        } else if ("modify".equals(e.getActionCommand())) {
            modifyTaskScreen.setOldTitle(taskTitle);
            modifyTaskScreen.setDay(dayIndex);
            modifyTaskScreen.setVisible(true);
        } else if ("delete".equals(e.getActionCommand())) {
            int confirmed = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to delete this task?", "Delete Task Message Box",
                    JOptionPane.YES_NO_OPTION);

            if (confirmed == JOptionPane.YES_OPTION) {
                deleteTaskController.deleteTask(dayIndex, taskTitle);
            }
        }

    }

    public void setDayIndex(int dayIndex) {
        this.dayIndex = dayIndex;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }
}
