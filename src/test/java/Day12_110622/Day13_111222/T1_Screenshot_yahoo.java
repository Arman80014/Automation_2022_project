package Day12_110622.Day13_111222;

import Reusable_library.ReusableActions_Loggers;
import Reusable_library.ReusableAnnotation;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class T1_Screenshot_yahoo extends ReusableAnnotation {
    @Test(priority = 1)
    public void tc001_verifySignedInOptionIsChecked() throws InterruptedException {
        //first navigate to yahoo homepage
        driver.navigate().to("https://www.yahoo.com/");
        //next we need to click on sign in button
        ReusableActions_Loggers.clickAction(driver, "//*[@class = '_yb_1933euu']", logger, "Sign In");
        //we need to verify that signed in option is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id= 'persistent']")).isSelected();
        System.out.println("The checkbox check condition is: " + isSignInChecked);
        logger.log(LogStatus.INFO, "The checkbox check condition is: " + isSignInChecked);



    }//end of test 1

}
