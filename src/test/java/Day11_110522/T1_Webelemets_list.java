package Day11_110522;

import Reusable_library.ReusableActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class T1_Webelemets_list {

    WebDriver driver;
    ArrayList<WebElement> totalMenuHeaders, mainMenuHeaders;
    @BeforeSuite
    public void SetChromeDriver() {
        driver = ReusableActions.setUpDriver();
        //navigate to usps.com home page
        driver.navigate().to("https://www.usps.com/");
        //store all the elements of the menu header into an arraylist of webelements
        totalMenuHeaders = new ArrayList<>(driver.findElements(By.xpath("//*[@class = 'nav-list']/li")));
    }//end of set driver method
    @AfterSuite
    public void quitTheSession() {
        driver.quit();
    }//end of after suite

    //test case 1 should be verify the total count of the displayed menue headers
    @Test(priority = 1)
    public void tc001_verifyTotalCountOfMenuHeaders(){

        System.out.println("the total number of menu headers is:" + totalMenuHeaders.size());
    }//end of test

    //click on the first dropdown
    @Test(priority = 2)
    public void tc002_clickOnTheFirstDropDown(){
        totalMenuHeaders.get(0).click();
    }//end of test 2

    //verify the sub menu headers
    @Test (priority = 3)
    public void tc003_verifyCountOfMainMenuHeader(){
    mainMenuHeaders = new ArrayList<>(driver.findElements(By.xpath("//*[@class = 'menuheader']")));
        System.out.println("the total number of main menu headers is:" + mainMenuHeaders.size());
    }//end of test 3
}//end of class



