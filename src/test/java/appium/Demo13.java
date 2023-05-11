package appium;

import static org.testng.Assert.assertEquals;

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

public class Demo13 {
	@Test
	public void login() throws Throwable {
		File f = new File("C:\\Users\\SYED SAMEER\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
	 AppiumDriverLocalService asb = new AppiumServiceBuilder().withAppiumJS(f).withIPAddress("127.0.0.1").usingPort(4723).build();
		asb.start();

		// set desire capabilities for identifying the device
		DesiredCapabilities dc = new DesiredCapabilities();
	
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "S9");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		dc.setCapability(MobileCapabilityType.UDID, "22524a1c38017ece");
		dc.setCapability("unlockType", "pin");
		dc.setCapability("unlockKey", "3732");
		dc.setCapability("appPackage", "com.androidsample.generalstore");
		dc.setCapability("appActivity", ".MainActivity");

		// connect to appium server
	
			URL u = new URL("http://localhost:4723");
		
		// use android drivers to work with android
		AndroidDriver d = new AndroidDriver(u, dc);
		//wait
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		asb.stop();
	}
}