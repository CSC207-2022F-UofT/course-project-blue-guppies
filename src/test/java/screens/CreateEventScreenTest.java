package screens;

import create_event_use_case.*;
import data_access.DataAccess;
import entities.EventFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreateEventScreenTest {
    DataAccess gateway = new DataAccess();
    // initialize create event classes
    CreateEventOutputBoundary createEventPresenter = new CreateEventPresenter();
    EventFactory eventFactory = new EventFactory();
    CreateEventInputBoundary createEventInteractor = new CreateEventInteractor(
            gateway, createEventPresenter, eventFactory);
    CreateEventController createEventController = new CreateEventController(createEventInteractor);
    CreateEventScreen createEventScreen;


    @Test
    void testResetForm() {
        createEventScreen = new CreateEventScreen(createEventController);
        createEventScreen.pack();
        createEventScreen.setVisible(false);
        createEventScreen.title.setText("lecture");
        createEventScreen.startTime.setText("2:30");
        createEventScreen.endTime.setText("3:20");
        // set the day selected to Wednesday
        for (int i = 0; i < createEventScreen.daysOfTheWeekRadioButtons.length; i++) {
            createEventScreen.daysOfTheWeekRadioButtons[i].setSelected(false);
        }
        createEventScreen.daysOfTheWeekRadioButtons[3].setSelected(true);
        System.out.println(createEventScreen.daysOfTheWeekRadioButtons[0].isSelected());

        createEventScreen.resetForm();
        ArrayList<Boolean> isDaySelected = new ArrayList<>();
        for (int i = 0; i < createEventScreen.daysOfTheWeekRadioButtons.length; i++) {
            isDaySelected.add(createEventScreen.daysOfTheWeekRadioButtons[i].isSelected());
        }
        assertEquals("", createEventScreen.endTime.getText());
        assertEquals("", createEventScreen.startTime.getText());
        assertEquals("", createEventScreen.title.getText());
        assertEquals(true, isDaySelected.get(0));
        for (int i = 1; i < isDaySelected.size(); i++) {
            assertEquals(false, isDaySelected.get(i));
        }

    }

    @Test
    void testGetSelectedDay() {
        createEventScreen = new CreateEventScreen(createEventController);
        createEventScreen.pack();
        createEventScreen.setVisible(false);
        createEventScreen.title.setText("lecture");
        createEventScreen.startTime.setText("2:30");
        createEventScreen.endTime.setText("3:20");
        // set the day selected to Wednesday
        for (int i = 0; i < createEventScreen.daysOfTheWeekRadioButtons.length; i++) {
            createEventScreen.daysOfTheWeekRadioButtons[i].setSelected(false);
        }
        createEventScreen.daysOfTheWeekRadioButtons[3].setSelected(true);
        assertEquals("Wednesday", createEventScreen.getSelectedDay());
    }

//    @Test
//    void testActionPerformed() {
//        createEventScreen = new CreateEventScreen(createEventController);
//        createEventScreen.pack();
//        createEventScreen.setVisible(true);
//        createEventScreen.title.setText("lecture");
//        createEventScreen.startTime.setText("2:30");
//        createEventScreen.endTime.setText("3:20");
//        // set the day selected to Wednesday
//        for (int i = 0; i < createEventScreen.daysOfTheWeekRadioButtons.length; i++) {
//            createEventScreen.daysOfTheWeekRadioButtons[i].setSelected(false);
//        }
//        createEventScreen.daysOfTheWeekRadioButtons[3].setSelected(true);
//        createEventScreen.actionPerformed(new ActionEvent());
//        assertEquals(createEventScreen.isVisible(), createEventScreen.getSelectedDay());
//    }




    // test x button for clearing form
    // test cancel button for clearing form
    // test create button gets the correct values
    // test create button closes the form
}