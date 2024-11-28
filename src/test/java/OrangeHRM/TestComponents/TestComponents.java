package OrangeHRM.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import OrangeHRM.Pages.LoginPage;

public class TestComponents {

	public WebDriver driver;

	public WebDriver initializeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\OrangeHRM\\Resources\\GlobalData.properties");
		prop.load(fis);
		System.out.println("The browser is "+prop.getProperty("browser"));
		// String browserName = prop.getProperty("browser");

		// Ternary Operator
		// System.getProperty looks any browser give in the mvn command or else it will
		// get the browser propertly from GlobalData
		// if mvn command line has browser property it fetched the property and based on
		// the browser, our code wille execute
	//	String browserName = System.getProperty("user.dir") != null ? System.getProperty("browser") : prop.getProperty("browser");
		String browserName = prop.getProperty("browser");
		System.out.println("The brows is "+browserName);
		ChromeOptions options = new ChromeOptions();
		if (browserName.contains("chrome")) {
			if(browserName.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1400,900));
		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\mukeshkumar.p\\Documents\\Selenium\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();

		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}

	@BeforeTest
	public void launchApplication() throws IOException {
		driver = initializeDriver();
	}

	public LoginPage goTo() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		LoginPage login = new LoginPage(driver);
		return login;
	}

	@AfterTest(enabled = false)
	public void tearDown() {
		driver.quit();
	}

}
