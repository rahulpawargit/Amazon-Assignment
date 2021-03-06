	package SeleniumBasics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrokenLinks_Imges {
	
	public WebDriver driver;
	@BeforeTest
	public void openbrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
	     driver=new ChromeDriver();
		driver.get("https://tabbforum.com/");
		//driver.findElement(By.xpath("//*[@id='interadsmain']/div[1]/div/a")).click();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}
		@Test
		public void veifybrokenlinks() throws InterruptedException, MalformedURLException, IOException
		{
		//	driver.findElement(By.xpath("//input[@name='username']")).sendKeys("naveenk");
		//	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("test@123");
		//	Thread.sleep(3000);
		//	driver.findElement(By.xpath("//input[@class='btn btn-small']")).click();
		//	driver.switchTo().frame("mainpanel");
			
			
			List<WebElement> linklist= driver.findElements(By.tagName("a"));
			linklist.addAll(driver.findElements(By.tagName("a")));
			
			List<WebElement> activelinks=new ArrayList<WebElement>();
			
			System.out.println("Size of all links and images-->" +linklist.size());
				
		
			
			for(int i=0; i<linklist.size();i++)
			{
			System.out.println(linklist.get(i).getAttribute("href"));
			
				
				if(      (linklist.get(i).getAttribute("href")!=null ) && 
						 (! linklist.get(i).getAttribute("href").contains("javascript")) && 
						 (! linklist.get(i).getAttribute("href").contains("null")) && 
						 (! linklist.get(i).getAttribute("href").contains("tel")) &&
						 (! linklist.get(i).getAttribute("href").contains("javascript"))
						 )
	              {
		             activelinks.add(linklist.get(i));
	              }
			}
			
			System.out.println("Size of active links and images-->" +activelinks.size());
			System.out.println("**********************************Result start here*****************************************");
			
			for(int j=0; j<activelinks.size(); j++)
			{
				if(activelinks.get(j).getAttribute("href").indexOf("mailto:") !=-1)
					continue;
				
			HttpURLConnection connection= (HttpURLConnection)new URL(activelinks.get(j).getAttribute("href")).openConnection();
			connection.connect();
			String response = connection.getResponseMessage();
			connection.disconnect();
			
			System.out.println(activelinks.get(j).getAttribute("href")+"-->" +response );
			}
			
			
			
			//linklist1.addAll(driver.findElements(By.tagName("a")));
		}
		 
		
		
		
		@AfterTest
		public void closeinstance()
		{
			driver.close();
		}

}
