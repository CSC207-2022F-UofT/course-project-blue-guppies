import complete_task_use_case.CompleteTaskController;
import create_event_use_case.*;
import create_task_use_case.CreateTaskController;
import data_access.DataAccess;
import delete_task_use_case.DeleteTaskController;
import entities.EventFactory;
import modify_task_use_case.*;
import screens.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        DataAccess gateway = new DataAccess();
//
//        // initialize create event classes
//        CreateEventOutputBoundary createEventPresenter = new CreateEventPresenter();
//        EventFactory eventFactory = new EventFactory();
//        CreateEventInputBoundary createEventInteractor = new CreateEventInteractor(
//                gateway, createEventPresenter, eventFactory);
//        CreateEventController createEventController = new CreateEventController(createEventInteractor);
//
//
//        // initialize create task classes
//        CreateTaskController createTaskController = new CreateTaskController();
//        // add more
//
//        // initialize modify task classes
//        ModifyTaskOutputBoundary modifyTaskPresenter = new ModifyTaskPresenter();
//        ModifyTaskDataAccess dsGateway = new ModifyTaskDataAccess();
//        ModifyTaskInputBoundary modifyTaskInteractor = new ModifyTaskInteractor(modifyTaskPresenter, dsGateway);
//        ModifyTaskController modifyTaskController = new ModifyTaskController(modifyTaskInteractor);
//
//
//        // initialize delete task classes
//        DeleteTaskController deleteTaskController = new DeleteTaskController();
//
//        // initialize complete task classes
//        CompleteTaskController completeTaskController = new CompleteTaskController();
//
//        // create calendar screen
//        JFrame calendarScreen = new JFrame("Clean Calendar");
//        calendarScreen.setLayout(new BorderLayout());
//        JPanel p = new JPanel();
//        p.add(new JLabel("To become the main calendar view"));
//        calendarScreen.add(p, BorderLayout.CENTER);
//        calendarScreen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        // initialize the screens
//        CreateEventScreen createEventScreen = new CreateEventScreen(createEventController);
//        CreateTaskScreen createTaskScreen = new CreateTaskScreen(createTaskController);
//        ModifyTaskScreen modifyTaskScreen = new ModifyTaskScreen(modifyTaskController);
//
//        // add a button to create a new event
//        JButton addEvent = new JButton("New Event");
//        addEvent.addActionListener(e -> createEventScreen.setVisible(true));
//        p.add(addEvent);
//
//        // add a button to create a new task
//        JButton addTask = new JButton("New Task");
//        addTask.addActionListener(e -> createTaskScreen.setVisible(true));
//        p.add(addTask);
//
//        // add a button ot modify a task.
//        // TODO: move modifyTask button to the week view
//        JButton modifyTask = new JButton("Modify Task");
//        modifyTaskScreen.setDay(0);
//        modifyTaskScreen.setOldTitle("clean house");
//        modifyTask.addActionListener(e -> modifyTaskScreen.setVisible(true));
//        p.add(modifyTask);
//
//
//        ClickTaskScreen taskMenu = new ClickTaskScreen(modifyTaskScreen, deleteTaskController, completeTaskController);
//        JButton openTaskMenu = new JButton("Task menu");
//        taskMenu.setTaskTitle("clean house");
//        taskMenu.setDayId(0);
//        openTaskMenu.addActionListener(e -> taskMenu.setVisible(true));
//        p.add(openTaskMenu);



//
//        createEventScreen.pack();
//        createEventScreen.setVisible(false);
//        createTaskScreen.pack();
//        createTaskScreen.setVisible(false);
//        modifyTaskScreen.pack();
//        modifyTaskScreen.setVisible(false);
//        taskMenu.pack();
//        taskMenu.setVisible(false);
//        calendarScreen.pack();
//        calendarScreen.setVisible(true);


        WeekViewScreen view = new WeekViewScreen(new Object[]{});
    }
}
