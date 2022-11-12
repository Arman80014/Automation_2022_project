package Action_Item;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.ArrayList;

public class Automation_AI2{
    public static void main(String[] args) throws InterruptedException {
      //declare and defining ArrayList
        ArrayList<String>Places= new ArrayList<>();
        Places.add("Prospect park ");
        Places.add("Seven waterfalls ");
        Places.add("Pike peak ");
        Places.add("Red rocks ");
        // defining the Web driver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();
        //creating an instance for a chrome driver  to automate
        WebDriver driver = new ChromeDriver();
//syntax for forLoop arrayList
        for( int i = 0; i < Places.size(); i++) {
// navigating to Bing.com
            driver.navigate().to("https://www.bing.com/");
// to maximize window
            driver.manage().window().maximize();
//sleep statement
            Thread.sleep(3000);
// searching keyword on the search field
            // relative xpath to locate the element
            driver.findElement(By.xpath("//*[@name= 'q']")).sendKeys(Places.get(i));
            //click on search logo to proceed to next page
            driver.findElement(By.xpath("//*[@viewBox= '0 0 25 25']")).submit();
            //sleep statement
            Thread.sleep(3000);

//capture the search result text
            String result = driver. findElement(By.xpath("//*[@class='sb_count']")).getText();
            //split the message to extract out the search number for all value
            String[]splitResult = result.split(" ");
            System.out.println("My favorite places are " + Places.get(i) + splitResult[0]);
        }// end of forLoop
        // quit the driver to end the session
        driver.quit();


        }//end of main

}//end of java class
