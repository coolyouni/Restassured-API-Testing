//package TestCases;
//import MyHelper.MyHelperClass;
//import groovyjarjarantlr.collections.List;
//import io.restassured.http.Headers;
//import io.restassured.response.Response;
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;
//
//import org.apache.http.Header;
//import org.asynchttpclient.util.HttpConstants.ResponseStatusCodes;
//
//import Constant.Constants;
//import static io.restassured.RestAssured.given;
//import static io.restassured.RestAssured.post;
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//
//
//public class Account_test_cases2 extends Baseclass {
//	
//	@Parameters({"phone_number"})
//	@Test (priority = 1)
//	public	void post_test_01_Verify_new_account_register_status_code(String phone_number)
//	{
//		String url= homeURL+ Constants.version+ Constants.account_register;
//		MyHelperClass random_description = new MyHelperClass();
//		Constants.email_value_register= random_description.GetRandomEmailvalue("haibookstestforapinewtest");
//		System.out.println("url is : "+url);
//		System.out.println("Email registered is test 01 : "+Constants.email_value_register);
//	
//		Response response = 
//		  given().
//		  param("firstName",Constants.firstname). 
//		  param("lastName",Constants.lastname).
//		  param("email",Constants.email_value_register).
//		  param("phone",phone_number).
//		  param("password",Constants.password).
//		  param("confirmPassword",Constants.password).
//		  param(Constants.content_type).		
//		  when().
//		  post(url).
//		  then().		  
//		  assertThat().statusCode(200).		 
//		  extract().
//	      response();
//	
//		Constants.response_body1 =response.asPrettyString();
//		System.out.println("Response is  test 01 response: "+ Constants.response_body1);
//	}
//	
//	
//	
//	
//	@Test (priority = 2)
//	public	void post_test_02_getting_token()
//	{
//		String url= homeURL+ Constants.version+ Constants.token;		
//	
//		Response response = 
//		  given().
//		  param("userName",Constants.email_value_register). 
//		  param("password",Constants.password).
//		  param(Constants.content_type).
//		  //param("version", 2).	
//		  when().
//		  post(url).
//		  then().		  
//		  assertThat().statusCode(200).		 
//		  extract().
//	      response();
//	
//		String response_body=response.asPrettyString();
//		System.out.println("Response is : "+response_body);
//	}	
//
//}
