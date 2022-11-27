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
    int dayId;
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
            completeTaskController.complete(dayId, taskTitle);
        } else if ("modify".equals(e.getActionCommand())) {
            modifyTaskScreen.setOldTitle(taskTitle);
            modifyTaskScreen.setDay(dayId);
            modifyTaskScreen.setVisible(true);
        } else if ("delete".equals(e.getActionCommand())) {
            Frame confirm = new JFrame();
            int x = JOptionPane.showOptionDialog(confirm, "Are you sure you want to delete this task?",
                    "Delete Task", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                    new String[] {"Yes", "Cancel"}, "Yes");
            if (x == 0) {
                deleteTaskController.deleteTask(dayId, taskTitle);
            }
        }

    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }
}
