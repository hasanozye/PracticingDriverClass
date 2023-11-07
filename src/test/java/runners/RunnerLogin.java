package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = {"src/test/resources/features/LoginForScenarioOutline.feature"},
        glue = {"stepdefs"},
        dryRun = false,
        tags = "@SO",
        plugin = {"pretty",
                "html:test-output/report.html"
        }
)
public class RunnerLogin extends AbstractTestNGCucumberTests {

    /*@Parameters("browser")
    @BeforeTest
    public void beforeTest(@Optional("chrome") String browser){
        System.out.println("TestNG xml with cucumber optimization.");
    }
     */
}
