package screens;

import complete_task_use_case.CompleteTaskController;
import delete_task_use_case.DeleteTaskController;
import modify_task_use_case.ModifyTaskController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickTaskScreen extends JFrame implements ActionListener {
    ModifyTaskController modifyTaskController;
    DeleteTaskController deleteTaskController;
    CompleteTaskController completeTaskController;
    int dayId;
    String title;

    /**
     * Creates a new, initially invisible <code>Frame</code> with the
     * specified title.
     * <p>
     * This constructor sets the component's locale property to the value
     * returned by <code>JComponent.getDefaultLocale</code>.
     * @throws HeadlessException if GraphicsEnvironment.isHeadless()
     *                           returns true.
     * @see GraphicsEnvironment#isHeadless
     * @see Component#setSize
     * @see Component#setVisible
     * @see JComponent#getDefaultLocale
     */
    public ClickTaskScreen(ModifyTaskController modifyTaskController, DeleteTaskController deleteTaskController,
                           CompleteTaskController completeTaskController) {
        super("Menu");
        this.modifyTaskController = modifyTaskController;
        this.deleteTaskController = deleteTaskController;
        this.completeTaskController = completeTaskController;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private void resetValues() {
        this.dayId = 0;
        this.title = "";
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }
}
