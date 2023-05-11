package appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Demo10 {
@Test
	public void openApp() throws MalformedURLException{
//	File f = new File("C:\\Users\\SYED SAMEER\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
//	 AppiumDriverLocalService asb = new AppiumServiceBuilder().withAppiumJS(f).withIPAddress("127.0.0.1").usingPort(4723).build();
//	asb.start();
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "S9");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		dc.setCapability(MobileCapabilityType.UDID, "22524a1c38017ece");
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", ".ApiDemos");
		
		URL url = new URL("http://localhost:4723");
		AndroidDriver driver = new AndroidDriver(url,dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		//swipe to left
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "left", 50, "top", 250, "width", 750, "height", 250,
			    "direction", "left",
			    "percent", 1.0
			));
		//swipe to right

		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "left", 50, "top", 250, "width", 750, "height", 250,
			    "direction", "right",
			    "percent", 1.0
			));


//		driver.quit();
//		asb.stop();
	}
}
