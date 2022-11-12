package MY_Practice_0001;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice_105 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to ("https://www.youtube.com");
        Thread.sleep(3000);

driver.findElement(By.xpath("//*[@name='search_query']")).sendKeys("hindi songs");

driver.findElement(By.xpath("//*[@id='search-icon-legacy']")).click();


    }//end of main
}//end of java

