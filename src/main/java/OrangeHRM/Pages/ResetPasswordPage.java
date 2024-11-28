package OrangeHRM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import OrangeHRM.CommonUtilities.CommonUtilities;

public class ResetPasswordPage extends CommonUtilities {

	public WebDriver driver;

	public ResetPasswordPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[name='username']")
	WebElement userName;

	@FindBy(css = "button[type='submit']")
	WebElement resetPasswordButton;

	@FindBy(xpath = "//h6[contains(@class,'forgot-password-title')]")
	WebElement resetPassword;

	By userNameTextBox = By.cssSelector("input[name='username']");
	By resetPasswordText = By.xpath("//h6[contains(@class,'forgot-password-title')]");

	public void resetPage(String user) {

		waitForElementToAppear(userNameTextBox);
		userName.sendKeys(user);
		resetPasswordButton.click();
		waitForElementToAppear(resetPasswordText);

		String text = resetPassword.getText();
		Assert.assertEquals("Reset Password link sent successfully", text);

		redirectPage();
	}

	private void redirectPage() {
		// TODO Auto-generated method stub
		driver.navigate().back();
		waitForElementToAppear(userNameTextBox);
		driver.navigate().back();
	}

}
