package ecommerce;

import java.net.MalformedURLException;

import org.openqa.selenium.By;

import appiumLearning.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TC2 extends Base {

	/************ This test case is to get text from toast message **********/
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		AndroidDriver<AndroidElement> driver = getDriver("emulator");
		driver.findElementByXPath("//*[@text='Female']").click();
		driver.findElementById("android:id/text1").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		driver.findElementByXPath("//*[@text='Argentina']").click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		//Get Toast msg
		System.out.println(driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name"));
	}

}