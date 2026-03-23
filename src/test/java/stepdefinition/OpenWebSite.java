package stepdefinition;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import runner.CucumberRunner;

public class OpenWebSite extends CucumberRunner {

	@Given("^I am on \"(.*?)\" search for flight page$")
	public void verifyTitle(String textPassed) throws Throwable {

		String title = driver.getTitle();
		System.out.println("Title of the application is " + title);

		Assert.assertTrue(title.toUpperCase().contains("EASEMYTRIP"));

	}

}
