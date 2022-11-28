package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class WeekViewScreen extends JFrame implements WindowListener {
    public static final int HEIGHT = 550;
    public static final int WIDTH = 1100;
    ArrayList<JScrollPane> panels = new ArrayList<JScrollPane>();
    /*
     * - constructor
     * - week with 7 days
     *    - tasks and events separated
     * - clear all button
     * - New task button
     * - new event button
     * - click on a task and get three options: modify, mark as completed, and delete
     * - click on an event and get two options: modify and delete
     */

    public WeekViewScreen(Object[] controllers) {
        super();
        setTitle("Clean Calendar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //setting the bounds for the JFrame
        setBounds(0,0, WIDTH, HEIGHT);
        Container c = getContentPane();
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, WIDTH, HEIGHT / 5);
        panel.setBackground(Color.white);
        c.add(panel);

        for (int i = 0; i < 7; i++) {
            panels.add(halfDayPanel(i, false));
            panels.add(halfDayPanel(i, true));
        }
        for (JScrollPane p: panels) {
            c.add(p);
        }

        setVisible(true);

    }

    private static JScrollPane halfDayPanel(int dayIndex, boolean isEvent) {
        int width = WIDTH / 7;
        int height = 2 * HEIGHT / 5;
        int y = (isEvent) ? height + height / 2 : height / 2;
        int x = dayIndex * width;
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.setBounds(x, y, width, height);
        panel.add(new JLabel("Test"));
        JScrollPane scrollPane = new JScrollPane(panel);
        panel.setAutoscrolls(true);
        scrollPane.setBounds(x, y, width, height);
        return scrollPane;
    }

    /**
     * Invoked the first time a window is made visible.
     *
     * @param e the event to be processed
     */
    @Override
    public void windowOpened(WindowEvent e) {

    }

    /**
     * Invoked when the user attempts to close the window
     * from the window's system menu.
     *
     * @param e the event to be processed
     */
    @Override
    public void windowClosing(WindowEvent e) {
        // TODO: Are you sure? window
    }

    /**
     * Invoked when a window has been closed as the result
     * of calling dispose on the window.
     *
     * @param e the event to be processed
     */
    @Override
    public void windowClosed(WindowEvent e) {

    }

    /**
     * Invoked when a window is changed from a normal to a
     * minimized state. For many platforms, a minimized window
     * is displayed as the icon specified in the window's
     * iconImage property.
     *
     * @param e the event to be processed
     * @see Frame#setIconImage
     */
    @Override
    public void windowIconified(WindowEvent e) {

    }

    /**
     * Invoked when a window is changed from a minimized
     * to a normal state.
     *
     * @param e the event to be processed
     */
    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    /**
     * Invoked when the Window is set to be the active Window. Only a Frame or
     * a Dialog can be the active Window. The native windowing system may
     * denote the active Window or its children with special decorations, such
     * as a highlighted title bar. The active Window is always either the
     * focused Window, or the first Frame or Dialog that is an owner of the
     * focused Window.
     *
     * @param e the event to be processed
     */
    @Override
    public void windowActivated(WindowEvent e) {

    }

    /**
     * Invoked when a Window is no longer the active Window. Only a Frame or a
     * Dialog can be the active Window. The native windowing system may denote
     * the active Window or its children with special decorations, such as a
     * highlighted title bar. The active Window is always either the focused
     * Window, or the first Frame or Dialog that is an owner of the focused
     * Window.
     *
     * @param e the event to be processed
     */
    @Override
    public void windowDeactivated(WindowEvent e) {

    }

}
