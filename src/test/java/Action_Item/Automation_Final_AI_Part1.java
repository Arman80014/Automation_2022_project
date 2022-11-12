package Action_Item;

import Reusable_library.ReusableActions_Loggers;

import Reusable_library.ReusableAnnotation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Automation_Final_AI_Part1 extends ReusableAnnotation {

    @Test(priority = 1)
    public void tc001_viewProducts_Services() throws InterruptedException {
        //going to pnc webpage
        driver.navigate().to("https://www.pnc.com");
        //clicking on product&services
        ReusableActions_Loggers.clickActionByIndex(driver, "//*[@class='cmp-listpro__item-text']", 1, logger, "click on product and services");
        Thread.sleep(3000);
        //click on credit cards
        ReusableActions_Loggers.clickAction(driver, "//*[text()='Credit Cards']", logger, "click on credit cards");
        Thread.sleep(3000);
        //scroll to view the offer
        ReusableActions_Loggers.scrollByView(driver, "//*[@id='text-3ecba3b209']", logger, "scroll to view");
        Thread.sleep(3000);
    }//end of test 1

    @Test(dependsOnMethods = "tc001_viewProducts_Services")
    public void tc002_compareCreditCards() throws InterruptedException {
        //clicking on close for popUp
        try {
            WebElement popUp = driver.findElement(By.xpath("//*[@id='uz_popup_modal']"));
            if (popUp.isDisplayed()) {
                //click on close
                driver.findElement(By.xpath("//*[@id='uz_span_close']")).click();
            }
        } catch (Exception e) {
            System.out.println("Unable to find pop up " + e);
            //ReusableActions_Loggers.clickAction(driver,"//*[@id='uz_span_close']",logger,"click on close");
        }//end of popUp
        ReusableActions_Loggers.scrollByView(driver, "//*[text()='Personal Credit Cards']", logger, "view of compare cards");
        Thread.sleep(2000);
        //click on compare credit cards button
        ReusableActions_Loggers.clickActionByIndex(driver, "//*[@class='cmp-button']", 3, logger, "click on compare cards ");
    }//end of test 2

    @Test(dependsOnMethods = "tc002_compareCreditCards")
    public void tc003_exploreCardDetails() {
//clicking on explore card
        ReusableActions_Loggers.clickActionByIndex(driver, "//*[text()='Explore Card Details »']", 0, logger, "click on exploreCard ");
        //scrolling to double your cash back view
        ReusableActions_Loggers.scrollByView(driver,"//*[@id='title-73faf26906']",logger,"view double your cash back ");
       //Click on applyNow
        ReusableActions_Loggers.clickAction(driver,"//*[@id='button-a87e119f51']",logger,"click on apply now ");

    }//end of test 3

}//end of class 1
