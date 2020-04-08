package appiumLearning;



import java.net.MalformedURLException;
import org.openqa.selenium.WebElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.*;

public class Gestures extends Base {

	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = getDriver("emulator");
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		WebElement element = driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")");

		// Perform Tap
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(element))).perform();
		WebElement element2 = driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")");
		t.tap(tapOptions().withElement(element(element2))).perform();
		WebElement element3 = driver.findElementByAndroidUIAutomator("text(\"People Names\")");
		t.longPress(longPressOptions().withElement(element(element3)).withDuration(ofSeconds(2))).release().perform();
		System.out.println(driver.findElementById("android:id/title").isDisplayed());

	}

}
