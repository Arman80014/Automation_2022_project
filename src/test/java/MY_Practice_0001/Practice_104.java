package MY_Practice_0001;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Practice_104 {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> Places = new ArrayList<>();
        Places.add("Louisiana");
        Places.add("Denver");
        Places.add("Alaska");
        Places.add("NewYork");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        for (int i = 0; i < Places.size(); i++) {

driver.navigate().to("https://www.google.com");
            //sleep statement

            Thread.sleep(3000);

            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Places.get(i));

            driver.findElement(By.xpath("//*[@name='btnK']")).submit();
            Thread.sleep(3000);

            //capture the search result text
            String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
            //split message to extract out the search number
            String[] splitResult = result.split(" ");
            System.out.println("the search number is for " + Places.get(i) + " is " + splitResult[1]);

        }//end of for loop

        //quit the driver to end the session
        driver.quit();








    }//end of main

 }///
