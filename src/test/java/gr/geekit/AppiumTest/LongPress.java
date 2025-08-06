package gr.geekit.AppiumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class LongPress extends BaseTest{
	@Test
	public void LongPressGesture() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]")).click();
		WebElement webEle = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		longPressAction(webEle, 2000);
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement)webEle).getId(),
						"duration", 2000));
		String titleText = driver.findElement(By.id("android:id/title")).getText();
		Assert.assertEquals(titleText, "Sample menu");
		Assert.assertTrue(driver.findElement(AppiumBy.id("android:id/title")).isDisplayed());
		Thread.sleep(2000);
	}

}
