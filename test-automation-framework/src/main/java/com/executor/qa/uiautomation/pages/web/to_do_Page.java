package com.executor.qa.uiautomation.pages.web;

import com.executor.qa.uiautomation.configurations.DataExtractor;
import com.executor.qa.uiautomation.configurations.Driver;
import com.executor.qa.uiautomation.utils.CommandBase;
import com.executor.qa.uiautomation.utils.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import javax.xml.bind.JAXBException;
import java.util.Random;

public class to_do_Page extends CommandBase {
    private static String URL;

    @FindBy(how = How.XPATH, using = "//input[@class='new-todo']")
    static WebElement txt_todo;

    @FindBy(how = How.XPATH, using = "//div[@class='view']/input[@class='toggle']")
    static WebElement btn_toggle;

    @FindBy(how = How.XPATH, using = "//div[@class='view']/label")
    static WebElement lbl_todo;

    @FindBy(how = How.XPATH, using = "//button[text()='Clear completed']")
    static WebElement btn_ClearCompleted;

    @FindBy(how = How.XPATH, using = "//li/a[text()='Active']")
    static WebElement btn_ActiveItems;

    @FindBy(how = How.XPATH, using = "//li[@class='completed']")
    static WebElement lbl_Completed;

    @FindBy(how = How.XPATH, using = "//ul[@class='todo-list']/li")
    static WebElement lbl_NotCompleted;

    @FindBy(how = How.XPATH, using = "//a[text()='All']")
    static WebElement btn_All;

    @FindBy(how = How.XPATH, using = "//li/a[text()='Completed']")
    static WebElement tb_Completed;



    static String toDoslistNames;

    /**
     * This is act as constructor
     *
     * Load UI objects
     * init web driver
     *
     * @throws JAXBException
     */
    public to_do_Page() throws JAXBException {
        URL = DataExtractor.getConfigDataWeb().getProperty("mainPage");
        webDriver = Driver.getInstance().getWebDriver();
        PageFactory.initElements(webDriver, this);
        openPage(URL);
    }

    /**
    In this method - call -> constructor
     */
    public static void openPage() throws JAXBException {
        //Open URL
        to_do_Page todo = new to_do_Page();
    }

    /**
     * Create to_do note and verify created todo
     *
     * @param labelName
     * @throws JAXBException
     * @throws InterruptedException
     */
    public static void createToDoNoteOnly(String labelName) throws JAXBException, InterruptedException {
        WaitHelper waitHelper = new WaitHelper(Driver.getInstance().getWebDriver());
        waitHelper.sleep(5000);

        type(txt_todo, labelName);
        enter(txt_todo);
        isTextDisplay(lbl_todo, labelName);
    }

    /**
     * Create todo name and return created name
     *
     * @param labelName
     * @return
     * @throws JAXBException
     * @throws InterruptedException
     */
    public static String createToDoNote(String labelName) throws JAXBException, InterruptedException {
        WaitHelper waitHelper = new WaitHelper(Driver.getInstance().getWebDriver());
        waitHelper.sleep(5000);
        // create instance of Random class
        Random rand = new Random();
        int rand_number = rand.nextInt(1000);
        String createlabel = labelName + rand_number;
        type(txt_todo, createlabel);
        enter(txt_todo);
        isTextDisplay(lbl_todo, createlabel);
        return createlabel;
    }

    /**
     *
     * Click on radio button and verify clear completed link
     */
    public static void toggleTodos() {
        click(btn_toggle);
        isElementDisplay(btn_ClearCompleted);
    }

    /**
     * create multiple todo notes
     *
     * @param labelName
     * @throws JAXBException
     * @throws InterruptedException
     */
    public static void createMultipleToDoNote(String labelName) throws JAXBException, InterruptedException {
        WaitHelper waitHelper = new WaitHelper(Driver.getInstance().getWebDriver());
        waitHelper.sleep(3000);
        String createlabel;
        // create instance of Random class
        Random rand = new Random();
        for (int i = 1; i <= 5; i++) {
            int rand_number = rand.nextInt(1000);
            createlabel = labelName + rand_number;
            type(txt_todo, createlabel);
            enter(txt_todo);
        }
    }

    /**
     * Verify not completed todos
     *
     */
    public static void verifyNotCompletedItems() {
        click(btn_toggle);
        click(btn_ActiveItems);
        int listcount = Driver.getInstance().getWebDriver().findElements(By.xpath("//ul[@class='todo-list']/li")).size();

        for (int i = 1; i <= listcount; i++) {
            toDoslistNames = Driver.getInstance().getWebDriver().findElement(By.xpath("//ul[@class='todo-list']/li" + "[" + i + "]")).getText();
            isElementDisplay(toDoslistNames);
        }
    }

    /**
     *
     *Clear completed todos
     *
     */
    public static void clearCompletedItems() {
        click(btn_toggle);
        click(btn_ActiveItems);
        click(btn_ClearCompleted);
        click(btn_All);

        int listcount = Driver.getInstance().getWebDriver().findElements(By.xpath("//li[@class='completed']")).size();

        if (listcount == 0) {
            Assert.assertEquals(listcount, 0);
        } else if (listcount >= 1) {
            Assert.assertFalse(listcount >= 1, "Fail");
        }
    }


    /**
     * Verify completed items in complete tab
     *
     * @throws InterruptedException
     */
    public static void verifyCompletedItems() throws InterruptedException {
        WaitHelper waitHelper = new WaitHelper(Driver.getInstance().getWebDriver());
        waitHelper.sleep(3000);
        click(btn_toggle);
        waitHelper.sleep(2000);
        click(tb_Completed);

        int listcount = Driver.getInstance().getWebDriver().findElements(By.xpath("//li[@class='completed']")).size();
        if (listcount >= 1) {
            Assert.assertEquals(listcount, 1);
        } else if (listcount <= 0) {
            Assert.assertFalse(listcount >= 1, "Fail");
        }
    }
}
