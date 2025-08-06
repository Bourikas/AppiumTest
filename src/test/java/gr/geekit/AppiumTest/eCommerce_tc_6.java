package gr.geekit.AppiumTest;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
public class eCommerce_tc_6 extends BaseTestECommerce{
	@Test
	public void FillForm () throws InterruptedException {
		
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("George Bourikas");
		driver.hideKeyboard();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		//add items to cart
		//add first 
		driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		//add second --BECAUSE THE FIRST ITEM CHANGES TEXT TO ADDED TO CART WE GET ITEM 0 AGAIN
		driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		

		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		
		//how to know if page is fully loaded
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.textToBe(By.id("com.androidsample.generalstore:id/toolbar_title"), "Cart"));
		List<WebElement> productPrices = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productPrice"));
		int priceListSize = productPrices.size();
		Double calculatedSum = 0.0;
		for (int i = 0; i< priceListSize; i++) {
			String price = productPrices.get(i).getText();
			Double formattedPrice = Double.parseDouble(price.substring(1));
			calculatedSum += formattedPrice;
		}
		String totalAmount = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().substring(1);
		Double formattedTotalAmount = Double.parseDouble(totalAmount);
		Assert.assertEquals(formattedTotalAmount,calculatedSum);
		
		WebElement webEle = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/termsButton"));
//		//checking terms and conditions
//		longPressAction(webEle, 2000);
//		driver.findElement(AppiumBy.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		Thread.sleep(5000);
		Set<String> contexts = driver.getContextHandles();
		for (String contextName:contexts) {
			System.out.println(contextName);
		}
		//tapping to avoid chrome popup menu, before switching context because
		//tapByCoordinates only works in native_app
		tapByCoordinates(500, 2145);
		Thread.sleep(1000);
		tapByCoordinates(500, 1900);
		driver.context("WEBVIEW_com.androidsample.generalstore");
		
		driver.findElement(By.name("q")).sendKeys("pink geek shop");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");

		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
	}

}
