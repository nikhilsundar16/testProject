package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class goFormzSampleWorkOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws InterruptedException{
		 
      
		System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://manage.goformz.com");
        
        driver.findElement(By.name("username")).sendKeys("nikhilsundar16@gmail.com");
		driver.findElement(By.name("password")).sendKeys("test123");
		driver.findElement(By.cssSelector("#gflogin > div.col-md-7.login-form > form > fieldset > div:nth-child(3) > button")).click();

		Thread.sleep(5000);
		
		//Sample Work OrderCheck
		driver.findElement(By.id("menuFORMCOMPLETIONS")).click();
		
		Thread.sleep(5000);
		//unable to find static element id or cssSelector to automate click event for sample work order link
		driver.get("https://manage.goformz.com/editor#?id=4c1ab035-a54f-4e8a-a9e7-6677fb379af9");
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("#button-1056-btnIconEl")).click();
		Thread.sleep(1000);
		String selectPages = driver.findElement(By.cssSelector("#component-1083")).getText();
		if (selectPages.contentEquals("Pages"))
		  {
		    System.out.println("Test Passed!");
		  } 
		  else 
		  {
		    System.out.println("Test Failed"+ selectPages);
		  }
		driver.get("https://manage.goformz.com/editor#?id=4c1ab035-a54f-4e8a-a9e7-6677fb379af9");
		Thread.sleep(8000);
		
		driver.findElement(By.cssSelector("#button-1054-btnIconEl")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#button-1054-btnIconEl")).click();
		

		//Form content print: unable to find any test to print
		String test = driver.findElement(By.cssSelector("#input1")).getText();
		System.out.println("This -> " +test);
		
		//Form edit:unable to find static element id or cssSelector to automate click event as element values change on every reload of form
		driver.findElement(By.cssSelector("#button-1031-btnInnerEl")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#menuitem-1036-textEl")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#button-1140-btnInnerEl")).click();
		
		driver.quit();
	}
	

}
