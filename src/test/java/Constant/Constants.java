package Constant;

import TestCases.Baseclass;
import io.restassured.http.Header;
import net.bytebuddy.utility.RandomString;

public final class Constants  extends Baseclass {
	
	//URL
	 public static final String testmobileapi = "https://testmobile.api.haibooks.com/api/"; 	 
	 public static final String haibooks = 	"https://api.haibooks.com/api/";
	 
	 
	 public static final String version = 	"v2/";
	 public static final String account_register = "account/register";
	 public static final String account_isv_verified = "account/isverified";
	 public static final String forgot_password = "account/forgotpassword";
	 
	 public static final String token="token";
	 public static final String company_create="settings/company/create";
	 public static final String profile_change_password="profile/changepassword";
	 public static final String profile_company_list="profile/companies/list";
	 public static final String account_is_verified="account/isverified";
	
	 
	 
	 //Global Variable used in system

	 public static int response_b;
	 public static String response_body1;
	 public static String email_value_register;
	 public static int created_user_id;
	
	 
	 //Temporary token gernation
	 public static String temp_token_gene;
		
	 
	 //Excel variable used in the system
	 public static final String excelPath=  "./DataFromExcel/TestData.xlsx";
	 public static final String sheetname="Variables";
	
	 public static final String	authorization= "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6IlpVTkJSZ3cwZThKLzBlZ1NLTHF5VWdYemJjRXpkYmdnVjUyWVVmaEVNVjQ9IiwibmFtZWlkIjoiM0haaFBXODFWMzQ9IiwibmJmIjoxNjUzNDU3NTU3LCJleHAiOjE2NTM0NjExNTcsImlhdCI6MTY1MzQ1NzU1N30.Bbdqdne9x8fMxkdo9RkHdgL9m9UBA32rILzkIDLJX0Q";
	 	
	  //Login with paramters haibooks
    public static final String registered_username = "seckin.tuzun@arfitect.com";
    public static final String registered_password = "Arf1234";
    public static final String forward_email = "activationemailsupportforhaibooks123@mailinator.com";


    // Registration fields Maximum length
    public static final String max_length_string = "sdsdgdfgdsgdgdfgdsfgdfgfdgdf dsfsgdsf dffsaf dfgd51";
    public static final String notindigit = "sdsdgdfgdsgdgdfgd";
    public static final String MinLenghtPassword = "12345";
    
    // //Login with paramters test2haibooks
    public static final String test2_login_username = "younas.rehman@haibooks.com";
    public static final String test2_login_password = "Khattak@321";

    // //Login with paramters receipthaibooks
    public static final String receipt_login_username = "alax_883@mailinator.com";
    public static final String receipt_login_password = "Pakistan@1124";
    //Browser///////////////////////////////

    public static final String chrome = "chrome";
    public static final String Firefox = "firefox";        

    ////////////////////////////////////////////URL ///////////////////////////////////
    public static final String main_website = "https://haibooks.com/Login";
    public static final String test_website = "https://test2.haibooks.com/login";
    public static final String mailinator_URL = "https://mailinator.com";
    public static final String receipt_site = "https://testreceipts.haibooks.com/login";
    //Registration Data///////////////////////////////////////
    public static final String firstname = "Alax";
    public static final String lastname = "hales";
    public static final String phone_no_without_code = "03165144396";
    public static final String password = "Pakistan@1124";
    public static final String tmp_password = "Pakistan@1124";
    
    public static final String Company_Name = "MCA ACCOUNTANTS LIMITED";
    public static final String content_type = "application/json";

    //Account type values
    public static final String sales_turnover_value = "2365541";
    public static final String vat_value_no_vat = "1";
    public static final String vat_value_20_vat = "2";

    //Add items value
    public static final String  unit_cost_value = "3.99";
    public static final String  Quantity = "4.79";

    //Module name
    public static final String invoice_creation = "invoice";

    //sheet no
    public static final int shhet_1 = 1;
    public static final int shhet_2 = 2;
    public static final int shhet_3 = 3;

    
    
    
}
