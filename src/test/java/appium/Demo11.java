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

public class Demo11 {
	@Test
	public void login() throws Throwable {
		

		// set desire capabilities for identifying the device
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "S9");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		dc.setCapability(MobileCapabilityType.UDID, "22524a1c38017ece");
		dc.setCapability("appPackage", "com.androidsample.generalstore");
		dc.setCapability("appActivity", ".MainActivity");

		// connect to appium server
	
			URL u = new URL("http://localhost:4723");
		

		// use android drivers to work with android
		AndroidDriver d = new AndroidDriver(u, dc);
		//wait
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// click on the country selection box
		d.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();

		// scroll for the country
		d.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));

		// select the country by click
		WebElement country = d.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Argentina']"));
		country.click();

		// type the name
		d.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("lolwa");

		// click on login/let's go
		d.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		Thread.sleep(2000);
		// scroll to particular shoe
		d.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Converse All Star\"))"));

		// get the shoe text for further validation
		String expt = d.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Converse All Star']")).getText();
		System.out.println(expt);

		// handling the multiple element found
		d.findElements(AppiumBy.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		// d.findElement(AppiumBy.xpath("//android.widget.TextView[@text='ADD TO CART']")).click();


		// click on add to cart
		d.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	

		// validation
		String act = d.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Converse All Star']")).getText();
		System.out.println(act);
		Assert.assertEquals(act, expt);
		d.quit();
	
	}
}