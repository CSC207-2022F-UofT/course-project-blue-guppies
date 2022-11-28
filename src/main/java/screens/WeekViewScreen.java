// TODO Documentation
package screens;

import clear_all_use_case.ClearAllController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Map;

public class WeekViewScreen extends JFrame implements WindowListener, ActionListener {
    private static final int HEIGHT = 550;
    private static final int WIDTH = 1100;
    private Map<String, Object> controllers;
    private Map<String, JFrame> screens;
    private ArrayList<JScrollPane> panels = new ArrayList<JScrollPane>();


    public WeekViewScreen(Map<String, JFrame> screens, Map<String, Object> controllers) {
        super();
        setTitle("Clean Calendar");
        addWindowListener(this);

        this.controllers = controllers;
        this.screens = screens;

        JPanel panel = new JPanel(new BorderLayout());

        //Create the toolbar.
        JToolBar toolBar = new JToolBar("Still draggable");
        addButtons(toolBar);

        // TODO setup 14 scroll panes attached to jpanels
        // TODO event and task titles to left of scroll panes
        // TODO add sample task and events and hook them up to ClickTaskScreen and ClickEventScreen
        //Create the text area used for output.  Request
        //enough space for 5 rows and 30 columns.
//        textArea = new JTextArea(5, 30);
//        textArea.setEditable(false);
//        JScrollPane scrollPane = new JScrollPane(textArea);

        //Lay out the main panel.
        setPreferredSize(new Dimension(450, 130));
        add(toolBar, BorderLayout.PAGE_START);
        //add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }

    private void addButtons(JToolBar toolBar) {
        JButton newTask = new JButton("New Task");
        newTask.addActionListener(this);
        newTask.setActionCommand("create task");
        toolBar.add(newTask);

        JButton newEvent = new JButton("New Event");
        newEvent.addActionListener(this);
        newEvent.setActionCommand("create event");
        toolBar.add(newEvent);

        JButton clear = new JButton("Clear Week");
        clear.addActionListener(this);
        clear.setActionCommand("clear all");
        toolBar.add(clear);
    }

    public WeekViewScreen() {
        super();
        setTitle("Clean Calendar");
        addWindowListener(this);

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
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("create event")) {
            screens.get("create event").setVisible(true);
        } else if (e.getActionCommand().equals("create task")) {
            screens.get("create task").setVisible(true);
        } else if (e.getActionCommand().equals("clear all")) {
            int confirmed = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to clear this week?", "Clear Week Message Box",
                    JOptionPane.YES_NO_OPTION);

            if (confirmed == JOptionPane.YES_OPTION) {
                ((ClearAllController)controllers.get("clear all")).clearAll();
            }
        } else if (e.getActionCommand().contains("event")) {
            ((ClickEventScreen)screens.get("click event")).setDayIndex(e.getActionCommand().charAt(6) - 48);
            ((ClickEventScreen)screens.get("click event")).setStartTime(e.getActionCommand().substring(8,13));
            ((ClickEventScreen)screens.get("click event")).setEndTime(e.getActionCommand().substring(14,19));
            ((ClickEventScreen)screens.get("click event")).setEventTitle(e.getActionCommand().substring(20));
            screens.get("click event").setVisible(true);
        } else if (e.getActionCommand().contains("task")) {
            ((ClickTaskScreen)screens.get("click task")).setDayIndex(e.getActionCommand().charAt(5) - 48);
            ((ClickTaskScreen)screens.get("click task")).setTaskTitle(e.getActionCommand().substring(7));
            screens.get("click task").setVisible(true);
        }
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
        int confirmed = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to exit the program?", "Exit Program Message Box",
                JOptionPane.YES_NO_OPTION);

        if (confirmed == JOptionPane.YES_OPTION) {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
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
