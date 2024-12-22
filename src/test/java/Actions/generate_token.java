package Actions;
import TestCases.Baseclass;
import io.restassured.response.Response;
import utils.Excelutils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constant.Constants;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.time.Duration;
import Elements.system_elements;

public class generate_token extends Baseclass {

	public String  perform_adding_token(Object username, Object password) throws IOException
	{
		String url= homeURL+ Constants.version+ Constants.token;		

		Response response = 
				given().
				param("userName",username). 
				param("password",password).
				param(Constants.content_type).
				//param("version", 2).	
				when().
				post(url).
				then().		  
				assertThat().statusCode(200).		 
				extract().
				response();

		String response_body=response.asPrettyString();
		System.out.println("Response is : "+response_body);

		String token = response.path("data.token");
		//	Object abc= excel.getCellData(1, 1);
		//	Object rowcount= excel.getRowcount();
		//	String pass="Passvalue";
		Excelutils excel=new Excelutils(Constants.excelPath, Constants.sheetname);
		excel.writedatainExcel(20,1,token);			
		return token;

	}


}
