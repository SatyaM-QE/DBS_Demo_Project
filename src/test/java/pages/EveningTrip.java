package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import runner.CucumberRunner;

public class EveningTrip extends CucumberRunner {

	public WebElement slider = driver.findElement(By.xpath("//div[@id='hideDiv2']/div/span[1]"));
	
	public WebElement timing = driver.findElement(By.xpath("(//div[@class='row no-margn fltResult ng-scope AC']/div/div/div[2]/span)[1]"));
	public WebElement duration = driver.findElement(By.xpath("(//div[@class='row no-margn fltResult ng-scope AC']/div/div/div[3]/span[1])[1]"));
	public WebElement price = driver.findElement(By.xpath("((//div[@class='row no-margn fltResult ng-scope AC']/div/div/div[5])/div[2]/div[2])[1]"));
	
	public WebElement depart = driver.findElement(By.xpath("//a[@class='arr1']"));
	public WebElement departUpArrow = driver.findElement(By.xpath("//div[@class='row bg-titl-n no-m mar-to-12']/descendant::i[2]"));
	
	public WebElement durationSorting = driver.findElement(By.xpath("//a[@class='dur1']"));
	public WebElement durationUpArrow = driver.findElement(By.xpath("//div[@class='row bg-titl-n no-m mar-to-12']/descendant::i[3]"));
}
