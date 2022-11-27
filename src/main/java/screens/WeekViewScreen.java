package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WeekViewScreen extends JFrame implements WindowListener {
    //TODO write WeekViewClass
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
        setLayout(null);
        //setting the bounds for the JFrame
        setBounds(100,100,1000,550);
        Container c=getContentPane();
        //Creating a JPanel for the JFrame
        JPanel panel = halfDayPanel("Buttons/header", 0, 0, 1000, 0, 100, Color.yellow, 0);
        c.add(panel);

        JPanel sundayTop = halfDayPanel("sunday top", 39, 100 ,100, 100, 200, Color.green, 20);
        c.add(sundayTop);
        JPanel sundayBottom = halfDayPanel("sunday bottom", 39, 300 ,100, 100, 200, Color.blue, 20);
        c.add(sundayBottom);

        JPanel mondayTop = halfDayPanel("monday top", 176, 100 ,100, 100, 200, Color.blue, 20);
        c.add(mondayTop);
        JPanel mondayBottom = halfDayPanel("monday bottom", 176, 300 ,100, 100, 200, Color.green, 20);
        c.add(mondayBottom);

        JPanel tuesdayTop = halfDayPanel("tuesday top", 313, 100 ,100, 100, 200, Color.green, 20);
        c.add(tuesdayTop);
        JPanel tuesdayBottom = halfDayPanel("tuesday bottom", 313, 300 ,100, 100, 200, Color.blue, 20);
        c.add(tuesdayBottom);

        JPanel wednesdayTop = halfDayPanel("wednesday top", 450, 100 ,100, 100, 200, Color.blue, 20);
        c.add(wednesdayTop);
        JPanel wednesdayBottom = halfDayPanel("wednesday bottom", 450, 300 ,100, 100, 200, Color.green, 20);
        c.add(wednesdayBottom);

        // TODO make positioning relative to variables. like make a window width variable and such
        // TODO add rest of days

        setVisible(true);

    }

    private static JPanel halfDayPanel(String title, int x, int y, int width, int width1, int height, Color blue, int x1) {
        JPanel panel=new JPanel();
        panel.setLayout(null);
        JLabel labelM1=new JLabel(title);
        labelM1.setBounds(x1,0, width, height);
        panel.add(labelM1);
        panel.setBackground(blue);
        panel.setBounds(x, y, width, height);
        return panel;
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
