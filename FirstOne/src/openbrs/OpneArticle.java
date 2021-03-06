package openbrs;



import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class OpneArticle {
  private WebDriver driver;
  //private String baseUrl;
  //private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
   // baseUrl = "https://centest.acs.org/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitled2() throws Exception {
	  
	  System.setProperty("webdriver.firefox.marionette","C:/SeleniumDriver/geckodriver-v0.20.0-win64");
	   WebDriver driver=new FirefoxDriver();
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       driver.get("https://centest.acs.org//index.html");
       driver.findElement(By.xpath("//span")).click();
       driver.findElement(By.xpath("(//a[contains(text(),'Meet Geraldine Richmond, 2018 Priestley Medalist')])[2]")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  
}
