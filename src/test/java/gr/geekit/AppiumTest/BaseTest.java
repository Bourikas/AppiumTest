package gr.geekit.AppiumTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service; 
	
	@BeforeClass  //this annotation makes the class work on the start
	public void ConfigureAppium () throws MalformedURLException, URISyntaxException {
		service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\g.bourikas\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build(); //this pipeline builds a service of appium  server
		service.start();
		
		
		// android driver 
		// appium code -> appium server -> mobile
		// 
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Bourifone");
		options.setApp("C:\\Users\\g.bourikas\\eclipse-workspace\\AppiumTest\\src\\test\\java\\resources\\ApiDemos-debug.apk");
//		options.setApp("C:\\Users\\g.bourikas\\eclipse-workspace\\AppiumTest\\src\\test\\java\\resources\\General-Store.apk");
		
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass //this annotation makes the class work on the end
	public void tearDown() {
		//stop server
				driver.quit();
				service.stop(); 
	}
	
	public void longPressAction(WebElement webEle, int duration) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement)webEle).getId(),
						"duration", duration));
	}
	
	public void ScrollToEndFunction() {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
					"left", 100, 
					"top", 100,
					"width", 200,
					"height", 200,
					"direction", "down",
					"percent", 3.0
					));
		} while (canScrollMore);
	}
	
	public void ScrollLeftAction(WebElement firstImage, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement)firstImage).getId(),
				"direction", direction,
			    "percent", 0.25
			));
	}
}
