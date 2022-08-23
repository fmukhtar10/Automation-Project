package Automation;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;




public class Configuration {
		
		
		protected static WebDriver driver;
		private static String baseURL;
		
		
		
		@Test
		public static void beforetest() throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "/Users/fmukhtar/Downloads/chromedriver");
			driver = new ChromeDriver();
			baseURL = "https://www.google.com";
			driver.get(baseURL);
			
			//Maximize the Browser's Window
			driver.manage().window().maximize();
					
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(baseURL);
					
			
			

		}

	}
