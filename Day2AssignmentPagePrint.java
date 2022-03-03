package Week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day2AssignmentPagePrint {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://acme-test.uipath.com/login");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 
	//Enter UserName and Password Using Id Locator
		 WebElement elementEmail = driver.findElement(By.xpath("//div[@class='controls']/input[@id ='email']"));
		 elementEmail.sendKeys("kumar.testleaf@gmail.com");
			WebElement elementPassword = driver.findElement(By.xpath("//div[@class='controls']/input[@type ='password']"));
			elementPassword.sendKeys("leaf@12");
   //Click login using class
			WebElement elementLoginButton = driver.findElement(By.xpath("//button[@class = 'btn btn-primary']"));
							elementLoginButton.click();
	//Get Title oF Resulting Page
							System.out.println("Page Title is:  " + driver.getTitle());
	// Click logout
				WebElement elementLogout =driver.findElement(By.xpath("//a[contains(text(),'Log Out')]"));
				elementLogout.click();
	//Close the browser
				driver.close();
	}

}
