package OrangeHRM.TestFolder;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;



import OrangeHRM.Pages.DashboardPage;
import OrangeHRM.Pages.LoginPage;
import OrangeHRM.Pages.ResetPasswordPage;
import OrangeHRM.TestComponents.Retry;
import OrangeHRM.TestComponents.TestComponents;
import OrangeHRM.TestData.DataReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestCaseOne extends TestComponents {

	@Test(dataProvider = "getData", retryAnalyzer=Retry.class)
	public void userLogin(HashMap<String, String> input) throws IOException {

		LoginPage login = goTo();

		String[] validCred = login.retrieveCredentials();

		// LoginPage and ResetPasswordPage scenarios
		login.invalidCredentials(input.get("email"), input.get("password"));
		ResetPasswordPage rpp = login.forgotPassword();
		rpp.resetPage("test@test.com");
		DashboardPage dashboard = login.userLoginWithValidCredential(validCred[0], validCred[1]);

	}

	@DataProvider
	public Object[][] getData() throws IOException {

		// First Way - just returning the object with all inputs
		// return new Object[][] {{"Mukesh","Mukesh"},{"Admin","admin123"}};

		/*
		 * Second-Way - Creating a haspmap here itself and providing all the inputs
		 * 
		 * HashMap<String, String> map = new HashMap<String, String>(); map.put("email",
		 * "mukesh"); map.put("password", "mukesh");
		 * 
		 * HashMap<String, String> map1 = new HashMap<String, String>();
		 * map1.put("email", "Admin"); map1.put("password", "admin123");
		 * 
		 * 
		 * return new Object[][] {{map},{map1}};
		 */

		// Third-way getting the input data from JSON

		DataReader dataReader = new DataReader();
		List<HashMap<String, String>> data = dataReader
				.getDataJson(System.getProperty("user.dir") + "\\src\\test\\java\\OrangeHRM\\TestData\\testData.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}

}
