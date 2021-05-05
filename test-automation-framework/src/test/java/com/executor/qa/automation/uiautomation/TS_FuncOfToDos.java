package com.executor.qa.automation.uiautomation;

import com.executor.qa.automation.uiautomation.base.ConfigTestWeb;
import com.executor.qa.uiautomation.configurations.Browser;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBException;
import java.util.Map;

import static com.executor.qa.uiautomation.pages.web.to_do_Page.*;


public class TS_FuncOfToDos extends ConfigTestWeb {

    /**
     * This test case will be covered - new to_do items add functionality
     *
     * Expected result: User should be able to create ToDos
     *
     */
    @Test(testName = "Create To-Do", dataProvider = "getDefaultUser")
    public static void createToDos(Browser browser, Map<String, String> testData) throws JAXBException, InterruptedException {
        //Open URL and navigate browser
        openPage();
        //Create new To_Do items
        createToDoNoteOnly(testData.get("ToDoLabelName"));
    }

    /**
     * This test case will be covered - Complete/Done added to_dos
     *
     * Expected result: User should be able to click on radio button and mark as Done todos
     *
     */
    @Test(testName = "Mark_As_Done", dataProvider = "getDefaultUser")
    public static void MarkAsDone(Browser browser, Map<String, String> testData) throws JAXBException, InterruptedException {
        //Open URL and navigate browser
        openPage();
        //Create new To_Do items
        createToDoNoteOnly(testData.get("ToDoLabelName"));
        toggleTodos();
    }


    /**
     * This test case will be covered - Filter Active ToDos through Active ToDos
     *
     * Expected result: User should be able to mark as done tasks and then filter Active tasks only
     */
    @Test(testName = "Verify_Active_state_To_dos", dataProvider = "getDefaultUser")
    public static void verifyFilterActiveTodos(Browser browser, Map<String, String> testData) throws JAXBException, InterruptedException {
        openPage();
        createMultipleToDoNote(testData.get("ToDoLabelName"));
        verifyNotCompletedItems();
    }

    /**
     Verify test case will be covered - clear completed todos

     Expected result: User should be able to clear completed tasks
     */

    @Test(testName = "Clear_completed_todos", dataProvider = "getDefaultUser")
    public static void verifyClearCompletedTodos(Browser browser, Map<String, String> testData) throws JAXBException, InterruptedException {
        openPage();
        createMultipleToDoNote(testData.get("ToDoLabelName"));
        clearCompletedItems();
    }

    /**
     *
     * Verify test case will be covered - Completed items
     *
     * Expected result:User should be able to check completed items
     */

    @Test(testName = "Verify_completed_todos_A", dataProvider = "getDefaultUser")
    public static void verifyCompletedTodos(Browser browser, Map<String, String> testData) throws JAXBException, InterruptedException {
        openPage();
        createMultipleToDoNote(testData.get("ToDoLabelName"));
        verifyCompletedItems();
    }
}
