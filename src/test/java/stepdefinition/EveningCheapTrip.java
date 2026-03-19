package stepdefinition;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.GetDataFromProperty;
import main.CucumberRunner;

public class EveningCheapTrip extends CucumberRunner {

	public GetDataFromProperty getProp = new GetDataFromProperty();

	@When("^I type \"([^\"]*)\" and \"([^\"]*)\" in From and To textbox for round trip$")
	public void i_type_and_inFrom_and_To_textbox(String source, String destination)
			throws InterruptedException, IOException {

		String fromPlace = getProp.propertyData("fromPlace");
		String fromPlace_Table = getProp.propertyData("fromPlace_Table");
		String toPlace = getProp.propertyData("toPlace");
		String toPlace_Table = getProp.propertyData("toPlace_Table");
		String calender = getProp.propertyData("calender");
		String departureDate = getProp.propertyData("departureDate");

		driver.navigate().to("https://www.easemytrip.com/");
		// driver.findElement(By.xpath("//li[@class='click-round flig-show']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(fromPlace))));
		driver.findElement(By.id(fromPlace)).clear();
		driver.findElement(By.id(fromPlace)).sendKeys(source);
		Thread.sleep(1000);
		driver.findElement(By.xpath(String.format(fromPlace_Table, source))).click();
		Thread.sleep(1000);
		driver.findElement(By.id(toPlace)).clear();
		driver.findElement(By.id(toPlace)).sendKeys(destination);
		Thread.sleep(1000);
		driver.findElement(By.xpath(String.format(toPlace_Table, destination))).click();
		;

		driver.findElement(By.id(calender)).click();
		driver.findElement(By.xpath(departureDate)).click();
		Thread.sleep(1000);
//		driver.findElement(By.id("rdate")).click();
//		driver.findElement(By.xpath("//li[@id='fiv_4_27/08/2020']")).click();
	}

	@Then("^I am sliding slider for evening flight being cheapest and fastest$")
	public void eveningFlightCheapestFastest() throws InterruptedException, IOException {

		String timingSlider = getProp.propertyData("timingSlider");
		Thread.sleep(3000);
		WebElement slider = driver.findElement(By.xpath(timingSlider));
//       Point location = slider.getLocation();
//        int xPoint = location.getX();
//        int yPoint = location.getY();
//        System.out.println(xPoint);
//        System.out.println(yPoint);
		Actions move = new Actions(driver);
		move.dragAndDropBy(slider, 90, 0).build().perform();
	}

	@Then("^I am getting lowest price and fastest duration for evening trip$")
	public void gettingLowestPrice() throws IOException {

		String fastTime = getProp.propertyData("fastTime");
		String firstDuration = getProp.propertyData("firstDuration");
		String firstPrice = getProp.propertyData("firstPrice");
		String departSort = getProp.propertyData("departSort");
		String departUpArrow = getProp.propertyData("departUpArrow");
		String durationSort = getProp.propertyData("durationSort");
		String durationUpArrow = getProp.propertyData("durationUpArrow");
		String priceSort = getProp.propertyData("priceSort");
		String priceUpArrow = getProp.propertyData("priceUpArrow");

		WebElement timing = driver.findElement(By.xpath(fastTime));
		WebElement duration = driver.findElement(By.xpath(firstDuration));
		WebElement price = driver.findElement(By.xpath(firstPrice));

		// =========================================================================
		explicitWait(driver.findElement(By.xpath(departSort)));
		driver.findElement(By.xpath(departSort)).click();

		String depart = driver.findElement(By.xpath(departUpArrow)).getAttribute("class");
		if (depart.equals("fa arr2 pad-4 fa-long-arrow-up")) {
			String textOfDuration = timing.getText();
			System.out.println("Lowest timing of flights is " + textOfDuration);
		} else {
			driver.findElement(By.xpath(departUpArrow)).click();
			String textOfDuration = timing.getText();
			System.out.println("Lowest timing of flights is " + textOfDuration);
		}

		// ======================================================================
		explicitWait(driver.findElement(By.xpath(durationSort)));
		driver.findElement(By.xpath(durationSort)).click();

		String attribute = driver.findElement(By.xpath(durationUpArrow)).getAttribute("class");
		if (attribute.equals("fa dur2 pad-4 fa-long-arrow-up")) {
			String textOfDuration = duration.getText();
			System.out.println("Lowest duration of flights is " + textOfDuration);
		} else {
			driver.findElement(By.xpath(durationUpArrow)).click();
			String textOfDuration = duration.getText();
			System.out.println("Lowest duration of flights is " + textOfDuration);
		}

		// ===========================================================================
		explicitWait(driver.findElement(By.xpath(priceSort)));
		driver.findElement(By.xpath(priceSort)).click();

		String attribute2 = driver.findElement(By.xpath(priceUpArrow)).getAttribute("class");
		if (attribute2.equals("fa pri2 pad-4 fa-long-arrow-up")) {
			String lowestPrice = price.getText();
			System.out.println("Lowest price of flights is " + lowestPrice);
		} else {
			driver.findElement(By.xpath(priceUpArrow)).click();
			String lowestPrice = price.getText();
			System.out.println("Lowest price of flights is " + lowestPrice);
		}
	}
}
