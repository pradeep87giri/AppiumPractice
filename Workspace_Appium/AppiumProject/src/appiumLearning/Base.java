package appiumLearning;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Base {

	public static AndroidDriver<AndroidElement> getDriver(String strDevice) throws MalformedURLException {

		File f = new File("src");
		File file = new File(f, "General-Store.apk");
		System.out.println(file.getAbsolutePath());
		DesiredCapabilities cap = new DesiredCapabilities();
		if (strDevice.equalsIgnoreCase("emulator")) {
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel2Test");
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		} else if (strDevice.equalsIgnoreCase("real")) {
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		}
		cap.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10);
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public static AndroidDriver<AndroidElement> getDriverForInstalledApps() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		// cap.setCapability("appPackage","");
		// cap.setCapability("appActivity", "");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel2Test");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.appium.android.apis.ApiDemos");

		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	
	public static AndroidDriver<AndroidElement> getBrowserDriver(String strDevice) throws MalformedURLException{
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		if (strDevice.equalsIgnoreCase("emulator")) {
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel2Test");
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		} else if (strDevice.equalsIgnoreCase("real")) {
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		}
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}