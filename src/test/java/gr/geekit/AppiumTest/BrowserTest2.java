package gr.geekit.AppiumTest;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class BrowserTest2 extends BrowserBaseTest{
	@Test //test annotation using TestNG framework
	public void browserTest() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.xpath("//span[@class=\"navbar-toggler-icon\"]")).click();
		driver.findElement(By.xpath("//a[@routerlink=\"/products\"]")).click();
		
		WebElement link = driver.findElement(By.xpath("//a[@href='/angularAppdemo/products/3']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", link);

		String text = link.getText();
		Assert.assertEquals(text ,"Devops");
		Thread.sleep(3000);
	}

}
