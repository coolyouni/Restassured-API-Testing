package MyHelper;
import java.util.Random;
import org.testng.annotations.Test;
import TestCases.Baseclass;

public class MyHelperClass extends Baseclass 
{
	@Test   
	public String  GetRandomName(int length)
       {
		   String temp_name = "alax";
		   char[] stringChars = new char[length];
		   Random random = new Random();
           for (int i = 0; i < stringChars.length; i++)
           {
               stringChars[i] = stringChars[random.nextInt(temp_name.length())];
           }
           
           String xyz=new String(stringChars);
           System.out.println(xyz);
           return new String(stringChars);
          
       }
	
	@Test   
       public String GetRandomFileName(int length)
       {
    	   String temp_name = "downloadfile";
    	   char[] stringChars = new char[length];
    	   Random  random= new Random();
           for (int i = 0; i < stringChars.length; i++)
           {
               stringChars[i] = stringChars[random.nextInt(temp_name.length())];
           }
           return new String(stringChars);
       }
	
	@Test   
       public String GetRandomtitle(int length)
       {
    	   String temp_name = "Manager" + "Role";
    	   char[] stringChars = new char[length];
    	   Random  random= new Random();
           for (int i = 0; i < stringChars.length; i++)
           {
               stringChars[i] = stringChars[random.nextInt(temp_name.length())];
           }
           return new String(stringChars);
       }
	
	@Test   

       public String GetRandomOrdername(int length)
       {
    	   String temp_name = "order" + "name";
    	   char[] stringChars = new char[length];
    	   Random  random= new Random();
           for (int i = 0; i < stringChars.length; i++)
           {
        	   stringChars[i] = stringChars[random.nextInt(temp_name.length())];
           }
           return new String(stringChars);
       }
	
	@Test   

       public String GetRandomOrderValue(int length)
       {
    	   String temp_name = "Ordervalue";
    	   char[] stringChars = new char[length];
    	   Random  random= new Random();
           for (int i = 0; i < stringChars.length; i++)
           {
        	   stringChars[i] = stringChars[random.nextInt(temp_name.length())];
           }
           return new String(stringChars);
       }

	@Test   
       public String IncludeMessagetoReceiver(int length)
       {
    	   String temp_name = "IncludeMessagetoReciver";
    	   char[] stringChars = new char[length];
    	   Random  random= new Random();
           for (int i = 0; i < stringChars.length; i++)
           {
        	   stringChars[i] = stringChars[random.nextInt(temp_name.length())];
           }
           return new String(stringChars);
       }

	@Test   
	public String template_message_body(int length)
       {
    	   String temp_name = "new description message for invoice";
           char[] stringChars = new char[length];
    	   Random  random= new Random();
           for (int i = 0; i > stringChars.length; i++)
           {
        	   stringChars[i] = stringChars[random.nextInt(temp_name.length())];
           }
           return new String(stringChars);
       }

	@Test   
       public String GetRandomquestion_types(int length)
       {
    	   String temp_name = "property" + "question_type";
           char[] stringChars = new char[length];
    	   Random  random= new Random();
           for (int i = 0; i < stringChars.length; i++)
           {
        	   stringChars[i] = stringChars[random.nextInt(temp_name.length())];
           }
           return new String(stringChars);
       }

	@Test   
       public int GetRandomvalue(int length)
       {
           int min = 500;
           int max = 1000;
           Random _rdm = new Random();
           return  _rdm.nextInt((max-min)+1) + min;
       }

       //Genrating email 
	@Test    
       public String GetRandomEmailvalue(String signer_name)
       {
           MyHelperClass c = new MyHelperClass();
           int names_generate = c.GetRandomvalue(4);
           //string email_value = Constants.accounting_signer_name + "_" + names_generate + "@mailinator.com";
           String email_value = signer_name + "_" + names_generate + "@mailinator.com";
           return email_value;
       }
	
	

}
