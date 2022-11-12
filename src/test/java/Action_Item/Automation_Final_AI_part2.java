package Action_Item;

import Reusable_library.ReusableActions_Loggers;
import Reusable_library.ReusableAnnotation;
import org.testng.annotations.Test;

public class Automation_Final_AI_part2 extends ReusableAnnotation {

    @Test()
    public void tc001_AutoLoan() throws InterruptedException {

        //going to pnc web page
        driver.navigate().to("https://www.pnc.com");
        //click on the product and services
        ReusableActions_Loggers.clickAction(driver, "//*[text()='Products & Services']", logger, "click on product ans services");
        //wait few seconds
        Thread.sleep(2000);
        //click on AutoLoan
        ReusableActions_Loggers.clickActionByIndex(driver, "//*[text()='Auto Loans']", 0, logger, "click on AutoLoan");
        //selecting Refinancing an Auto Loan
        ReusableActions_Loggers.selectByTextAction(driver, "//*[@id='autoProduct']", "Refinancing an Auto Loan", logger, "select Refinancing an Auto Loan");
        //adding zipCode for for Search
        ReusableActions_Loggers.sendKeysAction(driver, "//*[@id='ratesZipCode']", "80014", logger, "Enter zipCode");
        //wait few seconds
        Thread.sleep(2000);
        //clicking on get rate button
        ReusableActions_Loggers.clickAction(driver, "//*[@id='getRates']", logger, "click on get rate button");
    }//end of test case 1

    @Test(dependsOnMethods = "tc001_AutoLoan")
    public void tc002_TotalAuto() throws InterruptedException {
        //view find a car
        ReusableActions_Loggers.scrollByView(driver, "//*[text()='Find a Car']", logger, "Scroll to find a car");
        //wait few seconds
        Thread.sleep(2000);
        //click on Explore total auto
        ReusableActions_Loggers.clickAction(driver, "//*[text()='Explore PNC Total Auto']", logger, "click on find a car");
        Thread.sleep(2000);
        //click on new cars
        ReusableActions_Loggers.clickAction(driver, "//*[@title='New Cars']", logger, "click on new car");
        //clicking on BMW
        ReusableActions_Loggers.clickActionByIndex(driver, "//*[@title='New BMW Models']", 1, logger, "click on BMW");
    }//end test 2

    @Test(dependsOnMethods = "tc002_TotalAuto")
    public void tc003_RefinanceAutoLoan() throws InterruptedException {
        //click on popUp and enter zipCode
        ReusableActions_Loggers.sendKeysAction(driver, "//*[contains(@class,'form-control ')]", "80014", logger, "enter zipCode");
        //click on update on popUp
        ReusableActions_Loggers.clickAction(driver, "//*[@class='btn btn-primary btn-md']", logger, "click on update");
        Thread.sleep(2000);
        //hover to home button and click on home button
        ReusableActions_Loggers.mouseHover(driver, "//*[@class='py-2-5 _vnqtn3']", logger, "hover to home button");
        //Clicking on apply now
        ReusableActions_Loggers.clickAction(driver, "//*[text()='Apply Now']", logger, "click Apply now");
        //clicking on Apply now for Refinance
        ReusableActions_Loggers.clickActionByIndex(driver, "//*[@class='col-xs-12 apply-now']", 1, logger, "click on apply now for Refinance");
    }//end of test 3


}//end class 2
