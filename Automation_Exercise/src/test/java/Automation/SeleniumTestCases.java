package Automation;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;






public class SeleniumTestCases {
	
	@Test(priority=1)
	public void seleniumpage() {
		
		
		new WebDriverWait(Configuration.driver,20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(Locators.googletext)));
		Configuration.driver.findElement(By.xpath(Locators.googletext)).sendKeys("Selenium HQ");
		Configuration.driver.findElement(By.xpath(Locators.googletext)).sendKeys(Keys.ENTER);
		new WebDriverWait(Configuration.driver,20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(Locators.seleniumlink)));
		Configuration.driver.findElement(By.xpath(Locators.seleniumlink)).click();
		
		
	}
	@Test(priority=2)
	public void gettitle() {
		
		String expectedtitle = "Code Export · Selenium IDE";
		String actualtitle = Configuration.driver.getTitle();
		System.out.println(actualtitle);
		Assert.assertEquals(expectedtitle, actualtitle);
		
	}
	
	@AfterTest
	public void quit() {
		
		Configuration.driver.quit();
		
	}	

}
