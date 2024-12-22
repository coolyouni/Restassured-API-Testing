package Actions;
import TestCases.Baseclass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import Elements.system_elements;

public class Email_verification extends Baseclass {
	
	  public  void perform_added_token(String email_value)
      {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));	
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("element-id")));
		  
      }


}
