package gr.geekit.AppiumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class DragDropDemo extends BaseTest{
	@Test
	public void LongPressGesture() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement element =  driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
		
		//drag and drop coordinates
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),
			    "endX", 630,
			    "endY", 560
			));
		String dragResultText = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		Assert.assertEquals(dragResultText, "Dropped!");

		Thread.sleep(2000);
	}

}
