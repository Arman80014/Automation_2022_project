package Action_Item;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Automation_AI3 {
    public static void main(String[] args) throws InterruptedException {

//declaring the webDriver chrome
        WebDriverManager.chromedriver().setup();
        //maximizing window screen
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized", "incognito");
        WebDriver driver = new ChromeDriver(options);
        //List of Array values
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("90001");
        zipCode.add("10001");
        zipCode.add("80014");

        //declaring forLoop for the variable
        for (int i = 0; i < zipCode.size(); i++) {

            //go to weight-watchers webpage
        driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");

        //declaring forLoop for the variable
        //for (int i = 0; i < zipCode.size(); i++) {

            //wait few seconds
            Thread.sleep(3000);
            //locating find a workshop element and clicking select
            driver.findElement(By.xpath("//*[text()='Find a Workshop']")).click();
            //inspecting in person link
            driver.findElement(By.xpath("//*[text()='In-Person']")).click();
            // declaring webElement
            WebElement zipSearch = driver.findElement(By.xpath("//*[@id='location-search']"));
            // clearing the searchBox
            zipSearch.clear();
            //declaring the Array values
            zipSearch.sendKeys(zipCode.get(i));

            // clicking the search button
            driver.findElement(By.xpath("//*[contains(@class,'rightArrow')]")).click();
            // sleep statement
            Thread.sleep(2000);

            // calling the list of webElement within array
            ArrayList<WebElement> placeList = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class, 'linkUnderline')]")));
            if (i == 0) {
                placeList.get(1).click();
            }
            if (i == 1) {
                placeList.get(2).click();
            }
            if (i == 2) {
                placeList.get(0).click();
            }// end of conditional statement

            //adding wait time
            Thread.sleep(2000);
            //capturing the addresses
            String result = driver.findElement(By.xpath("//*[contains(@class,'infoContainer-12kv1')]")).getText();
            // using split commend to avoid extra contend on the addresses
            String[] resultSplits = result.split("\\R");
            //printing addresses in different lines
            System.out.println(resultSplits[0] + "\n" + resultSplits[1] + "\n" + resultSplits[2]);
            // define jse
            JavascriptExecutor view = (JavascriptExecutor) driver;
            Thread.sleep(2000);
            //using jse on the webpage to view studio workshop schedule
            WebElement scrollView = driver.findElement(By.xpath("//*[@id='studioWorkshopSchedule']"));
            // using jse on the webpage to view studio workshop schedule
            view.executeScript("arguments[0].scrollIntoView(true);", scrollView);
            //wait few seconds
            Thread.sleep(2000);
            //capture table
            String captureTable = driver.findElement(By.xpath("//*[@id='studioWorkshopSchedule']")).getText();
            System.out.println(captureTable);
            System.out.println();

        }//end of for loop
    }//end of main
}//end of java class
