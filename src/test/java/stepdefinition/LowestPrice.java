package stepdefinition;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;
import runner.CucumberRunner;
import utils.GetDataFromProperty;

public class LowestPrice extends CucumberRunner{
	
	public GetDataFromProperty getProp = new GetDataFromProperty();

	@Then("^I am getting lowest price and fastest duration$")
	public void gettingLowestPrice() throws IOException{
		WebElement duration = driver.findElement(By.xpath(getProp.propertyData("fastestDuration")));
        WebElement price = driver.findElement(By.xpath(getProp.propertyData("cheapestTime")));
        
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
