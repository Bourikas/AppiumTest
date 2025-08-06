package gr.geekit.AppiumTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce_tc_2 extends BaseTestECommerce{
	@Test
	public void FillForm () throws InterruptedException {
		
//		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("George Bourikas");
		driver.hideKeyboard();
//		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(AppiumBy.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"));"));
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Austria']")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		String toastMessage = driver.findElement(AppiumBy.xpath("//android.widget.Toast[1]")).getAttribute("name");
		Assert.assertEquals(toastMessage, "Please enter your name");
		
		Thread.sleep(3000);
		
	}

}
