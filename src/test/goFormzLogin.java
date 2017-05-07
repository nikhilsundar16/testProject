package test;

import java.io.BufferedWriter;		
import java.io.File;		
import java.io.FileWriter;		
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class goFormzLogin {

	 static WebDriver driver;
	
	public static void main(String[] args)throws InterruptedException {
		
		String actualTitle = "";
		String expectedTitle = "GoFormz - Login";
		System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");
		
	    driver = new ChromeDriver();
		driver.get("https://manage.goformz.com");
		
		actualTitle = driver.getTitle();
		if (actualTitle.contentEquals(expectedTitle))
		{
            System.out.println(actualTitle + expectedTitle + " Matched!");
        } 
		else 
		{
            System.out.println(actualTitle + expectedTitle + " Don't match");
        }

		//incorrect login
		String actualMessage = "";
		String expectedMessage = "Error: Invalid username or password";
		
		WebElement loginButtonVisible = driver.findElement(By.cssSelector("#gflogin > div.col-md-7.login-form > form > fieldset > div:nth-child(3) > button")); 
		if (loginButtonVisible.isEnabled()!=true)
		{
		   driver.findElement(By.name("username")).sendKeys("username@gmail.com");
		   driver.findElement(By.name("password")).sendKeys("password");
		   Thread.sleep(1000);
		   loginButtonVisible.click();
		   Thread.sleep(1000);
		   
		   actualMessage = driver.findElement(By.cssSelector("#gflogin > div.col-md-7.login-form > form > div > div > div")).getText();
			if (actualMessage.contentEquals(expectedMessage))
			{
	            System.out.println("Invalid credentials warning message displayed");
	            driver.findElement(By.cssSelector("#username")).clear();
	            driver.findElement(By.name("username")).sendKeys("nikhilsundar16@gmail.com");
	 		    driver.findElement(By.name("password")).sendKeys("test123");
	 		    driver.findElement(By.cssSelector("#gflogin > div.col-md-7.login-form > form > fieldset > div:nth-child(3) > button")).click();
	 		   Thread.sleep(5000);
	 		   
	 		   //login successful
               WebElement welcomeMessage = driver.findElement(By.className("gettingstarted"));
               
               if (welcomeMessage.isDisplayed()!=false)
               {
            	   System.out.println("Pass: Login successful and user in Welcome page");
            	 
            	   driver.get("https://manage.goformz.com");
            	   driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
     	 		   //create file named Cookies to store Login Information
     	 		   File file = new File("cookie.data");							
     	 	        try		
     	 	        {		
     	 	            // Delete old file if exists
     	 				file.delete();		
     	 	            file.createNewFile();			
     	 	            FileWriter fileWrite = new FileWriter(file);							
     	 	            BufferedWriter Bwrite = new BufferedWriter(fileWrite);							
     	 	            // loop for getting the cookie information 		
     	 	            for(Cookie ck : driver.manage().getCookies())							
     	 	            {		
     	 	                Bwrite.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));																									
     	 	                Bwrite.newLine();
     	 	            } 		
     	 	            Bwrite.flush();			
     	 	            Bwrite.close();			
     	 	            fileWrite.close();
     	 	           System.out.println("Cookie created");
     	 	        }
     	 	        catch(Exception ex)					
     	 	        {		
     	 	            ex.printStackTrace();			
     	 	        }		
            	   
               }
               else
               {
            	   System.out.println("Fail: Login unsuccessful");  
               }
               
               
	        } 
			else 
			{
	            System.out.println("Invalid credentials warning message not displayed"+actualMessage);
	        }
		}
		
		else
		{
			System.out.println("Fail: Login button shouldn't be enabled without valid credentials");
		}
		
		driver.close();
		}
	
	}

