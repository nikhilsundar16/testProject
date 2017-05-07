package test;

import java.io.BufferedReader;		
import java.io.File;		
import java.io.FileReader;		
import java.util.Date;		
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.chrome.ChromeDriver;


public class goFormzDashboard extends goFormzLogin{

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");
        driver = new ChromeDriver();
        
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        
        try{			
            
            File file = new File("cookie.data");							
            FileReader fileReader = new FileReader(file);							
            BufferedReader Buffreader = new BufferedReader(fileReader);							
            String strline;			
            while((strline=Buffreader.readLine())!=null){
            StringTokenizer  Tokenizertoken = new StringTokenizer(strline, ";");									
           
            while(Tokenizertoken.hasMoreTokens()){					
            String name = Tokenizertoken.nextToken();					
            String value = Tokenizertoken.nextToken();					
            String domain = Tokenizertoken.nextToken();					
            String path = Tokenizertoken.nextToken();					
            Date expiry = null;					
            		
            String val;			
            if(!(val=Tokenizertoken.nextToken()).equals("null"))
    		{		
            	expiry = new Date(val);					
            }		
            Boolean isSecure = new Boolean(Tokenizertoken.nextToken()).								
            booleanValue();		
            Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);																	
            driver.manage().addCookie(ck); // This will add the stored cookie to your current session					
            }		
            }		
            }catch(Exception ex){					
            ex.printStackTrace();			
            }		
       
		
	
		
		
		//end of main
		//driver.quit();
	}

	//end of class
}
