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

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Feature("Account Forgot Password")
public class Token_test_cases  extends Baseclass {


	@Description("Adding Token")
	@Severity(SeverityLevel.CRITICAL)
	@Story("token")
	@Test (priority=1 ) 

	public	void post_test_01_adding_token() 
	{
//		String url= homeURL+ Constants.version+ Constants.token;		
//		
//				Response response = 
//						given().
//						param("userName",username). 
//						param("password",password).
//						param(Constants.content_type).
//						//param("version", 2).	
//						when().
//						post(url).
//						then().		  
//						assertThat().statusCode(200).		 
//						extract().
//						response();
//		
//				String response_body=response.asPrettyString();
//				System.out.println("Response is : "+response_body);
//		
//				String token = response.path("data.token");
//				//	Object abc= excel.getCellData(1, 1);
//				//	Object rowcount= excel.getRowcount();
//				//	String pass="Passvalue";
//				excel.writedatainExcel(11,2,token);
	}
}