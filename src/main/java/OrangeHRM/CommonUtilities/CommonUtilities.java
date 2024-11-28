package OrangeHRM.CommonUtilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtilities {

	public WebDriver driver;

	public CommonUtilities(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForElementToAppear(By ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
	}
	
	public void validateLable() {
		driver.findElement(By.xpath("//h6"));
	}
	
}
