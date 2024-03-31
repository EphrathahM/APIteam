package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



	//@RunWith(Cucumber.class) //Junit execution

	@CucumberOptions(
			/*plugin = {"pretty","json:target/MyReports/cucumber.json","html:target/API_Pros.html"
					//"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
					//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
					
					},*/ //reporting purpose
			monochrome=false,  //console output color
			//tags = "@HomePage or @RegisterTS01 or @LoginTS02 or @DataStructuresTS03 or @stackFeature or @queueFeature or @Array or @LinkedList", //tags from feature file
			features = {"src/test/resources/featurefiles/UserLogin.feature"}, //location of feature files
			glue= {"StepDefinition",},
			publish=true
			) //location of step definition files
	
	
	public class TestRunner extends AbstractTestNGCucumberTests {
		
		@Override
	    @DataProvider(parallel = false)
	    public Object[][] scenarios() {
					
			return super.scenarios();
	    }
}
