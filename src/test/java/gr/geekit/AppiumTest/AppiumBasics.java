package gr.geekit.AppiumTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class AppiumBasics extends BaseTest{
	@Test
	public void wifiSettingsName() throws MalformedURLException, URISyntaxException {
		
		//actual automation
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		// set wifi name
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\'3. Preference dependencies\']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertTitle = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		
		driver.findElement(By.id("android:id/edit")).sendKeys("GeekTechnology");
		driver.findElements(By.xpath("//android.widget.Button")).get(1).click();
		
		
		
	}
}
