

package datadrivenexcel;

import org.testng.annotations.Test;



import java.io.IOException;
import java.util.HashMap;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class datadrivenwithexcelhelper {
   
public	WebDriver driver;
public String URL = "http://newtours.demoaut.com";
     public  String path ="C:\\selenium-java\\Testexcel\\src\\azzi.xlsx";       
public String sheetName="Sheet1";  
@BeforeTest
   public void openApplication() throws InterruptedException
   {
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
	 driver = new ChromeDriver();
	
	
	//System.setProperty("webdriver.gecko.driver", "C:\\gecko driver\\geckodriver 2.exe");
//WebDriver driver = new FirefoxDriver();
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
    // VERIFYING THE USER REGISTRATION
    public void userRegistration() throws IOException, InterruptedException 
         {
    //	  public String userexpected ; 
    
    List<HashMap<String,String>> datamap;  
       
datamap =  ExcelHelper.getData(path,sheetName);
    
    
    for (int row = 0; row <= 2; row++) {
   
    
           	  
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
// driver.findElement(By.name("city")).sendKeys(row.getCell(6).getStringCellValue());
 
  driver.findElement(By.name("state")).sendKeys(datamap.get(row).get("state"));
  driver.findElement(By.name("postalCode")).sendKeys(datamap.get(row).get("postalCode"));
  Select drpcountry = new Select(driver.findElement(By.name("country")));
    drpcountry.selectByVisibleText(datamap.get(row).get("country"));
   driver.findElement(By.name("email")).sendKeys(datamap.get(row).get("username"));
   driver.findElement(By.name("password")).sendKeys(datamap.get(row).get("Password"));
   driver.findElement(By.name("confirmPassword")).sendKeys(datamap.get(row).get("ConfirmPassword"));
   driver.findElement(By.name("register")).click();
   Thread.sleep(2000);
   
   String actual=driver.findElement(By.tagName("Body")).getText();
   String sExpected = "Your user name is "+datamap.get(row).get("username");
  // System.out.println( "check user registrion:"+sActualValue.contains(sExpected));
// Asset.assertTrue( sActualValue.contains(sExpected), "Checking the User Registration");
   org.testng.Assert.assertTrue(actual.contains(sExpected)); 
  
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





