package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
			
		try {
			prop = new Properties();
			FileInputStream	fis = new FileInputStream("..\\poc.cucumber.testng\\src\\main\\java\\config\\config.properties");
			try {
				prop.load(fis);
			} catch (IOException e) {
				e.getMessage();
			}
		} catch (FileNotFoundException e) {
		   	e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		   String browserName =  prop.getProperty("browser");
		   
		   if(browserName.equals("chrome")) {
			   
			  System.setProperty("webdriver.chrome.driver", "F:\\Selenium_Chromedriver\\v85\\chromedriver.exe");
			  driver = new ChromeDriver();
			   
		   } else if(browserName.equals("chrome")) {
			   System.setProperty("webdriver.chrome.driver", "F:\\Selenium_Chromedriver\\geckodriver.exe");
			   driver = new FirefoxDriver();
		   }
		
		   driver.manage().window().maximize();
		   driver.manage().deleteAllCookies();
		   driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		   driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		  
		   driver.get(prop.getProperty("url"));
		
	}
	
	public static void scrollToViewElement(WebElement element) {
	//	driver.findElement(By element);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
	}
	
	
	
	
	
	
	
	

}
