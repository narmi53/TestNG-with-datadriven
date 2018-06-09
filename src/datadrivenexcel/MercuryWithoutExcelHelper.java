package datadrivenexcel;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;



import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class MercuryWithoutExcelHelper {
   
   
public	WebDriver driver;
//public WebDriver driver
    public String baseUrl = "http://newtours.demoaut.com";
    public String expected = "Register: Mercury Tours";
     public String actual;
    public String userexpected ; 
    
    public   String path ="C:\\selenium-java\\Testexcel\\src\\Register.xlsx" ; 
    		public String sheetName="Sheet1";
@BeforeTest
    public void openApplication() throws InterruptedException
    {
	
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	 
//System.setProperty("webdriver.gecko.driver", "C:\\firefoxdriver\\geckodriver.exe");
//driver = new FirefoxDriver();
        driver.get(baseUrl);
     
      Thread.sleep(5000);
    }
     
     @Test(priority=0)
     public void verifyRegisterLink() throws InterruptedException
    {
 
      driver.findElement(By.linkText("REGISTER")).click();
         Thread.sleep(5000);
         actual = driver.getTitle();
      AssertJUnit.assertEquals(actual, expected);   	  
    }
     
     @Test(priority=1)
     // VERIFYING THE USER REGISTRATION
     public void userRegistration() throws IOException, InterruptedException 
          {
     
    File file =    new File(path);  
     	FileInputStream inputStream = new FileInputStream(file);           
    Workbook  wb = new XSSFWorkbook(inputStream);   
    Sheet sht = wb.getSheet(sheetName);     
    int rowCount = sht.getLastRowNum()-sht.getFirstRowNum();     
    System.out.println("Row cont:" + rowCount);	  
 
    
    for (int i = 1; i <= rowCount; i++) {
      
        Row row = sht.getRow(i);   	  
    System.out.println( "Test 2: verify user registration test, Row number is :"+ i );
     	   driver.findElement(By.linkText("REGISTER")).click();   
     
     	   
      driver.findElement(By.name("firstName")).sendKeys(row.getCell(0).getStringCellValue());
  driver.findElement(By.name("lastName")).sendKeys(row.getCell(1).getStringCellValue());
  driver.findElement(By.name("phone")).sendKeys(row.getCell(2).getStringCellValue());
  driver.findElement(By.name("userName")).sendKeys(row.getCell(3).getStringCellValue());
  driver.findElement(By.name("address1")).sendKeys(row.getCell(4).getStringCellValue());
  driver.findElement(By.name("address2")).sendKeys(row.getCell(5).getStringCellValue());
  driver.findElement(By.name("city")).sendKeys(row.getCell(6).getStringCellValue());
  driver.findElement(By.name("state")).sendKeys(row.getCell(7).getStringCellValue());
  driver.findElement(By.name("postalCode")).sendKeys(row.getCell(8).toString());
  Select drpcountry = new Select(driver.findElement(By.name("country")));
    drpcountry.selectByVisibleText(row.getCell(9).getStringCellValue());
   driver.findElement(By.name("email")).sendKeys(row.getCell(10).getStringCellValue());
   driver.findElement(By.name("password")).sendKeys(row.getCell(11).getStringCellValue());
   driver.findElement(By.name("confirmPassword")).sendKeys(row.getCell(12).getStringCellValue());
   driver.findElement(By.name("register")).click();
   
   driver.findElement(By.linkText("Flights")).click();
   Thread.sleep(4000);
   
   
   Thread.sleep(2000);
	driver.findElement(By.name("tripType")).click();
   	Thread.sleep(4000);
   	Select Dropdown=new Select(driver.findElement(By.name("passCount")));
   	Dropdown.selectByVisibleText(row.getCell(13).getStringCellValue());
   	Thread.sleep(2000);
   	Select Dropdown1=new Select(driver.findElement(By.name("fromPort")));
   	Dropdown1.selectByVisibleText(row.getCell(14).getStringCellValue());
   	Thread.sleep(2000);
   	Select Dropdown2=new Select(driver.findElement(By.name("fromMonth")));
   	Dropdown2.selectByVisibleText(row.getCell(15).getStringCellValue());
   	Thread.sleep(2000);
   	Select Dropdown3=new Select(driver.findElement(By.name("fromDay")));
   	Dropdown3.selectByVisibleText(row.getCell(16).getStringCellValue());
   	Thread.sleep(2000);
   	Select Dropdown4=new Select(driver.findElement(By.name("toPort")));
   	Dropdown4.selectByVisibleText(row.getCell(17).getStringCellValue());
   	Thread.sleep(2000);
   	Select Dropdown5=new Select(driver.findElement(By.name("toMonth")));
   	Dropdown5.selectByVisibleText(row.getCell(18).getStringCellValue());
   	Thread.sleep(2000);
   	Select Dropdown6=new Select(driver.findElement(By.name("toDay")));
   	Dropdown6.selectByVisibleText(row.getCell(19).getStringCellValue());
   	Thread.sleep(2000);
   	driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[1]")).click();
   	Thread.sleep(2000);
   	Select Dropdown7=new Select(driver.findElement(By.name("airline")));
   	Dropdown7.selectByVisibleText(row.getCell(20).getStringCellValue());
   	
   	driver.findElement(By.name("findFlights")).click();
   	
   	driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[5]/td[1]/input")).click();
   	Thread.sleep(2000);
   	driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[7]/td[1]/input")).click();
   	Thread.sleep(2000);

   	driver.findElement(By.name("reserveFlights")).click();
   	
   	driver.findElement(By.name("passFirst0")).sendKeys(row.getCell(21).getStringCellValue());
   	Thread.sleep(2000);
   	driver.findElement(By.name("passLast0")).sendKeys(row.getCell(22).getStringCellValue());
   	Thread.sleep(2000);
   	Select Dropdown8= new Select(driver.findElement(By.name("pass.0.meal")));
   	Dropdown8.selectByVisibleText(row.getCell(23).getStringCellValue());
   	Thread.sleep(2000);
   	Select Dropdown9=new Select(driver.findElement(By.name("creditCard")));
   	Dropdown9.selectByVisibleText(row.getCell(24).getStringCellValue());
   	Thread.sleep(2000);
   	driver.findElement(By.name("creditnumber")).sendKeys(row.getCell(25).getStringCellValue());
   	Thread.sleep(2000);
   	Select Dropdown10=new Select(driver.findElement(By.name("cc_exp_dt_mn")));
   	Dropdown10.selectByVisibleText(row.getCell(26).getStringCellValue());
   	Thread.sleep(2000);
   	Select Dropdown11=new Select(driver.findElement(By.name("cc_exp_dt_yr")));
   	Dropdown11.selectByVisibleText(row.getCell(27).getStringCellValue());
   	Thread.sleep(2000);
   	driver.findElement(By.name("cc_frst_name")).sendKeys(row.getCell(28).getStringCellValue());
   	Thread.sleep(2000);
   	driver.findElement(By.name("cc_mid_name")).sendKeys(row.getCell(29).getStringCellValue());
   	Thread.sleep(2000);
   	driver.findElement(By.name("cc_last_name")).sendKeys(row.getCell(30).getStringCellValue());
   	Thread.sleep(2000);
   	driver.findElement(By.name("ticketLess")).click();
   	Thread.sleep(2000);
   	driver.findElement(By.name("billAddress1")).clear();
   	Thread.sleep(2000);
   	driver.findElement(By.name("billAddress1")).sendKeys(row.getCell(31).getStringCellValue());
   	Thread.sleep(2000);
   	driver.findElement(By.name("billAddress2")).sendKeys(row.getCell(32).getStringCellValue());
   	Thread.sleep(2000);
   	driver.findElement(By.name("billCity")).clear();
   	Thread.sleep(2000);
   	driver.findElement(By.name("billCity")).sendKeys(row.getCell(33).getStringCellValue());
   	Thread.sleep(2000);
   	driver.findElement(By.name("billState")).clear();
   	Thread.sleep(2000);
   	driver.findElement(By.name("billState")).sendKeys(row.getCell(34).getStringCellValue());
   	Thread.sleep(2000);
   	driver.findElement(By.name("billZip")).clear();
   	Thread.sleep(2000);
   	driver.findElement(By.name("billZip")).sendKeys(row.getCell(35).getStringCellValue());
   	Thread.sleep(2000);
   	Select Dropdown12=new Select(driver.findElement(By.name("billCountry")));
   	Dropdown12.selectByVisibleText(row.getCell(36).getStringCellValue());
   	Thread.sleep(2000);
   	driver.findElement(By.name("ticketLess")).click();
   	Thread.sleep(2000);
   	driver.findElement(By.name("delAddress1")).clear();
   	Thread.sleep(2000);
   	driver.findElement(By.name("delAddress1")).sendKeys(row.getCell(37).getStringCellValue());
   	Thread.sleep(2000);
   	driver.findElement(By.name("delAddress2")).sendKeys(row.getCell(38).getStringCellValue());
   	Thread.sleep(2000);
   	driver.findElement(By.name("delCity")).clear();
   	Thread.sleep(2000);
   	driver.findElement(By.name("delCity")).sendKeys(row.getCell(39).getStringCellValue());
   	Thread.sleep(2000);
   	driver.findElement(By.name("delState")).clear();
   	Thread.sleep(2000);
   	driver.findElement(By.name("delState")).sendKeys(row.getCell(40).getStringCellValue());
   	Thread.sleep(2000);
   	driver.findElement(By.name("delZip")).clear();
   	Thread.sleep(2000);
   	driver.findElement(By.name("delZip")).sendKeys(row.getCell(41).getStringCellValue());
   	Thread.sleep(2000);
   	Select Dropdown13=new Select(driver.findElement(By.name("delCountry")));
   	Dropdown13.selectByVisibleText(row.getCell(42).getStringCellValue());
   	Thread.sleep(2000);
   	driver.findElement(By.name("buyFlights")).click();
   	
  
 String  sActualValue=driver.findElement(By.tagName("Body")).getText();
 	System.out.println( "check the actual value:"+sActualValue); 
 
 	userexpected = "Your user name is "+row.getCell(10).getStringCellValue();    
AssertJUnit.assertTrue(sActualValue.contains(userexpected));  
System.out.println( "Out put resuts for Test2" + sActualValue.contains(userexpected)  );
 	driver.findElement(By.linkText("SIGN-OFF")).click();   	 
  }
 	 
     }      
     
     @AfterTest
     public void closeApplication()
     {
     	driver.close();
     	driver.quit();
     }
}
