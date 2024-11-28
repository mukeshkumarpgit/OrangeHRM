package OrangeHRM.TestNGRunner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java", glue="OrangeHRM/stepDefinitions", 
monochrome=true, plugin= {"html:target/cucumber.html"})

public class TestNGTestRunner {

}
