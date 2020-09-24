package options;

import com.cucumber.listener.Reporter;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty","com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		glue = {"stepdefs"},
		tags = {"@Smoke"},
		features = {"src/test/features"})
public class CucumberTests {
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(System.getProperty("user.dir") + "/src/test/java/resources/extent-config.xml"));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	}

}


