package TestCases;
import MyHelper.MyHelperClass;
import groovyjarjarantlr.collections.List;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.Excelutils;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.apache.http.Header;
import org.asynchttpclient.util.HttpConstants.ResponseStatusCodes;

import Constant.Constants;
import Constant.Errorcode;
import Actions.generate_token;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Feature("Account Forgot Password")
public class Forgot_Password_test_cases  extends Baseclass {


	@Description("Verify Forgot Password")
	@Severity(SeverityLevel.BLOCKER)
	@Story("account/forgotpassword")
	@Test (priority=1 ) 

	public	void post_test_01_Account_verify_without_confirmation() 
	{
		String url= homeURL+ Constants.version+ Constants.forgot_password;		

		Response response = 
				given().				
				param("email",Constants.email_value_register).			
				param(Constants.content_type).		
				when().
				post(url).
				then().  
				assertThat().statusCode(200).
				extract().
				response();

		Boolean is_verified = response.path("data.success");		
		System.out.println("userIds : "+ is_verified);
		Assert.assertEquals(is_verified,true,"verification of Forgot password sending message");

	}


	@Description("Verify incorrect email Forgot Password")
	@Severity(SeverityLevel.NORMAL)
	@Story("account/forgotpassword")
	@Test (priority=2 ) 

	public	void post_test_02_verify_incorrect_email_forogt_password() 
	{
		String url= homeURL+ Constants.version+ Constants.forgot_password;		

		Response response = 
				given().				
				param("email","asdfsafsdf1713523434@mailinator.com1").			
				param(Constants.content_type).		
				when().
				post(url).
				then().  
				assertThat().statusCode(400).
				extract().
				response();

		int error_code = response.path("error.errors[0].code");		  
		System.out.println("error code : "+ error_code);
		Assert.assertEquals(error_code,Errorcode.IncorrectEmail,"Comparison of  Incorrect Email error code for forgot password");
	}



	@Description("Verify RequiredEmail Email for Forgot Password")
	@Severity(SeverityLevel.TRIVIAL)
	@Story("account/forgotpassword")
	@Test (priority=3 ) 

	public	void post_test_03_verify_required_email_for_forgot_pwd() 
	{
		String url= homeURL+ Constants.version+ Constants.forgot_password;		

		Response response = 
				given().				
				param("email").			
				param(Constants.content_type).		
				when().
				post(url).
				then().  
				assertThat().statusCode(400).
				extract().
				response();

		int error_code = response.path("error.errors[0].code");		  
		System.out.println("error code : "+ error_code);
		Assert.assertEquals(error_code,Errorcode.RequiredEmail,"Comparison of  Incorrect Email error code for forgot password");
	}



	@Description("Different password for change password")
	@Severity(SeverityLevel.CRITICAL)
	@Story("profile/changepassword")	
	//@Test (dependsOnMethods={"Test1"}, priority=4)
	@Test (priority=4 ) 
	public	void post_test_04_change_password_with_wrong_old_password() throws IOException 
	{

		Object username,password,temp_token;		

		if(Constants.email_value_register== null)
		{
			Excelutils excel=new Excelutils(Constants.excelPath, Constants.sheetname);
			username= excel.getCellData(19,1);
			password= excel.getCellData(18,1);		
		}
		else
		{
			username=Constants.email_value_register;
			password= "Pakistan1122";
		}

		generate_token token = new generate_token();
		Constants.temp_token_gene= token.perform_adding_token(username, password);
		if(Constants.temp_token_gene == null)
		{  
			Excelutils excel=new Excelutils(Constants.excelPath, Constants.sheetname);
			Constants.temp_token_gene= (String) excel.getCellData(20,1);			
		}

		String url= homeURL+ Constants.version+ Constants.profile_change_password;	

		Response response = 
				given().
				header("Authorization", "Bearer "+Constants.temp_token_gene).						 
				param("OldPassword","wrongpassword"). 
				param("NewPassword",Constants.tmp_password).						 
				param("version", 2).	
				when().
				post(url).
				then().		  
				assertThat().statusCode(400).		 
				extract().
				response();	
		int error_code = response.path("error.errors[0].code");		  
		System.out.println("error code : "+ error_code);
		Assert.assertEquals(error_code,Errorcode.DiffrentPasswords,"Comparison of  Different password");		
	}
	
	
	
	
	@Description("Minimum length password")
	@Severity(SeverityLevel.CRITICAL)
	@Story("profile/changepassword")	
	//@Test (dependsOnMethods={"Test1"}, priority=4)
	@Test (priority=5 ) 
	public	void post_test_05_Minimum_length_password_for_changing_password() throws IOException 
	{

		Object username,password,temp_token;		

		if(Constants.email_value_register== null)
		{
			Excelutils excel=new Excelutils(Constants.excelPath, Constants.sheetname);
			username= excel.getCellData(19,1);
			password= excel.getCellData(18,1);		
		}
		else
		{
			username=Constants.email_value_register;
			password= "Pakistan1122";
		}

		generate_token token = new generate_token();
		Constants.temp_token_gene= token.perform_adding_token(username, password);
		if(Constants.temp_token_gene == null)
		{  
			Excelutils excel=new Excelutils(Constants.excelPath, Constants.sheetname);
			Constants.temp_token_gene= (String) excel.getCellData(20,1);			
		}

		String url= homeURL+ Constants.version+ Constants.profile_change_password;	

		Response response = 
				given().
				header("Authorization", "Bearer "+Constants.temp_token_gene).						 
				param("OldPassword",password). 
				param("NewPassword",Constants.MinLenghtPassword).						 
				param("version", 2).	
				when().
				post(url).
				then().		  
				assertThat().statusCode(400).		 
				extract().
				response();	
		int error_code = response.path("error.errors[0].code");		  
		System.out.println("error code: "+ error_code);
		Assert.assertEquals(error_code,Errorcode.MinLenghtPassword,"Comparison of  Different password");		
	}





	@Description("Change Password")
	@Severity(SeverityLevel.CRITICAL)
	@Story("profile/changepassword")	
	//@Test (dependsOnMethods={"Test1"}, priority=4)
	@Test (priority=6 ) 
	public	void post_test_06_change_password() throws IOException 
	{

		Object username,password,temp_token;		

		if(Constants.email_value_register== null)
		{
			Excelutils excel=new Excelutils(Constants.excelPath, Constants.sheetname);
			username= excel.getCellData(19,1);
			password= excel.getCellData(18,1);		
		}
		else
		{
			username=Constants.email_value_register;
			password= "Pakistan1122";
		}

		generate_token token = new generate_token();
		Constants.temp_token_gene= token.perform_adding_token(username, password);
		if(Constants.temp_token_gene == null)
		{  
			Excelutils excel=new Excelutils(Constants.excelPath, Constants.sheetname);
			Constants.temp_token_gene= (String) excel.getCellData(20,1);			
		}

		String url= homeURL+ Constants.version+ Constants.profile_change_password;	

		Response response = 
				given().
				header("Authorization", "Bearer "+Constants.temp_token_gene).						 
				param("OldPassword",password). 
				param("NewPassword",Constants.tmp_password).						 
				param("version", 2).	
				when().
				post(url).
				then().		  
				assertThat().statusCode(200).		 
				extract().
				response();	

		Excelutils excel=new Excelutils(Constants.excelPath, Constants.sheetname);
		excel.writedatainExcel(18,1, Constants.tmp_password);
	}

}