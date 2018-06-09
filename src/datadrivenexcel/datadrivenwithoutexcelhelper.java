    package datadrivenexcel;



	import org.testng.annotations.Test;

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
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.Select;

	import org.testng.Assert;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class datadrivenwithoutexcelhelper {
	   
	   
	public	WebDriver driver;
	//public WebDriver driver
	    public String baseUrl = "http://newtours.demoaut.com";
	    public String expected = "Register: Mercury Tours";
	     public String actual;
	    public String userexpected ; 
	    
	  public   String path ="C:\\NewExcelScript\\src\\Registration.xlsx";
	public String sheetName="Sheet1";
	@BeforeTest
	    public void openApplication() throws InterruptedException
	    {
		
		System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver.exe");
		 driver = new ChromeDriver();
		 
		 
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
	      Assert.assertEquals(actual, expected);   	  
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
	   Thread.sleep(2000);
	 	String  sActualValue=driver.findElement(By.tagName("Body")).getText();
	 	System.out.println( "check the actual value:"+sActualValue); 
	 
	 	userexpected = "Your user name is "+row.getCell(10).getStringCellValue();    
	Assert.assertTrue(sActualValue.contains(userexpected));  
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
