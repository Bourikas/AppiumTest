package gr.geekit.AppiumTest;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce_tc_3 extends BaseTestECommerce{
	@Test
	public void FillForm () throws InterruptedException {
		
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("George Bourikas");
		driver.hideKeyboard();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
//		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
//		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Argentina']")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
//		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		int productCounter = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productName")).size();
		for (int i = 0; i<productCounter; i++) {
			String productName = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if (productName.equalsIgnoreCase("jordan 6 rings")) {
				driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
		}
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		String productName = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(productName, "Jordan 6 Rings");
		Thread.sleep(3000);
		
	}

}
