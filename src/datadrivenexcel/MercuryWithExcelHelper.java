package datadrivenexcel;


import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class MercuryWithExcelHelper {
   
	public	WebDriver driver;
	public String URL = "http://newtours.demoaut.com";
	
	public  String path ="C:\\selenium-java\\Testexcel\\src\\Register.xlsx";       
	public String sheetName="Sheet1";  
	@BeforeTest
	   public void openApplication() throws InterruptedException
	   {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		
		driver.get(URL);
   	    Thread.sleep(5000);
	
	   }
	
	
   
    @Test(priority=0)
    public void verifyRegisterLink() throws InterruptedException
   {
      String expected = "Register: Mercury Tours";
       
       
   	       driver.findElement(By.linkText("REGISTER")).click();
     	   Thread.sleep(5000);
     	   String actual = driver.getTitle();
     	  org.testng.Assert.assertEquals(actual, expected);   	  
   }
    
    
   
    @Test(priority=1)
    public void userRegistration() throws IOException, InterruptedException 
         {
    //	  public String userexpected ; 
    	
    	
    	
    	
    
    List<HashMap<String,String>> datamap;  
       
datamap =  ExcelHelper.getData(path,sheetName);
    
    
    for (int row =0; row <= 4; row++) {
   
    
           	  
   	System.out.println( "Test 2: verify user registration test, Row number is :"+ row );
  
     
  driver.findElement(By.linkText("REGISTER")).click();
  Thread.sleep(2000);	 
 
 
  driver.findElement(By.name("firstName")).sendKeys(datamap.get(row).get("firstName"));
  driver.findElement(By.name("lastName")).sendKeys(datamap.get(row).get("lastName"));
  driver.findElement(By.name("phone")).sendKeys(datamap.get(row).get("phone"));
  driver.findElement(By.name("userName")).sendKeys(datamap.get(row).get("email"));
  driver.findElement(By.name("address1")).sendKeys(datamap.get(row).get("address1"));
  driver.findElement(By.name("address2")).sendKeys(datamap.get(row).get("address2"));
  driver.findElement(By.name("city")).sendKeys(datamap.get(row).get("city"));
  driver.findElement(By.name("state")).sendKeys(datamap.get(row).get("state"));
  driver.findElement(By.name("postalCode")).sendKeys(datamap.get(row).get("postalCode"));
  Select drpcountry = new Select(driver.findElement(By.name("country")));
    drpcountry.selectByVisibleText(datamap.get(row).get("country"));
   driver.findElement(By.name("email")).sendKeys(datamap.get(row).get("username"));
   driver.findElement(By.name("password")).sendKeys(datamap.get(row).get("Password"));
   driver.findElement(By.name("confirmPassword")).sendKeys(datamap.get(row).get("ConfirmPassword"));
   driver.findElement(By.name("register")).click();
   Thread.sleep(2000);
   driver.findElement(By.linkText("Flights")).click();
   Thread.sleep(2000);
   
   	driver.findElement(By.name("tripType")).click();
   	
   	Select Dropdown=new Select(driver.findElement(By.name("passCount")));
   	Dropdown.selectByVisibleText(datamap.get(row).get("Passengers"));
   	Thread.sleep(2000);
   	Select Dropdown1=new Select(driver.findElement(By.name("fromPort")));
   	Dropdown1.selectByVisibleText(datamap.get(row).get("Departing From"));
   	Thread.sleep(2000);
   	Select Dropdown2=new Select(driver.findElement(By.name("fromMonth")));
   	Dropdown2.selectByVisibleText(datamap.get(row).get("OnMonth"));
   	Thread.sleep(2000);
   Select Dropdown3=new Select(driver.findElement(By.name("fromDay")));
  Dropdown3.selectByVisibleText(datamap.get(row).get("Onday "));
   	Thread.sleep(2000);
   	Select Dropdown4=new Select(driver.findElement(By.name("toPort")));
   	Dropdown4.selectByVisibleText(datamap.get(row).get("Arriving In"));
   	Thread.sleep(2000);
   	Select Dropdown5=new Select(driver.findElement(By.name("toMonth")));
   	Dropdown5.selectByVisibleText(datamap.get(row).get("ReturningMonth"));
   	Thread.sleep(2000);
   	Select Dropdown6=new Select(driver.findElement(By.name("toDay")));
   	Dropdown6.selectByVisibleText(datamap.get(row).get("ReturningDay"));
   	Thread.sleep(2000);
   	driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[1]")).click();
   	Thread.sleep(2000);
   	Select Dropdown7=new Select(driver.findElement(By.name("airline")));
   	Dropdown7.selectByVisibleText(datamap.get(row).get("Airline"));
   	
   	driver.findElement(By.name("findFlights")).click();
   	
   	driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[5]/td[1]/input")).click();
   	Thread.sleep(2000);
   	driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[7]/td[1]/input")).click();
   	Thread.sleep(2000);

   	driver.findElement(By.name("reserveFlights")).click();
   	
   	driver.findElement(By.name("passFirst0")).sendKeys(datamap.get(row).get("FirstName"));
   	Thread.sleep(2000);
   	driver.findElement(By.name("passLast0")).sendKeys(datamap.get(row).get("LastName"));;
   	Thread.sleep(2000);
   	Select Dropdown8= new Select(driver.findElement(By.name("pass.0.meal")));
   	Dropdown8.selectByVisibleText(datamap.get(row).get("  Meal"));
   	Thread.sleep(2000);
   	Select Dropdown9=new Select(driver.findElement(By.name("creditCard")));
   	Dropdown9.selectByVisibleText(datamap.get(row).get("CardType"));
   	Thread.sleep(2000);
   	driver.findElement(By.name("creditnumber")).sendKeys(datamap.get(row).get("Number"));
   	Thread.sleep(2000);
   	Select Dropdown10=new Select(driver.findElement(By.name("cc_exp_dt_mn")));
   	Dropdown10.selectByVisibleText(datamap.get(row).get("ExpMonth"));
   	Thread.sleep(2000);
   	Select Dropdown11=new Select(driver.findElement(By.name("cc_exp_dt_yr")));
   	Dropdown11.selectByVisibleText(datamap.get(row).get("ExpYear"));
   	Thread.sleep(2000);
   	driver.findElement(By.name("cc_frst_name")).sendKeys(datamap.get(row).get("FirstName"));
   	Thread.sleep(2000);
   	driver.findElement(By.name("cc_mid_name")).sendKeys(datamap.get(row).get("Middle"));
   	Thread.sleep(2000);
   	driver.findElement(By.name("cc_last_name")).sendKeys(datamap.get(row).get("LastName"));
   	Thread.sleep(2000);
   	driver.findElement(By.name("ticketLess")).click();
   	Thread.sleep(2000);
   	driver.findElement(By.name("billAddress1")).clear();
   	Thread.sleep(2000);
   	driver.findElement(By.name("billAddress1")).sendKeys(datamap.get(row).get("Address"));
   	Thread.sleep(2000);
   	driver.findElement(By.name("billAddress2")).sendKeys(datamap.get(row).get("Address2"));
   	Thread.sleep(2000);
   	driver.findElement(By.name("billCity")).clear();
   	Thread.sleep(2000);
   	driver.findElement(By.name("billCity")).sendKeys(datamap.get(row).get("city"));
   	Thread.sleep(2000);
   	driver.findElement(By.name("billState")).clear();
   	Thread.sleep(2000);
   	driver.findElement(By.name("billState")).sendKeys(datamap.get(row).get("State/Province"));
   	Thread.sleep(2000);
   	driver.findElement(By.name("billZip")).clear();
   	Thread.sleep(2000);
   	driver.findElement(By.name("billZip")).sendKeys(datamap.get(row).get("PostalCode"));
   	Thread.sleep(2000);
   	Select Dropdown12=new Select(driver.findElement(By.name("billCountry")));
   	Dropdown12.selectByVisibleText(datamap.get(row).get("Country"));
   	Thread.sleep(2000);
   	driver.findElement(By.name("ticketLess")).click();
   	Thread.sleep(2000);
   	driver.findElement(By.name("delAddress1")).clear();
   	Thread.sleep(2000);
   	driver.findElement(By.name("delAddress1")).sendKeys(datamap.get(row).get("Address"));
   	Thread.sleep(2000);
   	driver.findElement(By.name("delAddress2")).sendKeys(datamap.get(row).get("Address2"));
   	Thread.sleep(2000);
   	driver.findElement(By.name("delCity")).clear();
   	Thread.sleep(2000);
   	driver.findElement(By.name("delCity")).sendKeys(datamap.get(row).get("city"));
   	Thread.sleep(2000);
   	driver.findElement(By.name("delState")).clear();
   	Thread.sleep(2000);
   	driver.findElement(By.name("delState")).sendKeys(datamap.get(row).get("State/Province"));
   	Thread.sleep(2000);
   	driver.findElement(By.name("delZip")).clear();
   	Thread.sleep(2000);
   	driver.findElement(By.name("delZip")).sendKeys(datamap.get(row).get("PostalCode"));
   	Thread.sleep(2000);
   	Select Dropdown13=new Select(driver.findElement(By.name("delCountry")));
   	Dropdown13.selectByVisibleText(datamap.get(row).get("Country"));
   	Thread.sleep(2000);
   	driver.findElement(By.name("buyFlights")).click();
   	
  
   
    driver.findElement(By.linkText("SIGN-OFF")).click();
    Thread.sleep(2000);
  } //for loop 
   }
    @AfterTest
    public void closeApplication()
    {
    driver.close();
    driver.quit();
    }
}


