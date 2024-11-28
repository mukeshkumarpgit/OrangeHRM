package OrangeHRM.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import OrangeHRM.CommonUtilities.CommonUtilities;

public class DashboardPage extends CommonUtilities {

	public WebDriver driver;

	public DashboardPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="")
	WebElement dashboardLabel;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
