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
public class Company  extends Baseclass {


	@Description("create Company")
	@Severity(SeverityLevel.BLOCKER)
	@Story("settings/company/create")
	@Test (priority=1 ) 

	public	void post_test_01_Create_company() 
	{
		String url= homeURL+ Constants.version+ Constants.company_create;		

		String authorization="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6Ik1FbFgwM2ZZS0UwZUhzUkNVSGhHb1ZQT1k5TjFueDN1NytLSFFHWjdwUkVkbFlkSHRQN2E0Zz09IiwibmFtZWlkIjoiVmgvTjZjd3UvcUE9IiwibmJmIjoxNjU0NTc4MzIxLCJleHAiOjE2NTQ1ODE5MjEsImlhdCI6MTY1NDU3ODMyMX0.Q8llHj1tzEdBIMepeAIvLOX5Qyvn-NYTKH5-3w2MscY";
		
		Response response = 
						  given().
						  header("Authorization", "Bearer "+authorization).
						 
						  param("CompanyName","testaasxxfas"). 
						  param("BusinessTypeId","1").
						  param("BusinessSectorId","8").
						  param("BusinessDetails","test").
						  param("OtherBusinessSector","test").
						  param("CompanyStartDate",1649406555).
						  param("FirstFinancialYearEnd",1649406555).
						  //param("firstFinancialYearEnd",Constants.password).
						  param("IsVatRegistered",true).
						  param(Constants.content_type).  
						  
						  param("version", 2).	
						  when().
						  post(url).
						  then().		  
						  assertThat().statusCode(200).		 
						  extract().
					      response();
					
						String response_body=response.asPrettyString();
						System.out.println("Response is : "+response_body);

	}



}