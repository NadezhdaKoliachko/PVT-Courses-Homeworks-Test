import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/MailRuRegistrationForm.features","src/test/resources/MailRuLoginForm.features" }
)
public class MailRuRegistrationFormPageRun {
}