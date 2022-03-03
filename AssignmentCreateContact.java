package Week2.day1;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentCreateContact {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("http://leaftaps.com/opentaps/control/login");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 
	//Enter UserName and Password Using Id Locator
		 WebElement elementUsername = driver.findElement(By.id("username"));
			elementUsername.sendKeys("Demosalesmanager");
			WebElement elementPassword = driver.findElement(By.id("password"));
			elementPassword.sendKeys("crmsfa");
  //Click submit using class
			WebElement elementLoginButton = driver.findElement(By.className("decorativeSubmit"));
			elementLoginButton.click();
			WebElement elementCRMSFA = driver.findElement(By.linkText("CRM/SFA"));
			elementCRMSFA.click();
	//Click on Contacts & Create Contacts using Partial Text based xpath
			WebElement elementContacts =driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
			elementContacts.click();	
			
			WebElement elementCreateContacts =driver.findElement(By.xpath("//a[contains(text(),'Create')]"));
			elementCreateContacts.click();	
	//Enter FirstName and LastName Field Phonenumber Using id Locator		
			 WebElement elementFirstname = driver.findElement(By.id("firstNameField"));
			 elementFirstname.sendKeys("Saravanan");
				WebElement elementLastName = driver.findElement(By.id("lastNameField"));
				elementLastName.sendKeys("Prakasam");
				
				
				
	//Enter FirstName(Local) & LastName(Local) Field Using id Locator
				WebElement elementLocalFirstname = driver.findElement(By.id("createContactForm_firstNameLocal"));
				elementLocalFirstname.sendKeys("Saravanan");
					WebElement elementLocalLastName = driver.findElement(By.id("createContactForm_lastNameLocal"));
					elementLocalLastName.sendKeys("Prakasam");
					
	//Enter Department and Description Field Using Locator
					WebElement elementDepartment = driver.findElement(By.name("departmentName"));
					elementDepartment.sendKeys("Software Testing");
					
					WebElement elementDescription=driver.findElement(By.id("createContactForm_description"));
					elementDescription.sendKeys ("Software Testing-Associate Test Lead");
					
	//Enter E-mail address  Field Using Locator
					WebElement elementEmail = driver.findElement(By.id("createContactForm_primaryEmail"));
					elementEmail.sendKeys("saravananbtech10.prakasam@gmail.com");
					
   //Select State/Province as NewYork Using Visible Text
					WebElement elementDropdown=driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
				 	Select dropdownvalue=new Select(elementDropdown);
							 	dropdownvalue.selectByVisibleText("New York");
   // Partial attribute based xpath
			WebElement elementCreateContact =driver.findElement(By.xpath("//input[contains(@name,'submitButton')]"));
								elementCreateContact.click();	
								
								WebElement elementEditContact =driver.findElement(By.xpath("//a[@class = 'subMenuButton']"));
								elementEditContact.click();
	 //Clear Description
								WebElement elementClearDescription=driver.findElement(By.id("updateContactForm_description"));
								elementClearDescription.clear();
	//Enter ImportantNote Field using Id locator
								WebElement elementImportantNote = driver.findElement(By.id("updateContactForm_importantNote"));
								elementImportantNote.sendKeys("Learning Selenium Automation in TestLeaf");	
	//Click Update Button
				WebElement elementUpdateContact =driver.findElement(By.xpath("//input[@class = 'smallSubmit']"));
				elementUpdateContact.click();			
	//Get Title oF Resulting Page
						System.out.println("Page Title is:  " + driver.getTitle());
}
}
