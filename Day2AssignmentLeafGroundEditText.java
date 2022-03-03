package Week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day2AssignmentLeafGroundEditText {

	public static void main(String[] args) throws Throwable {
	
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		 driver.get("http://leafground.com/pages/Edit.html");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		 //Work with Edit Fields
		driver.findElement(By.xpath("(//label[@for='email'])[2]")).getText();
		 //Enter Email Address
		 WebElement ElementEmailID = driver.findElement(By.id("email"));
//		 ElementEmailID.click();
		 ElementEmailID.sendKeys("SaravananBtech.Prakasam@gmail.com");
		 String EmailValue=ElementEmailID.getAttribute("value");
		 System.out.println("Email ID is:  " + EmailValue);  	
		 
		 
		 //Append Text and press Keyboard Tab
		 WebElement appendTextbox = driver.findElement(By.xpath("(//label[@for='email'])[2]/following-sibling::input"));
		 
		
					 appendTextbox.sendKeys("Saravanan",Keys.TAB);
		 System.out.println("Appended value:"+appendTextbox.getAttribute("value"));
		
		
		//Get default text entered
		 System.out.println(driver.findElement(By.xpath("//label[text()='Get default text entered']/following::input")).getAttribute("value"));
		 Thread.sleep(3000);
		 
		 //Clear the Text
		 WebElement ElementClear = driver.findElement(By.xpath("//label[text()='Clear the text']/following::input"));
		 ElementClear.clear();
		 // System.out.println(driver.findElement("username").getAttribute("value"));
		 
		 System.out.println("Is Enabled "+driver.findElement(By.xpath("//input[@disabled='true']")).isEnabled());
		 
		 
		
	}

}
