package TestCases;
import Constant.Constants;
import Elements.system_elements;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;
import static org.hamcrest.Matchers.equalTo;

import java.sql.DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.errorprone.annotations.Var;

import MyHelper.MyHelperClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;

public class Baseclass {
	
	  public WebDriver driver;
      public String homeURL = Constants.haibooks;
      public system_elements _systemElements1;
      
      public String mailinator="https://mailinator.com";
    
      
      
      public void TestInitForWeb()
      {
          if (driver == null)
          {
              Browser(Constants.chrome);

              try
              {
            	  driver.navigate().to(mailinator);

              }
              catch (Exception e)
              {
            	  driver.navigate().to(mailinator);
            	  //driver.navigate() GoToUrl(homeURL);
              }
              //WebDriverWait waitformee = new WebDriverWait(driver, TimeSpan.FromSeconds(40));
              driver.manage().window().maximize();
          }
      }
      
      
      public void close()
      {
          driver.quit();
          driver = null;
      }

      
      public void Browser(String browser)
      {
          if (browser == Constants.Firefox)
          {                        
              driver = new FirefoxDriver();
              _systemElements1 = new system_elements(driver);
          }
          else if (browser == Constants.chrome)
          {
        	  
        	  WebDriverManager.chromedriver().setup();
        	  //System.setProperty("webdriver.chrome.driver","C:\\Users\\younas.rehman\\source\\repos\\chromedriver.exe");
        	  ChromeOptions options = new ChromeOptions();       
             
              options.addArguments("--enable-extensions", "--ignore-certificate-errors", "general.useragent.override");
              //options.addArguments("headless");
              driver = new ChromeDriver(options);
              _systemElements1 = new system_elements(driver);    
          }
      }

      
      
      
      
//	
//	@Test
//public	void test_01()
//	{
//	
//	Response response= post("https://testmobile.api.haibooks.com/api/v2/account/register");
//	System.out.println(response.asString());
//	System.out.println(response.getBody());
//	System.out.println(response.getStatusCode());
//	System.out.println(response.getStatusLine());
//	System.out.println(response.getHeader("content-type"));
//	System.out.println(response.getTime());
//	
//	int status_code= response.getStatusCode();
//	Assert.assertEquals(status_code, 200); 
//	
//	}
//	
//	@Test
//public	void test_02()
//	{
//		
//		 MyHelperClass random_description = new MyHelperClass();
//         int description_generate = random_description.GetRandomvalue(3);
//         System.out.println("descr "+description_generate);
//        String email_value= random_description.GetRandomEmailvalue("testingemail_value");
//        System.out.println(email_value);
//        System.out.print(Constants.login_username);
//	}
//	
//@Test
//public void test_03()
//	
//	{
//		  
//		Response response = 
//			given().
//		  param("firstName","sdfs"). 
//		  param("lastName","sdf").
//		  param("email","warnesdffsds34sdfsassdfadsdfsg464@mailinator.com").
//		  param("phone","03165144394").
//		  param("password","khattak@321").
//		  param("confirmPassword","khattak@321").
//		  param("application/json").		
//		  when().
//		  post("https://testmobile.api.haibooks.com/api/v2/account/register").
//		  then().		  
//		  assertThat().
//		  body("data.createdUserId", equalTo("13490")).
//		  extract().
//	      response();
//		
//		 System.out.println(response.asString());
//		  System.out.println(response.getBody());
//	  
//	  
//		// * System.out.println(response.getStatusCode());
//		// * System.out.println(response.getStatusLine());
//		// * System.out.println(response.getHeader("content-type"));
//	//	 * System.out.println(response.getTime());
//	//	 */
//	}
//
//
//@DataProvider (name = "DataForPossssst")
//	public Object [][] dataForPost() {
//	 
//	 
////		Object [] [] data= new Object[2][2]; 
////		data [0][0]="Albedsfgrt";
////		data [0][1]="Ainssdgfdstien";				
////			
////		data [1][0]="Alax";
////		data [1][1]="hdgadfgdsles";		
////	    return data;
//	 
//	 return new Object [][] {
//		 {"Garam", "bell"},
//		 {"Harry", "clinton"}
//		 					};
//	 }
	


}
