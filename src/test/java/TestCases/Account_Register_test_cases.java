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
import java.time.Duration;

import org.apache.http.Header;
import org.asynchttpclient.util.HttpConstants.ResponseStatusCodes;

import Constant.Constants;
import Constant.Errorcode;
import Elements.system_elements;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Feature("Account Register")

public class Account_Register_test_cases extends Baseclass {	


	@Description("Verify Account Register with correct status code")
	@Severity(SeverityLevel.BLOCKER)
	@Story("account/register")
	@Test (priority=1 ,dataProvider= "account_register_data", dataProviderClass = Data_driven.class) 

	public	void post_test_01_Verify_new_account_register_status_code(String Firstname, String Lastname,String phone_no,String password) throws IOException
	{
		String url= homeURL+ Constants.version+ Constants.account_register;
		MyHelperClass random_description = new MyHelperClass();
		Constants.email_value_register= random_description.GetRandomEmailvalue("haibookstestforapi");
		System.out.println("Email registered 1 is : "+Constants.email_value_register);

		Response response = 
				given().
				param("firstName",Firstname). 
				param("lastName",Lastname).
				param("email",Constants.email_value_register).
				param("phone",phone_no).
				param("password",password).
				param("confirmPassword",password).
				param(Constants.content_type).		
				when().
				post(url).
				then().		  
				assertThat().statusCode(200).		 
				extract().
				response();

		Constants.response_body1 =response.getBody().asString();
		System.out.println("Response is : "+ Constants.response_body1);
		String userIds = response.path("data.createdUserId");
		Constants.created_user_id=Integer.parseInt(userIds);  
		System.out.println("userIds : "+ Constants.created_user_id);

		Excelutils excel=new Excelutils(Constants.excelPath, Constants.sheetname);
		excel.writedatainExcel(17,1,userIds);
		excel.writedatainExcel(18,1,password);
		excel.writedatainExcel(19,1,Constants.email_value_register);		

	}



	@Description("Verify User Already Registered")
	@Severity(SeverityLevel.CRITICAL)
	@Story("account/register")
	@Test (priority=2 ,dataProvider= "account_register_data", dataProviderClass = Data_driven.class) 

	public	void post_test_02_Verify_already_registered_account(String Firstname, String Lastname,String phone_no,String password)
	{
		String url= homeURL+ Constants.version+ Constants.account_register;		
		System.out.println("URL : "+url);
		System.out.println("Email registered 2 is : "+Constants.email_value_register);
		String registered_email=Constants.email_value_register;
		if(Constants.email_value_register== null)		
			registered_email=Constants.registered_username;

		Response response = 
				given().
				param("firstName",Firstname). 
				param("lastName",Lastname).
				param("email",registered_email).
				param("phone",phone_no).
				param("password",password).
				param("confirmPassword",password).
				param(Constants.content_type).		
				when().
				post(url).
				then().  
				assertThat().statusCode(400).	
				extract().
				response();

		//int status_code= response.getStatusCode();		
		int error_code = response.path("error.errors[0].code");		  
		System.out.println("error code : "+ error_code);
		Assert.assertEquals(error_code,Errorcode.UserAlreadyRegistered,"Comparison of user name already registered error code: ");
	}






	@Description("Verify Account verify without confirmation should be false")
	@Severity(SeverityLevel.NORMAL)
	@Story("account/isverified")
	@Test (priority=3 ,dataProvider= "account_register_data", dataProviderClass = Data_driven.class) 

	public	void Get_test_03_Account_verify_without_confirmation(String Firstname, String Lastname,String phone_no,String password) throws IOException
	{

		//		Account_Register_test_cases a= new  Account_Register_test_cases();
		//		a.post_test_01_Verify_new_account_register_status_code(Firstname, Lastname, phone_no, password);
		//		
		String url= homeURL+ Constants.version+ Constants.account_isv_verified;		

		Response response = 
				given().
				param("id",Constants.created_user_id). 
				get(url).
				then().		  
				assertThat().statusCode(200).		 
				extract().
				response();

		Constants.response_body1 =response.getBody().asString();
		System.out.println("Response is : "+ Constants.response_body1);
		Boolean is_verified = response.path("data.verified");
		//		Constants.created_user_id=Integer.parseInt(userIds);  
		//		System.out.println("userIds : "+ Constants.created_user_id);
		System.out.println("userIds : "+ is_verified);
		Assert.assertEquals(is_verified,false,"Comparison of Account verified");

	}


	@Description("check Account is Verify")
	@Severity(SeverityLevel.BLOCKER)
	@Story("account/isverified")
	@Test (priority=4,dataProvider= "account_register_data", dataProviderClass = Data_driven.class) 


	public void test_case_04_verify_account_is_verify(String Firstname, String Lastname,String phone_no,String password)
	{
		//Web part

		TestInitForWeb();
		if(homeURL == Constants.haibooks)
		{
			_systemElements1.perform_searching(Constants.email_value_register); 
		}
		else
		{
			_systemElements1.perform_searching(Constants.forward_email); 
		}
		_systemElements1.switch_To_IFrame();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 8000);");	

		//APi PART

		String url= homeURL+ Constants.version+ Constants.account_isv_verified;		
		Response response = 
				given().
				param("id",Constants.created_user_id). 
				get(url).
				then().		  
				assertThat().statusCode(200).		 
				extract().
				response();

		Constants.response_body1 =response.getBody().asString();
		System.out.println("Response is : "+ Constants.response_body1);
		Boolean is_verified = response.path("data.verified");
		//		Constants.created_user_id=Integer.parseInt(userIds);  
		//		System.out.println("userIds : "+ Constants.created_user_id);
		System.out.println("userIds : "+ is_verified);
		Assert.assertEquals(is_verified,true,"Comparison of Account verified");	


	}



	@Description("Verify Required Firstname")
	@Severity(SeverityLevel.TRIVIAL)
	@Story("account/register")
	@Test (priority=5 ,dataProvider= "account_register_data", dataProviderClass = Data_driven.class) 

	public	void post_test_05_Verify_required_firstname(String Firstname, String Lastname,String phone_no,String password)
	{
		String url= homeURL+ Constants.version+ Constants.account_register;		
		System.out.println("URL : "+url);
		System.out.println("Email registered 3 is : "+Constants.email_value_register);
		String registered_email=Constants.email_value_register;
		if(Constants.email_value_register== null)		
			registered_email=Constants.registered_username;

		Response response = 
				given().
				param("firstName",""). 
				param("lastName",Lastname).
				param("email",registered_email).
				param("phone",phone_no).
				param("password",password).
				param("confirmPassword",password).
				param(Constants.content_type).		
				when().
				post(url).
				then().  
				assertThat().statusCode(400).	
				extract().
				response();

		//int status_code= response.getStatusCode();		
		int error_code = response.path("error.errors[0].code");		  
		System.out.println("error code : "+ error_code);
		Assert.assertEquals(error_code,Errorcode.RequiredFirstName,"Comparison of Required Firstname error code");

	}



	@Description("Verify Required Lastname")
	@Severity(SeverityLevel.TRIVIAL)
	@Story("account/register")
	@Test (priority=6 ,dataProvider= "account_register_data", dataProviderClass = Data_driven.class) 

	public	void post_test_06_Verify_required_Lastname(String Firstname, String Lastname,String phone_no,String password)
	{
		String url= homeURL+ Constants.version+ Constants.account_register;		
		System.out.println("URL : "+url);
		System.out.println("Email registered 4 is : "+Constants.email_value_register);
		String registered_email=Constants.email_value_register;
		if(Constants.email_value_register== null)		
			registered_email=Constants.registered_username;

		Response response = 
				given().
				param("firstName",Firstname). 
				param("lastName","").
				param("email",registered_email).
				param("phone",phone_no).
				param("password",password).
				param("confirmPassword",password).
				param(Constants.content_type).		
				when().
				post(url).
				then().  
				assertThat().statusCode(400).	
				extract().
				response();

		//int status_code= response.getStatusCode();		
		int error_code = response.path("error.errors[0].code");		  
		System.out.println("error code : "+ error_code);
		Assert.assertEquals(error_code,Errorcode.RequiredLastName,"Comparison of  Required Lastname error code");
	}



	@Description("Verify Required email")
	@Severity(SeverityLevel.TRIVIAL)
	@Story("account/register")
	@Test (priority=7 ,dataProvider= "account_register_data", dataProviderClass = Data_driven.class) 

	public	void post_test_07_Verify_required_email(String Firstname, String Lastname,String phone_no,String password)
	{
		String url= homeURL+ Constants.version+ Constants.account_register;		
		System.out.println("URL : "+url);
		System.out.println("Email registered 5 is : "+Constants.email_value_register);
		//		String registered_email=Constants.email_value_register;
		//		if(Constants.email_value_register== null)		
		//			registered_email=Constants.registered_username;

		Response response = 
				given().
				param("firstName",Firstname). 
				param("lastName",Lastname).
				param("email","").
				param("phone",phone_no).
				param("password",password).
				param("confirmPassword",password).
				param(Constants.content_type).		
				when().
				post(url).
				then().  
				assertThat().statusCode(400).	
				extract().
				response();

		//int status_code= response.getStatusCode();		
		int error_code = response.path("error.errors[0].code");		  
		System.out.println("error code : "+ error_code);
		Assert.assertEquals(error_code,Errorcode.RequiredEmail,"Comparison of  Required email error code");
	}


	@Description("Verify Incorrect Email")
	@Severity(SeverityLevel.TRIVIAL)
	@Story("account/register")
	@Test (priority=8 ,dataProvider= "account_register_data", dataProviderClass = Data_driven.class) 

	public	void post_test_08_Verify_incorrect_email(String Firstname, String Lastname,String phone_no,String password)
	{
		String url= homeURL+ Constants.version+ Constants.account_register;		
		System.out.println("URL : "+url);
		System.out.println("Email registered 6 is : "+Constants.email_value_register);
		//		String registered_email=Constants.email_value_register;
		//		if(Constants.email_value_register== null)		
		//			registered_email=Constants.registered_username;

		Response response = 
				given().
				param("firstName",Firstname). 
				param("lastName",Lastname).
				param("email","abc").
				param("phone",phone_no).
				param("password",password).
				param("confirmPassword",password).
				param(Constants.content_type).		
				when().
				post(url).
				then().  
				assertThat().statusCode(500).
				extract().
				response();

		//int status_code= response.getStatusCode();		
		int error_code = response.path("error.errors[0].code");		  
		System.out.println("error code : "+ error_code);
		Assert.assertEquals(error_code,Errorcode.IncorrectEmail,"Comparison of  Incorrect Email error code");
	}

	@Description("Verify Confirm Password Required")
	@Severity(SeverityLevel.TRIVIAL)
	@Story("account/register")
	@Test (priority=9 ,dataProvider= "account_register_data", dataProviderClass = Data_driven.class) 

	public	void post_test_09_Verify_confirm_password_required(String Firstname, String Lastname,String phone_no,String password)
	{
		String url= homeURL+ Constants.version+ Constants.account_register;		
		System.out.println("URL : "+url);
		System.out.println("Email registered 7 is : "+Constants.email_value_register);
		String registered_email=Constants.email_value_register;
		if(Constants.email_value_register== null)		
			registered_email=Constants.registered_username;

		Response response = 
				given().
				param("firstName",Firstname). 
				param("lastName","").
				param("email",registered_email).
				param("phone",phone_no).
				param("password").
				param("confirmPassword").
				param(Constants.content_type).		
				when().
				post(url).
				then().  
				assertThat().statusCode(400).	
				extract().
				response();

		//int status_code= response.getStatusCode();		
		int error_code = response.path("error.errors[0].code");		  
		System.out.println("error code : "+ error_code);
		Assert.assertEquals(Errorcode.RequiredConfirmPassword,error_code,"Comparison of Confirm Password Required");
	}



	@Description("Verify MaxLength FirstName")
	@Severity(SeverityLevel.TRIVIAL)
	@Story("account/register")
	@Test (priority=10 ,dataProvider= "account_register_data", dataProviderClass = Data_driven.class) 

	public	void post_test_10_Verify_maxlength_firstname(String Firstname, String Lastname,String phone_no,String password)
	{
		String url= homeURL+ Constants.version+ Constants.account_register;
		MyHelperClass random_description = new MyHelperClass();
		String email_register= random_description.GetRandomEmailvalue("haibookstestforapi");

		Response response = 
				given().
				param("firstName", Constants.max_length_string). 
				param("lastName",Lastname).
				param("email",email_register).
				param("phone",phone_no).
				param("password",password).
				param("confirmPassword",password).
				param(Constants.content_type).		
				when().
				post(url).
				then().  
				assertThat().statusCode(400).	
				extract().
				response();

		//int status_code= response.getStatusCode();		
		int error_code = response.path("error.errors[0].code");		  
		System.out.println("error code : "+ error_code);
		Assert.assertEquals(error_code,Errorcode.MaxLengthFirstName,"Comparison of MaxLength Firstname error code");

	}



	@Description("Verify MaxLength LastName")
	@Severity(SeverityLevel.TRIVIAL)
	@Story("account/register")
	@Test (priority=11 ,dataProvider= "account_register_data", dataProviderClass = Data_driven.class) 

	public	void post_test_11_Verify_maxlength_LastName(String Firstname, String Lastname,String phone_no,String password)
	{
		String url= homeURL+ Constants.version+ Constants.account_register;
		MyHelperClass random_description = new MyHelperClass();
		String email_register= random_description.GetRandomEmailvalue("haibookstestforapi");

		Response response = 
				given().
				param("firstName", Firstname). 
				param("lastName",Constants.max_length_string).
				param("email",email_register).
				param("phone",phone_no).
				param("password",password).
				param("confirmPassword",password).
				param(Constants.content_type).		
				when().
				post(url).
				then().  
				assertThat().statusCode(400).	
				extract().
				response();

		//int status_code= response.getStatusCode();		
		int error_code = response.path("error.errors[0].code");		  
		System.out.println("error code : "+ error_code);
		Assert.assertEquals(error_code,Errorcode.MaxLengthLastName,"Comparison of  MaxLength LastName  error code");

	}


	@Description("Verify MaxLength Phone")
	@Severity(SeverityLevel.TRIVIAL)
	@Story("account/register")
	@Test (priority=12 ,dataProvider= "account_register_data", dataProviderClass = Data_driven.class) 

	public	void post_test_12_Verify_maxlength_Phone(String Firstname, String Lastname,String phone_no,String password)
	{
		String url= homeURL+ Constants.version+ Constants.account_register;
		MyHelperClass random_description = new MyHelperClass();
		String email_register= random_description.GetRandomEmailvalue("haibookstestforapi");

		Response response = 
				given().
				param("firstName", Firstname). 
				param("lastName",Lastname).
				param("email",email_register).
				param("phone",Constants.max_length_string).
				param("password",password).
				param("confirmPassword",password).
				param(Constants.content_type).		
				when().
				post(url).
				then().  
				assertThat().statusCode(400).	
				extract().
				response();

		//int status_code= response.getStatusCode();		
		int error_code = response.path("error.errors[0].code");		  
		System.out.println("error code : "+ error_code);
		Assert.assertEquals(error_code,Errorcode.MaxLengthPhone,"Comparison of MaxLength Phone  error code");

	}



	@Description("Verify NonInDigit Phone")
	@Severity(SeverityLevel.TRIVIAL)
	@Story("account/register")
	@Test (priority=13 ,dataProvider= "account_register_data", dataProviderClass = Data_driven.class) 

	public	void post_test_13_Verify_NoInDigit_Phone(String Firstname, String Lastname,String phone_no,String password)
	{
		String url= homeURL+ Constants.version+ Constants.account_register;
		MyHelperClass random_description = new MyHelperClass();
		String email_register= random_description.GetRandomEmailvalue("haibookstestforapi");

		Response response = 
				given().
				param("firstName", Firstname). 
				param("lastName",Lastname).
				param("email",email_register).
				param("phone",Constants.notindigit).
				param("password",password).
				param("confirmPassword",password).
				param(Constants.content_type).		
				when().
				post(url).
				then().  
				assertThat().statusCode(400).	
				extract().
				response();

		//int status_code= response.getStatusCode();		
		int error_code = response.path("error.errors[0].code");		  
		System.out.println("error code : "+ error_code);
		Assert.assertEquals(error_code,Errorcode.NonInDigit,"Comparison of NonInDigit Phone  error code");

	}


	@Description("Verify DiffrentPasswords")
	@Severity(SeverityLevel.TRIVIAL)
	@Story("account/register")
	@Test (priority=14 ,dataProvider= "account_register_data", dataProviderClass = Data_driven.class) 

	public	void post_test_14_Verify_DiffrentPasswords(String Firstname, String Lastname,String phone_no,String password)
	{
		String url= homeURL+ Constants.version+ Constants.account_register;
		MyHelperClass random_description = new MyHelperClass();
		String email_register= random_description.GetRandomEmailvalue("haibookstestforapi");

		Response response = 
				given().
				param("firstName", Firstname). 
				param("lastName",Lastname).
				param("email",email_register).
				param("phone",phone_no).
				param("password",password).
				param("confirmPassword","4554").
				param(Constants.content_type).		
				when().
				post(url).
				then().  
				assertThat().statusCode(400).	
				extract().
				response();

		//int status_code= response.getStatusCode();		
		int error_code = response.path("error.errors[0].code");		  
		System.out.println("error code : "+ error_code);
		Assert.assertEquals(error_code,Errorcode.DiffrentPasswords,"Comparison of DiffrentPasswords error code");

	}


	@Description("Verify MinLenghtPassword")
	@Severity(SeverityLevel.TRIVIAL)
	@Story("account/register")
	@Test (priority=15 ,dataProvider= "account_register_data", dataProviderClass = Data_driven.class) 

	public	void post_test_15_Verify_MinLenghtPassword(String Firstname, String Lastname,String phone_no,String password)
	{
		String url= homeURL+ Constants.version+ Constants.account_register;
		MyHelperClass random_description = new MyHelperClass();
		String email_register= random_description.GetRandomEmailvalue("haibookstestforapi");

		Response response = 
				given().
				param("firstName", Firstname). 
				param("lastName",Lastname).
				param("email",email_register).
				param("phone",phone_no).
				param("password",Constants.MinLenghtPassword).
				param("confirmPassword",Constants.MinLenghtPassword).
				param(Constants.content_type).		
				when().
				post(url).
				then().  
				assertThat().statusCode(400).	
				extract().
				response();

		//int status_code= response.getStatusCode();		
		int error_code = response.path("error.errors[0].code");		  
		System.out.println("error code : "+ error_code);
		Assert.assertEquals(error_code,Errorcode.MinLenghtPassword,"Comparison of MinLenghtPassword error code");

	}





	//	public	void post_test_02_account_verify()
	//	{
	//		String url= homeURL+ Constants.version+ Constants.account_register;
	//		MyHelperClass random_description = new MyHelperClass();
	//		Constants.email_value_register= random_description.GetRandomEmailvalue("haibookstestforapi");
	//		System.out.println("url is : "+url);
	//		System.out.println("Email registered is : "+Constants.email_value_register);
	//	
	//		Response response = 
	//		  given().
	//		  param("firstName",Constants.firstname). 
	//		  param("lastName",Constants.lastname).
	//		  param("email",Constants.email_value_register).
	//		  param("phone",Constants.phone_no_without_code).
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
	//		System.out.println("Response is : "+ Constants.response_body1);
	//	
	//	}



	//	@Test
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
	//	
	//	
	//
	//
	//	
	//	@Test
	//	public	void post_test_03_company_list()
	//	{
	//		String url= homeURL+ Constants.version+ Constants.company_create;		
	//	
	//		Response response = 
	//		  given().
	//		  header("Authorization", "Bearer "+Constants.authorization).
	//		 
	//		  param("CompanyName","test"). 
	//		  param("BusinessTypeId","1").
	//		  param("BusinessSectorId","8").
	//		  param("BusinessDetails","test").
	//		  param("OtherBusinessSector","test").
	//		  param("CompanyStartDate",1649406555).
	//		  param("FirstFinancialYearEnd",1649406555).
	//		  //param("firstFinancialYearEnd",Constants.password).
	//		  param("IsVatRegistered",true).
	//		  param(Constants.content_type).  
	//		  
	//		  param("version", 2).	
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
	//	
	//	
	//	@Test
	//	public	void post_test_04_change_password()
	//	{
	//		String url= homeURL+ Constants.version+ Constants.profile_change_password;		
	//	
	//		Response response = 
	//		  given().
	//		  header("Authorization", "Bearer "+Constants.authorization).
	//		  param("oldPassword",Constants.password). 
	//		  param("newPassword","Khattak@321").
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
	//	
	//	
	//	@Test
	//	public	void post_test_05_profile_company_list()
	//	{
	//		String url= homeURL+ Constants.version+ Constants.profile_company_list;		
	//	
	//		Response response = 
	//		  given().
	//		  header("Authorization", "Bearer "+Constants.authorization).
	//		  param("page",1). 		
	//		  param(Constants.content_type).
	//		  //param("version", 2).	
	//		  when().
	//		  get(url).
	//		  then().		  
	//		  assertThat().statusCode(200).		 
	//		  extract().
	//	      response();
	//	
	//		String response_body=response.asPrettyString();
	//		System.out.println("Response is : "+response_body);
	//	}
	//	
	//	
	//	
	//@Test
	//	public	void post_test_06_account_is_verified() throws IOException
	//	{
	//		//		String url= Constants.baseurl+ Constants.version+ Constants.account_is_verified;		
	//		//	
	//		//		Response response = 
	//		//		  given().
	//		//		  header("Authorization", "Bearer "+Constants.authorization).
	//		//		  param("id","13504"). 		
	//		//		  param(Constants.content_type).
	//		//		  param("version", 2).	
	//		//		  when().
	//		//		  get(url).
	//		//		  then().		  
	//		//		  assertThat().statusCode(200).		 
	//		//		  extract().
	//		//	      response();
	//		//	
	//		//		String response_body=response.asPrettyString();
	//		//		System.out.println("Response is : "+response_body);
	//
	//
	//		Excelutils excel=new Excelutils(Constants.excelPath, Constants.sheetname);
	//		Object username= excel.getCellData(12, 2);
	//		Object password= excel.getCellData(13, 2);	
	//
	//
	//		String url= homeURL+ Constants.version+ Constants.token;		
	//
	//		Response response = 
	//				given().
	//				param("userName",username). 
	//				param("password",password).
	//				param(Constants.content_type).
	//				//param("version", 2).	
	//				when().
	//				post(url).
	//				then().		  
	//				assertThat().statusCode(200).		 
	//				extract().
	//				response();
	//
	//		String response_body=response.asPrettyString();
	//		System.out.println("Response is : "+response_body);
	//
	//		String token = response.path("data.token");
	//		//	Object abc= excel.getCellData(1, 1);
	//		//	Object rowcount= excel.getRowcount();
	//		//	String pass="Passvalue";
	//		excel.writedatainExcel(11,2,token);
	//
	//	}
}