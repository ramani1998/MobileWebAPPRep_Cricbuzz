package TestingWeb;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class CricBuzz {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		//Common capabilities required to test an app
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Ramani");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		//chrome driver executable will not be available in mobile capability/android capability
		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C:\\Users\\RamaniPalaniappan\\OneDrive\\Setupfiles\\Chromedriver84\\chromedriver.exe");
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.get("https://m.cricbuzz.com/");
				
		//code to click Menu and then click home link
		driver.findElement(By.xpath("//a[contains(@href,'menu')]")).click();;
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		
		//code to scroll upto link - Members of CSK test positive for COVID and click that link
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//span[@class='cbz-ui-home-headline'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		
		
		//WebElement menu = driver.findElement(By.xpath("//android.view.View[@content-desc='Menu ']"));
		//WebElement menu = driver.findElement(MobileBy.AccessibilityId("Menu"));
				//driver.findElementByAccessibilityId("Menu");
		
		
		//WebElement menu = driver.findElement(MobileBy.AccessibilityId("Menu")).click();
		

	}

}
