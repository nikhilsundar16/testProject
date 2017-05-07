package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class goFormzPostLogin {

	public static void main(String[] args) throws InterruptedException{
	
		System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://manage.goformz.com");
        
        driver.findElement(By.name("username")).sendKeys("nikhilsundar16@gmail.com");
		driver.findElement(By.name("password")).sendKeys("test123");
		driver.findElement(By.cssSelector("#gflogin > div.col-md-7.login-form > form > fieldset > div:nth-child(3) > button")).click();
		    
		//login successful
		Thread.sleep(5000);
		
		//toolbar smoketest
		driver.findElement(By.id("menuFORMCOMPLETIONS")).click();
		
		String formUrl = driver.getCurrentUrl();
		if (formUrl.contentEquals("https://manage.goformz.com/#Form"))
		{
            System.out.println("Test Passed!");
        } 
		else 
		{
            System.out.println("Test Failed"+ formUrl);
        }
		
	   driver.findElement(By.id("menuFORMS")).click();
	   String templateUrl = driver.getCurrentUrl();
		if (templateUrl.contentEquals("https://manage.goformz.com/#Template"))
		{
            System.out.println("Test Passed!");
        } 
		else 
		{
            System.out.println("Test Failed"+ templateUrl);
        }
		
		driver.findElement(By.id("menuREPORTS")).click();
		String reportUrl = driver.getCurrentUrl();
	     if (reportUrl.contentEquals("https://manage.goformz.com/#ReportDatasource"))
		 {
	         System.out.println("Test Passed!");
	     } 
		 else 
		 {
	         System.out.println("Test Failed"+ reportUrl);
	     }
	     
	     driver.findElement(By.id("menuHOME")).click();
	     String dashboardUrl = driver.getCurrentUrl();
		 if (dashboardUrl.contentEquals("https://manage.goformz.com/#Home"))
		  {
		    System.out.println("Test Passed!");
		  } 
		  else 
		  {
		    System.out.println("Test Failed"+ dashboardUrl);
		  }
		 
		 driver.findElement(By.id("menuMORE")).click();
		 driver.findElement(By.id("ext-gen1020")).click();
		 String dataSourcesUrl = driver.getCurrentUrl();
		 if (dataSourcesUrl.contentEquals("https://manage.goformz.com/#DataSource"))
		  {
		    System.out.println("Test Passed!");
		  } 
		  else 
		  {
		    System.out.println("Test Failed"+ dataSourcesUrl);
		  }
		 
		 driver.findElement(By.id("menuMORE")).click();
		 driver.findElement(By.id("ext-gen1021")).click();
		 String appIntegrationsUrl = driver.getCurrentUrl();
		 if (appIntegrationsUrl.contentEquals("https://manage.goformz.com/#Apps"))
		  {
		    System.out.println("Test Passed!");
		  } 
		  else 
		  {
		    System.out.println("Test Failed"+ appIntegrationsUrl);
		  }
		 
		 driver.findElement(By.id("trialdaysleft")).click();
		 String subscriptionUrl = driver.getCurrentUrl();
		 if (subscriptionUrl.contentEquals("https://manage.goformz.com/#Subscription"))
		  {
		    System.out.println("Test Passed!");
		  } 
		  else 
		  {
		    System.out.println("Test Failed"+ subscriptionUrl);
		  }
		 
		 driver.quit();
		 
	}

}
