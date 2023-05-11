package appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Demo2 {
@Test
	public void openApp() throws MalformedURLException{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "S9");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		dc.setCapability(MobileCapabilityType.UDID, "22524a1c38017ece");
		dc.setCapability("appPackage", "com.udemy.android");
		dc.setCapability("appActivity", ".CombinedDeepLinkActivity");
		
		URL url = new URL("http://localhost:4723");
		AndroidDriver driver = new AndroidDriver(url,dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
}
