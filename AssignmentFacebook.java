package Week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentFacebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://en-gb.facebook.com/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 WebElement elementCreateAccount =driver.findElement(By.xpath("//a[text()='Create New Account']")); 
				 elementCreateAccount.click();
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 //parent-child
				 WebElement elementFirstName = driver.findElement(By.xpath("//input[@name=\"firstname\"]"));
				 elementFirstName.sendKeys ("Saravanan");
				 WebElement elementSurName = driver.findElement(By.xpath("//input[@name=\"lastname\"]"));
				 elementSurName.sendKeys ("TestLeaf");
				 WebElement elementMobileNumber = driver.findElement(By.xpath("//input[@name=\"reg_email__\"]"));
				 elementMobileNumber.sendKeys ("9789968912");
		//Grandparent to Grand Child
				 WebElement elementPassword = driver.findElement(By.xpath("//form[@id='reg']//input[@type='password']"));
				 elementPassword.sendKeys ("TestLeaf@123");
				 
         //select dropdown value
				 WebElement elementDropdown = driver.findElement(By.id("day"));
				 Select dropdownvalue = new Select(elementDropdown);
					dropdownvalue.selectByValue("1");
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Dropdown select by Index
					 WebElement elementDd = driver.findElement(By.id("month"));
					 Select dropdownvalue1 = new Select(elementDd);
					 dropdownvalue1.selectByIndex(3);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));		
	  //Dropdown select 
						WebElement elementDropdown1=driver.findElement(By.id("year"));
					 	Select dropdownvalue2=new Select(elementDropdown1);
						 	dropdownvalue2.selectByValue("1990");
						 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
    //Select Radio Button
						 WebElement elementRadio =driver.findElement(By.xpath("//label[text() = 'Female']"));
						 elementRadio.click();
						
			
				 	

	}

}
