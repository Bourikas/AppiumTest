package gr.geekit.AppiumTest;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class BrowserTest1 extends BrowserBaseTest{
	@Test //test annotation using TestNG framework
	public void browserTest() throws InterruptedException {
		driver.get("http://google.com");
		System.out.println("in google");

		// Print all contexts
		Set<String> contexts = driver.getContextHandles();
		for (String contextName : contexts) {
		    System.out.println("Available context: " + contextName);
		}

		driver.context("CHROMIUM");
		try {
		    driver.findElement(By.xpath("//*[text()='Διαβάστε περισσότερα']")).click();
		} catch (Exception e) {
		    System.out.println("Direct XPath click failed, trying JavaScript...");

		    // 3️⃣ If XPath fails, force click via JavaScript
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript(
		        "document.querySelectorAll('*').forEach(e => { " +
		        "if(e.innerText && e.innerText.includes('Διαβάστε περισσότερα')) e.click(); });"
		    );
		}
		try {
		    driver.findElement(By.xpath("//*[text()='Διαβάστε περισσότερα']")).click();
		} catch (Exception e) {
		    System.out.println("Direct XPath click failed, trying JavaScript...");

		    // 3️⃣ If XPath fails, force click via JavaScript
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript(
		        "document.querySelectorAll('*').forEach(e => { " +
		        "if(e.innerText && e.innerText.includes('Διαβάστε περισσότερα')) e.click(); });"
		    );
		}
		try {
		    driver.findElement(By.xpath("//*[text()='Αποδοχή όλων']")).click();
		} catch (Exception e) {
		    System.out.println("Direct XPath click failed, trying JavaScript...");

		    // 3️⃣ If XPath fails, force click via JavaScript
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript(
		        "document.querySelectorAll('*').forEach(e => { " +
		        "if(e.innerText && e.innerText.includes('Αποδοχή όλων')) e.click(); });"
		    );
		}
//		driver.context("NATIVE_APP");
		driver.findElement(By.name("q")).sendKeys("pink geek shop");
		System.out.println("in pinkgeek");
		
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
	}

}
