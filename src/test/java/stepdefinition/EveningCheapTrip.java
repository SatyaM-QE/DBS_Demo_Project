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
import runner.CucumberRunner;
import utils.GetDataFromProperty;

public class EveningCheapTrip extends CucumberRunner{
	
	public GetDataFromProperty getProp = new GetDataFromProperty();

	@When("^I type \"([^\"]*)\" and \"([^\"]*)\" in From and To textbox for round trip$")
	public void i_type_and_inFrom_and_To_textbox(String source, String destination) throws InterruptedException, IOException  {
		
		driver.navigate().to("https://www.easemytrip.com/");
		//driver.findElement(By.xpath("//li[@class='click-round flig-show']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(getProp.propertyData("fromPlace")))));
		driver.findElement(By.id(getProp.propertyData("fromPlace"))).clear();
		driver.findElement(By.id(getProp.propertyData("fromPlace"))).sendKeys(source);
		Thread.sleep(1000);
		driver.findElement(By.xpath(String.format(getProp.propertyData("fromPlace_Table"), source))).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.id(getProp.propertyData("toPlace"))).clear();
		driver.findElement(By.id(getProp.propertyData("toPlace"))).sendKeys(destination);
		Thread.sleep(1000);
		driver.findElement(By.xpath(String.format(getProp.propertyData("toPlace_Table"), destination))).click();;
		
		driver.findElement(By.id(getProp.propertyData("calender"))).click();
		driver.findElement(By.xpath(getProp.propertyData("departureDate"))).click();
		Thread.sleep(1000);
//		driver.findElement(By.id("rdate")).click();
//		driver.findElement(By.xpath("//li[@id='fiv_4_27/08/2020']")).click();
	}
	
	@Then("^I am sliding slider for evening flight being cheapest and fastest$")
	public void eveningFlightCheapestFastest() throws InterruptedException, IOException {
        Thread.sleep(3000);
        WebElement slider = driver.findElement(By.xpath(getProp.propertyData("timingSlider")));
//       Point location = slider.getLocation();
//        int xPoint = location.getX();
//        int yPoint = location.getY();
//        System.out.println(xPoint);
//        System.out.println(yPoint);
        Actions move = new Actions(driver);
        move.dragAndDropBy(slider, 90, 0).build().perform();
	}
	
	@Then("^I am getting lowest price and fastest duration for evening trip$")
	public void gettingLowestPrice() throws IOException{
		WebElement timing = driver.findElement(By.xpath(getProp.propertyData("fastTime")));
		WebElement duration = driver.findElement(By.xpath(getProp.propertyData("firstDuration")));
        WebElement price = driver.findElement(By.xpath(getProp.propertyData("firstPrice")));
        
		//=========================================================================
        explicitWait(driver.findElement(By.xpath(getProp.propertyData("departSort"))));
        driver.findElement(By.xpath(getProp.propertyData("departSort"))).click();
        
        String depart = driver.findElement(By.xpath(getProp.propertyData("departUpArrow"))).getAttribute("class");
        if(depart.equals("fa arr2 pad-4 fa-long-arrow-up")) {
        	String textOfDuration = timing.getText();
        	System.out.println("Lowest timing of flights is " +textOfDuration);
        }
        else {
        	driver.findElement(By.xpath(getProp.propertyData("departUpArrow"))).click();
        	String textOfDuration = timing.getText();
        	System.out.println("Lowest timing of flights is " +textOfDuration);
        }
        
        //======================================================================
        explicitWait(driver.findElement(By.xpath(getProp.propertyData("durationSort"))));
        driver.findElement(By.xpath(getProp.propertyData("durationSort"))).click();
        
        String attribute = driver.findElement(By.xpath(getProp.propertyData("durationUpArrow"))).getAttribute("class");
        if(attribute.equals("fa dur2 pad-4 fa-long-arrow-up")) {
        	String textOfDuration = duration.getText();
        	System.out.println("Lowest duration of flights is " +textOfDuration);
        }
        else {
        	driver.findElement(By.xpath(getProp.propertyData("durationUpArrow"))).click();
        	String textOfDuration = duration.getText();
        	System.out.println("Lowest duration of flights is " +textOfDuration);
        }
        
        //===========================================================================
        explicitWait(driver.findElement(By.xpath(getProp.propertyData("priceSort"))));
        driver.findElement(By.xpath(getProp.propertyData("priceSort"))).click();
        
        String attribute2 = driver.findElement(By.xpath(getProp.propertyData("priceUpArrow"))).getAttribute("class");
        if(attribute2.equals("fa pri2 pad-4 fa-long-arrow-up")) {
        	String lowestPrice = price.getText();
        	System.out.println("Lowest price of flights is " +lowestPrice);
        }
        else {
        	driver.findElement(By.xpath(getProp.propertyData("priceUpArrow"))).click();
        	String lowestPrice = price.getText();
        	System.out.println("Lowest price of flights is " +lowestPrice);
        }
       
	}
}
