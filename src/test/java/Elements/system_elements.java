package Elements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constant.Constants;
import TestCases.Baseclass;


public class system_elements extends Baseclass {

	public system_elements(WebDriver driver)
	{
		this.driver = driver;
	}


	public void Email_mailinator_login(WebDriver driver) {
		this.driver = driver;
	}	
	By search_textbox = By.id("search");
	By Go_button=By.xpath("//button[@value='Search for public inbox for free']");
	By subject_body_forwading_email= By.xpath("//td[normalize-space()='FW: Activation Email']");
	By subject_body= By.xpath("//td[normalize-space()='Activation Email']");


	public void switch_to_iframe(WebDriver driver) {
		this.driver = driver;
	}
	By iframe_id=By.id("html_msg_body");
	By yes_its_me_lets_get_started_btn=By.xpath("//a[normalize-space()=\"Yes, it's me - let's get started!\"]");





	public void perform_searching(String email_value)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));		  
		try
		{wait.until(ExpectedConditions.visibilityOfElementLocated(search_textbox));
		}catch(Exception e) {}	 

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",driver.findElement(search_textbox));
		//driver.findElement(search_textbox).click();
		js.executeScript("arguments[0].setAttribute('value', '" + email_value + "')", driver.findElement(search_textbox));
		//driver.findElement(search_textbox).sendKeys(email_value);
		js.executeScript("arguments[0].click()",driver.findElement(Go_button));
		// driver.findElement(Go_button).click();
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");	
		if(homeURL == Constants.haibooks)
		{
			js.executeScript("arguments[0].click()",driver.findElement(subject_body));
		}
		else
		{
			js.executeScript("arguments[0].click()",driver.findElement(subject_body_forwading_email));
		}
	}


	public void switch_To_IFrame()
	{
		// switch mailinator iframe
		driver.switchTo().frame(driver.findElement(iframe_id));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 3000);");
		js.executeScript("arguments[0].click()",driver.findElement(yes_its_me_lets_get_started_btn));
	}

}
