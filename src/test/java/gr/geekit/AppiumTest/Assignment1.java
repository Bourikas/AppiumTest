package gr.geekit.AppiumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class Assignment1 extends BaseTest{
	@Test
	public void LongPressGesture() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a long message")).click();
//		WebElement element =  driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
//		
//		//drag and drop coordinates
//		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
//			    "elementId", ((RemoteWebElement) element).getId(),
//			    "endX", 630,
//			    "endY", 560
//			));
		String messageText = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
		Assert.assertEquals(messageText, "Header title");
		driver.findElement(AppiumBy.id("android:id/button1")).click();

		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with Holo Light theme")).click();
		driver.findElement(AppiumBy.id("android:id/button2")).click();

		
		Thread.sleep(2000);
	}

}
