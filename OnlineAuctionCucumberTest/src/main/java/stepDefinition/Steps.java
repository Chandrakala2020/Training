package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	
	WebDriver driver;	
	
	 @Given("^Open the Chrome and user navigates to app$")				
	    public void open_the_Chrome_and_launch_the_application() throws Throwable							
	    {		
	        System.out.println("This Step open the Firefox and launch the application.");	
	        
	        System.setProperty("webdriver.chrome.driver", "E://Selenium//Selenium_Jars//chromedriver.exe");					
	        driver= new ChromeDriver();					
	        driver.manage().window().maximize();			
	        driver.get("http://localhost:8080/OnlineProductAuctionSystem/");	
	        driver.findElement(By.xpath("//a[text()='Seller']")).click();
	    }		

	    @When("^Enter the Username and Password$")					
	    public void enter_the_Username_and_Password() throws Throwable 							
	    {		
	       System.out.println("This step enter the Username and Password on the login page.");	
	       driver.findElement(By.name("userName")).sendKeys("Chandrakala");							
	       driver.findElement(By.name("password")).sendKeys("12345");
	    }		

	    @Then("^Create Product page must be visible$")					
	    public void Create_product_page() throws Throwable 							
	    {    		
	        System.out.println("This step click on the Submit button.");	
	        driver.findElement(By.xpath("//input[@value='Submit']")).click();	
	        System.out.println("Homepage should be displayed");
	    }		

}
