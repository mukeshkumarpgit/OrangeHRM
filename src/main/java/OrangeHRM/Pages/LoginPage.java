package OrangeHRM.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import OrangeHRM.CommonUtilities.CommonUtilities;
import org.testng.Assert;

public class LoginPage extends CommonUtilities {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[name='username']")
	WebElement userName;

	@FindBy(css = "input[name='password']")
	WebElement password;

	@FindBy(css = ".orangehrm-demo-credentials p")
	List<WebElement> credentials;

	@FindBy(css = ".oxd-alert-content-icon")
	WebElement alertIcon;

	@FindBy(css = ".oxd-alert-content-text")
	WebElement invalidCredentials;

	@FindBy(css = "button[type='submit']")
	WebElement loginButton;

	@FindBy(css = ".orangehrm-login-forgot-header")
	WebElement forgotPassword;

	public String[] retrieveCredentials() {

		String[] name = credentials.get(0).getText().split(":");
		String userName = name[1].trim();
		String[] pass = credentials.get(1).getText().split(":");
		String password = pass[1].trim();

		System.out.println(userName + password);

		String[] cred = { userName, password };
		return cred;
	}

	public void invalidCredentials(String user, String pass) {

		userName.sendKeys(user);
		password.sendKeys(pass);
		loginButton.click();

		if (alertIcon.isDisplayed()) {
			String msg = invalidCredentials.getText();
			Assert.assertEquals("Invalid credentials", msg);
		} else {
			Assert.assertFalse(true);
		}

	}

	public ResetPasswordPage forgotPassword() {
		forgotPassword.click();
		ResetPasswordPage rpp = new ResetPasswordPage(driver);
		return rpp;
	}

	public DashboardPage userLoginWithValidCredential(String user, String pass) {
		userName.sendKeys(user);
		password.sendKeys(pass);
		loginButton.click();

		DashboardPage dashboard = new DashboardPage(driver);
		return dashboard;

	}

}
