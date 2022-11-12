package MY_Practice_0001;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class practice_1006 {
    public static void main(String[] args) throws InterruptedException {
        //declaring wedriver
        WebDriverManager.chromedriver().setup();
        //adding chrome options to driver
        ChromeOptions options = new ChromeOptions();
       //declaring full view
        options.addArguments("start-maximized");
       //initiating driver
        WebDriver driver = new ChromeDriver(options);
        //going to the web page
        driver.navigate().to("https://www.bodybuilding.com/");
        //locating to my element
        Thread.sleep(5000);
        WebElement reserveNowPopUp = driver.findElement(By.xpath("//*[@class='css-1g4yje1 emervj0']"));
        if (reserveNowPopUp.isDisplayed()) {
            //if the pop up is displayed then click on pay now
            driver.findElement(By.xpath("//*[@class='css-upw05v errp0sa0']")).click();
Thread.sleep(3000);
            driver.findElements(By.xpath("//*[@class='w21_main-nav__item']")).get(0).click();


        }//
    }//end of main
}//end of java class
