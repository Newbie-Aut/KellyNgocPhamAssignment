package loginWebRunner;
import org.junit.runner.RunWith;



import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/KellyFeature", glue = "loginSeleniumGlueCode")

public class LoginTestRunner {

}