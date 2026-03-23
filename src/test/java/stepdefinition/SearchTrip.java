package stepdefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.SearchPage;
import runner.CucumberRunner;
import utils.GetDataFromProperty;

public class SearchTrip extends CucumberRunner{

	public GetDataFromProperty getProp = new GetDataFromProperty();

	
	@When("^I type \"([^\"]*)\" and \"([^\"]*)\" in From and To textbox$")
	public void i_type_and_inFrom_and_To_textbox(String source, String destination) throws IOException, InterruptedException  {
		
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
	}
	
	@Then("^I click on search button$")
	public void clickOnSearch() throws IOException {
		driver.findElement(By.xpath(getProp.propertyData("searchBtn"))).click();
		//page.searchBtn.click();
	}
	
	@Then("^I am retrieving all fairs$")
	public void getAllFairs() throws IOException {
		List<WebElement> findElements = driver.findElements(By.xpath(getProp.propertyData("flightNames")));
		int size = findElements.size();
		for(int i=0 ; i<=size-1; i++) {
			if(i==0) {
				String flightName = findElements.get(i).getText();
				String symbol = driver.findElement(By.xpath("((//div[@class='row no-margn fltResult ng-scope']/div/div/div[5])/div[2]/div[1])[" +(i+1)+ "]")).getText();
				String fair = driver.findElement(By.xpath("((//div[@class='row no-margn fltResult ng-scope']/div/div/div[5])/div[2]/div[2])[" +(i+1)+ "]")).getText();
				
				System.out.println(flightName + " : " + symbol+fair);
			}
			else {
				String flightName = findElements.get(i).getText();
				String symbol = driver.findElement(By.xpath("((//div[@class='row no-margn fltResult ng-scope']/div/div/div[5])/div[2]/div[1])[" +i+ "]")).getText();
				String fair = driver.findElement(By.xpath("((//div[@class='row no-margn fltResult ng-scope']/div/div/div[5])/div[2]/div[2])[" +i+ "]")).getText();
				
				System.out.println(flightName + " : " + symbol+fair);
			}
			
		}
		
	}
	
	

}
