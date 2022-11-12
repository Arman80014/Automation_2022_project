package Action_Item;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class Automation_AI4 {
    public static void main(String[] args) throws InterruptedException {

        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing the chrome window
        options.addArguments("start-maximized", "incognito");
        //options.addArguments("headless");
        //options.addArguments("start-fullscreen");
        //define the webdriver and pass the options into the method
        WebDriver driver = new ChromeDriver(options);
//declaring states in the arraylist for destination
        ArrayList<String> Destination = new ArrayList<>();
        Destination.add("NewYork");
        Destination.add("Louisiana");
        Destination.add("Colorado");
//declaring adultlist for number adults traveling in the arraylist
        ArrayList<Integer> Adults = new ArrayList<>();
        Adults.add(2);
        Adults.add(3);
        Adults.add(4);
//declaring child age for traveling
        ArrayList<String> childAge = new ArrayList<>();
        childAge.add("3");
        childAge.add("7");
        childAge.add("11");
        //wait few seconds
        Thread.sleep(3000);
        for (int i = 0; i < Destination.size(); i++) {
            //go to webpage
            driver.navigate().to("https://www.hotels.com");
            //wait few seconds
            Thread.sleep(3000);
            //declaring try and catch for error
            try {
                //go to searchBox and click
                driver.findElement(By.xpath("//*[@id='destination_form_field-menu']")).click();
            } catch (Exception e) {
                System.out.println("unable to find search" + e);
            }//end of exception search for error
            Thread.sleep(2000);
            //declaring try and catch for error
            try {
                //sending values to the searchBox
                driver.findElement(By.xpath("//*[@id='destination_form_field']")).sendKeys(Destination.get(i));
            } catch (Exception e) {
                System.out.println("unable to send value to the search box" + e);
            }//end of exception for searchBox

            //wait few seconds
            Thread.sleep(3000);
            try {
                //clicking on travelers searchBox
                driver.findElement(By.xpath("//*[@id='destination_form_field']")).sendKeys(Keys.ENTER);
            } catch (Exception e) {
                System.out.println("unable to click on searchBox" + e);
            }//end of exception for travelers searchBox

            try {
                //clicking on the travelers box
                driver.findElement(By.xpath("//*[contains(@class,'uitk-menu-trigger uitk-fake-input')]")).click();
            } catch (Exception e) {
                System.out.println(" unable to click on travel box " + e);
            }// end of exception

            try {
                //decreasing value on travelers
                driver.findElements(By.xpath("//*[@class='uitk-layout-flex-item uitk-step-input-touch-target']")).get(0).click();
            } catch (Exception e) {
                System.out.println("unable to click for decreasing value for travelers" + e);
            }// end of exception method
            //wait few seconds
            Thread.sleep(2000);
            for (int j = 1; j < Adults.get(i); j++) {
                //wait few seconds
                Thread.sleep(2000);
                try {
                    //clicking on plus sign to add more adults
                    driver.findElements(By.xpath("//*[contains(@class,'uitk-layout-flex-item uitk-step-input-touch')]")).get(1).click();
                } catch (Exception e) {
                }//end of exception for plus sign click
            }//end of nested loop
            //wait few seconds
            Thread.sleep(2000);
            try {
                //clicking on children list to add
                driver.findElements(By.xpath("//*[contains(@class,'uitk-layout-flex-item uitk-step-input-touch-target')]")).get(3).click();
            } catch (Exception e) {
                System.out.println("unable to click on child" + e);
            }//end of exception for clicking on child list
            //wait few seconds
            Thread.sleep(2000);
            try {
                //hover to childAge
                WebElement clickOnChild = driver.findElement(By.xpath("//*[@id='age-traveler_selector_children_age_selector-0-0']"));
                clickOnChild.click();
                Select clickOnChildDropDown = new Select(clickOnChild);
                clickOnChildDropDown.selectByVisibleText(childAge.get(i));
            } catch (Exception e) {
                System.out.println("unable to select child age" + e);
            }//end of Exception
            //wait few sec
            Thread.sleep(2000);
            try {
                //clicking on done for child age
                driver.findElement(By.xpath("//*[@id='traveler_selector_done_button']")).click();
            } catch (Exception e) {
                System.out.println("unable to click on done" + e);
            }//end of exception

            try {
                //clicking on search button
                driver.findElement(By.xpath("//*[@id='submit_button']")).click();
            } catch (Exception e) {
                System.out.println("unable to click on search" + e);
            }//end of exception
            Thread.sleep(2000);

            try {
                // capturing the resort element into webElement
                ArrayList<WebElement> hotels = new ArrayList<>(driver.findElements(By.xpath("//*[@class='uitk-card-link']")));
                hotels.get(1);
                //wait few seconds
                Thread.sleep(4000);

                // declaring true or false statement to print out the variable result
                if (i == 0) {
                    hotels.get(1).click();
                }

                if (i == 1) {
                    hotels.get(2).click();
                }

                if (i == 2) {
                    hotels.get(3).click();

                }//end of condition statement
            } catch (Exception e) {
                System.out.println(" unable to run if condition " + e);
            }//end of exception

            //adding wait time
            Thread.sleep(2000);

            //store the tabs in the array list
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //wait few second
            Thread.sleep(2000);
            //switch to the new tab
            driver.switchTo().window(tabs.get(1));

            try {
                //capture the resort name
                String resortName = driver.findElement(By.xpath("//*[contains(@class,'uitk-spacing uitk-spacing-padding-small-blockend-four')]")).getText();
                //print resortName
                System.out.println(resortName);
            } catch (Exception e) {
                System.out.println(" unable to capture name of resort " + e);
            }//end of exception

            try {
                //click on reserve now to go to down
                driver.findElement(By.xpath("//*[contains(@class,'uitk-button uitk-button-medium uitk-button-has-text uitk-button-p')]")).click();
            } catch (Exception e) {
                System.out.println("unable to click on reserve" + e);
            }//end of exception

            //wait few second
            Thread.sleep(2000);

            try {
                //capturing Hotel Price per night from resort
                String hotelPrice = driver.findElements(By.xpath("//*[contains(@class,'uitk-text uitk-type-6')]")).get(0).getText();
                //print hotel price per night
                System.out.println(hotelPrice);
            } catch (Exception e) {
                System.out.println(" unable to capture hotelPrice " + e);
            }//end of exception

            try {
                //clicking on reserve from hotel price slot
                driver.findElements(By.xpath("//*[text()='Reserve']")).get(0).click();
            } catch (Exception e) {
                System.out.println("unable to click on reserve from hotel price " + e);
            }//end of exception

            Thread.sleep(3000);
            try {
                //capturing check in & check out time
                String checkOut = driver.findElement(By.xpath("//*[contains(@class,'booking-details-travel-details-wrapper fs-base clear bg')]")).getText();
                //print hotel check in & check out time
                System.out.println(checkOut);
            } catch (Exception e) {
                System.out.println("unable to get check in & out time " + e);
            }//end of exception
            //close the current tab
            driver.close();
            //switching back to the first initial tab
            driver.switchTo().window(tabs.get(0));
            //creating space between the forLoop value
            System.out.println("");
        }//end of forLoo
        //quit the webdriver
        driver.quit();
    }//end of main
}//end of java class
