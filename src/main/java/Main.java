import clear_all_use_case.*;
import complete_task_use_case.*;
import create_event_use_case.*;
import create_task_use_case.*;
import data_access.WeekDataAccess;
import delete_event_use_case.*;
import delete_task_use_case.*;
import modify_event_use_case.*;
import modify_task_use_case.*;
import screens.*;
import strategies.DayToIndexConverter;
import strategies.SaturdayAssumingConverter;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        WeekDataAccess.readObject();
        ViewModel viewModel = new ViewModel(WeekDataAccess.getDays());

        // Initialize create event classes
        CreateEventOutputBoundary createEventPresenter = new CreateEventPresenter(viewModel);
        CreateEventDsGateway createEventDsGateway = new CreateEventDataAccess();
        CreateEventInputBoundary createEventInteractor = new CreateEventInteractor(
                createEventDsGateway, createEventPresenter);
        DayToIndexConverter converter = new SaturdayAssumingConverter();
        CreateEventController createEventController = new CreateEventController(createEventInteractor, converter);

        // Initialize modify event classes
        ModifyEventOutputBoundary modifyEventOutputBoundary = new ModifyEventPresenter(viewModel);
        ModifyEventDsGateway modifyEventDsGateway = new ModifyEventDataAccess();
        ModifyEventInputBoundary modifyEventInputBoundary = new ModifyEventInteractor(modifyEventOutputBoundary,
                modifyEventDsGateway);
        ModifyEventController modifyEventController = new ModifyEventController(modifyEventInputBoundary);

        // Initialize delete event classes
        DeleteEventOutputBoundary deleteEventOutputBoundary = new DeleteEventPresenter(viewModel);
        DeleteEventDsGateway deleteEventDsGateway = new DeleteEventDataAccess();
        DeleteEventInputBoundary deleteEventInputBoundary = new DeleteEventInteractor(deleteEventOutputBoundary,
                deleteEventDsGateway);
        DeleteEventController deleteEventController = new DeleteEventController(deleteEventInputBoundary);

        // Initialize create task classes
        CreateTaskOutputBoundary createTaskOutputBoundary = new CreateTaskPresenter(viewModel);
        CreateTaskDsGateway createTaskDsGateway = new CreateTaskDataAccess();
        CreateTaskInputBoundary createTaskInputBoundary = new CreateTaskInteractor(
                createTaskOutputBoundary, createTaskDsGateway);
        CreateTaskController createTaskController = new CreateTaskController(createTaskInputBoundary, converter);

        // Initialize modify task classes
        ModifyTaskOutputBoundary modifyTaskPresenter = new ModifyTaskPresenter(viewModel);
        ModifyTaskDsGateway dsGateway = new ModifyTaskDataAccess();
        ModifyTaskInputBoundary modifyTaskInteractor = new ModifyTaskInteractor(modifyTaskPresenter, dsGateway);
        ModifyTaskController modifyTaskController = new ModifyTaskController(modifyTaskInteractor);

        // Initialize delete task classes
        DeleteTaskOutputBoundary deleteTaskOutputBoundary = new DeleteTaskPresenter(viewModel);
        DeleteTaskDsGateway deleteTaskDsGateway = new DeleteTaskDataAccess();
        DeleteTaskInputBoundary deleteTaskInteractor = new DeleteTaskInteractor(deleteTaskOutputBoundary,
                deleteTaskDsGateway);
        DeleteTaskController deleteTaskController = new DeleteTaskController(deleteTaskInteractor);

        // Initialize complete task classes
        CompleteTaskOutputBoundary completeTaskOutputBoundary = new CompleteTaskPresenter(viewModel);
        CompleteTaskDsGateway completeTaskDsGateway = new CompleteTaskDataAccess();
        CompleteTaskInputBoundary completeTaskInputBoundary = new CompleteTaskInteractor(completeTaskOutputBoundary,
                completeTaskDsGateway);
        CompleteTaskController completeTaskController = new CompleteTaskController(completeTaskInputBoundary);

        // Initialize clear all tasks and events classes
        ClearAllOutputBoundary clearAllOutputBoundary = new ClearAllPresenter(viewModel);
        ClearAllDsGateway clearAllDsGateway = new ClearAllDataAccess();
        ClearAllInputBoundary clearAllInputBoundary = new ClearAllInteractor(clearAllOutputBoundary,
                clearAllDsGateway);
        ClearAllController clearAllController = new ClearAllController(clearAllInputBoundary);

        // Initialize the screens
        CreateEventScreen createEventScreen = new CreateEventScreen(createEventController);
        CreateTaskScreen createTaskScreen = new CreateTaskScreen(createTaskController);
        ModifyTaskScreen modifyTaskScreen = new ModifyTaskScreen(modifyTaskController);
        ModifyEventScreen modifyEventScreen = new ModifyEventScreen(modifyEventController);
        ClickTaskScreen taskMenu = new ClickTaskScreen(modifyTaskScreen, deleteTaskController, completeTaskController);
        ClickEventScreen eventMenu = new ClickEventScreen(modifyEventScreen, deleteEventController);

        // Prepare screens
        createEventScreen.pack();
        createEventScreen.setVisible(false);
        createTaskScreen.pack();
        createTaskScreen.setVisible(false);
        modifyTaskScreen.pack();
        modifyTaskScreen.setVisible(false);
        modifyEventScreen.pack();
        modifyEventScreen.setVisible(false);
        taskMenu.pack();
        taskMenu.setVisible(false);
        eventMenu.pack();
        eventMenu.setVisible(false);

        Map<String, JFrame> screens = new HashMap<>();
        Map<String, Object>  controllers = new HashMap<>();

        controllers.put("clear all", clearAllController);

        screens.put("create event", createEventScreen);
        screens.put("create task", createTaskScreen);
        screens.put("modify event", modifyEventScreen);
        screens.put("modify task", modifyTaskScreen);
        screens.put("click task", taskMenu);
        screens.put("click event", eventMenu);

        WeekViewScreen view = new WeekViewScreen(screens, controllers, viewModel);
        viewModel.addObserver(view);
        viewModel.initializeWeekViewScreen();
        view.pack();
        view.setVisible(true);

    }
}
