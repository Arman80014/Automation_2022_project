package Action_Item;

import Reusable_library.ReusableActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Automation_AI5 {

    WebDriver driver;

    @BeforeSuite
    public void SetChromeDriver() {
        driver = ReusableActions.setUpDriver();
    }//end of set driver method

    /*@AfterSuite
    public void quitTheSession() {
        driver.quit();*/

    @Test()
    public void HealthPlan() throws InterruptedException {
        // go to Uhc.com
        driver.navigate().to("https://www.uhc.com");
        //clicking on find a doctor icon
        ReusableActions.clickAction(driver, "//*[@aria-label='Find a doctor']", "clicking on doctor");
        //handle pop up window with clicking no
        try {
            WebElement weValueYourFeedback = driver.findElement(By.xpath("//*[@id='layer-container-127097']"));
            if (weValueYourFeedback.isDisplayed()) {
                driver.findElement(By.xpath("//*[@id='ip-no']")).click();
            }//end of if condition
        } catch (Exception e) {
            System.out.println("Unable to find pop up window " + e);
        }//end of pop up window exception

        //scrolling to locate find a dentist
        ReusableActions.scrollByView(driver, "//*[text()='Find a dentist']", "locating find a dentist");
        //clicking on dentist
        ReusableActions.clickAction(driver, "//*[text()='Find a dentist']", "clicking on dentist");
        Thread.sleep(3000);
        //switching to second tab
        ReusableActions.switchToTabByIndex(driver, 1, "new tab");

        ReusableActions.clickAction(driver, "//*[@href='/plan-location?jumpTarget=uhcDental&coverageType=dental']", "click on Employer and individual plan");

        //clicking on plan
        //ReusableActions.clickAction(driver, "//*[@class='imgBox']", "click on Employer and individual plan");
    }//end of test 1

    @Test(dependsOnMethods = "HealthPlan")
    public void ZipCode() throws InterruptedException {

        Thread.sleep(2000);

        //sending ZiCode into SearchBox
        // ReusableActions.clickAction(driver, "//*[@id='location']", "click on SearchBox");

        ReusableActions.sendKeysAction(driver, "//*[@id='location']", "80122", "entering zipcode");
        Thread.sleep(3000);
        //selecting search value
        ReusableActions.clickActionByIndex(driver, "//*[@id='auto_0']", 0, "location");
        //clicking on continue
        ReusableActions.clickAction(driver, "//*[@type='submit']", "continue");
        //clicking on national options
        ReusableActions.clickActionByIndex(driver, "//*[@class='sc-bXXDC injjUJ']", 0, "national options PPO30");
        //wait few seconds
        Thread.sleep(3000);
        //refreshing urls
        driver.navigate().refresh();
        Thread.sleep(3000);
        //clicking general dentist
        ReusableActions.clickActionByIndex(driver, "//*[@class='sc-jgPyTC gXqeMb']", 0, "general dentist");
    }//end of test 2

    @Test(dependsOnMethods = "ZipCode")
    public void DoctorList() throws InterruptedException {
        //clicking on dropdown selecting miles
        //ReusableActions.selectByTextAction(driver,"//*[contains(@class,'radiusMiles ng-valid')]","Within 5 Miles","select miles");
        ReusableActions.selectByTextAction(driver, "//*[contains(@class,'radiusMiles ng-pristine']", "Within 20 Miles", "Select a mile from the dropdown");
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        //clicking on the nearest doctor list
        ReusableActions.clickActionByIndex(driver, "//*[@data-test-id='provider-name-link']", 0,"clicking on doctor");
        Thread.sleep(2000);
        //clicking on save
        ReusableActions.clickAction(driver, "//*[contains(@class,'cta-header-button action-btn saved')]", "click on save");
        // capturing address
        String AddressValue = ReusableActions.getTextAction(driver, "//*[@id='label__selectedLocation0']", "capturing address");
        //capturing the miles
        String milesValue = ReusableActions.getTextAction(driver, "//*[@class='td c-4-dt-tbl']", "capturing miles");
        //capturing networkValue
        String NetworkValue = ReusableActions.getTextAction(driver, "//*[@class='networkStatus td c-4-dt-tbl']", "capturing network");
        //printing values for each string
        System.out.println("Address:" + AddressValue + "Miles:" + milesValue + "Network:" + NetworkValue);
        //closing tab
        driver.close();
    }//end of test 3

    @Test(dependsOnMethods = "DoctorList")
    public void Switch(){

        //switching to default tab
        ReusableActions.switchToTabByIndex(driver,0,"default tab");
        //entering value into the SearchBox
        ReusableActions.sendKeysAction(driver,"//*[@id='search-desktop']","Doctor","SearchBox");
        //clicking on Search
        ReusableActions.clickAction(driver,"//*[@id='search__button-desktop']","clicking on search");
        //capturing result
        String SearchResult=ReusableActions.getTextAction(driver,"//*[@id='search-results-count__header']","SearchResult");
        //splitting result
        String[] result = SearchResult.split(" ");
        System.out.println("search result value: " + result[0] + result[1] + result[2]);

    }//end test case 4
    @AfterSuite
    public void quitTheSession(){
        driver.quit();
    }//end of after suite

}//end of class


