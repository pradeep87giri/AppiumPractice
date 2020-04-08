package appiumLearning;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class DragAndDrop extends Base{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement> driver = getDriver("emulator");
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Drag and Drop\")").click();
		
		WebElement ele1 = driver.findElementById("io.appium.android.apis:id/drag_dot_1");
		WebElement ele2 = driver.findElementById("io.appium.android.apis:id/drag_dot_2");
		WebElement ele3 = driver.findElementById("io.appium.android.apis:id/drag_dot_3");
		
		TouchAction t = new TouchAction(driver);
		//We can use either of the below 2 options for drag & drop. 2nd option works only if there is no action after moveTo
		t.longPress(longPressOptions().withElement(element(ele1))).moveTo(element(ele2)).release().perform();
		t.longPress(element(ele1)).moveTo(element(ele3)).release().perform();

	}

}
