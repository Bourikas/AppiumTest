package gr.geekit.AppiumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class JumpToActivitiesDemo extends BaseTest{
	@Test
	public void Miscellanous() throws MalformedURLException, URISyntaxException {
		//adb devices
		//adb shell dumpsys window | find "mCurrentFocus"
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
			    "intent", "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"
			));
		//actual automation
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
