package gr.geekit.AppiumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class MisceallanousAppiumActions extends BaseTest{
	@Test
	public void wifiSettingsName() throws MalformedURLException, URISyntaxException {
		
		//actual automation
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		// set wifi name
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\'3. Preference dependencies\']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		
		DeviceRotation landscape = new DeviceRotation(0, 0, 90);
		driver.rotate(landscape);
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertTitle = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		
		
		//copy paste
		//copy to clipboard - paste to clipboard
		
		driver.setClipboardText("GeekTechnology");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());

		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElement(By.id("android:id/edit")).sendKeys("LOL");

		driver.findElements(By.xpath("//android.widget.Button")).get(1).click();
		
		// pressing keys

		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
		
		
	}
}
