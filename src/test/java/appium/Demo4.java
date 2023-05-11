package appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Demo4 {
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
		dc.setCapability("appPackage", "com.whatsapp");
		dc.setCapability("appActivity", "com.whatsapp.HomeActivity");
		
		URL url = new URL("http://localhost:4723");
		AndroidDriver driver = new AndroidDriver(url,dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(AppiumBy.accessibilityId("Next")).click();
		driver.findElement(AppiumBy.accessibilityId("com.whatsapp:id/eula_accept")).click();
		driver.findElement(AppiumBy.accessibilityId("com.whatsapp:id/registration_phone")).sendKeys("123456");

//		driver.findElement(AppiumBy.accessibilityId("Views")).click();
//		driver.findElement(AppiumBy.accessibilityId("Controls")).click();
//		driver.findElement(AppiumBy.accessibilityId("2. Dark Theme")).click();
//		driver.findElement(AppiumBy.accessibilityId("Checkbox 1")).click();
//		driver.quit();
//		asb.stop();
	}
}
