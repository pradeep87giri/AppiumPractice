package appiumLearning;

import java.net.MalformedURLException;
import java.util.List;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class UIAutomator extends Base {

	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = getDriver("emulator");		
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		List<AndroidElement> ls = driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)");
		System.out.println(ls.size());
	}

}
