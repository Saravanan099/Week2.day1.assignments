package Week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("http://leaftaps.com/opentaps/control/main");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 
		 WebElement elementUsername = driver.findElement(By.xpath("//input[@name= 'USERNAME']"));				 
		 elementUsername.sendKeys ("Demosalesmanager");	 
	 	WebElement elementPassword = driver.findElement(By.xpath("//input[@name= 'PASSWORD']")); 
		elementPassword.sendKeys ("crmsfa");	
		WebElement elementLogin =driver.findElement(By.xpath("//input[@type= 'submit']")); 
		elementLogin.click();

		WebElement elementSubmit =driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]"));
		elementSubmit.click();
		WebElement elementLeads =driver.findElement(By.xpath("//a[contains(text(),'Leads')]"));
		elementLeads.click();	
		WebElement elementCreateLead =driver.findElement(By.xpath("//a[contains(text(),'Create Lead')]"));
		elementCreateLead.click();	 	 
		WebElement elementCompanyName = driver.findElement(By.id("createLeadForm_companyName"));
		elementCompanyName.sendKeys ("Maveric");	
		WebElement elementFirstName = driver.findElement(By.id("createLeadForm_firstName"));
		elementFirstName.sendKeys ("SARAVANAN");	
		WebElement elementLastName = driver.findElement(By.id("createLeadForm_lastName"));
		elementLastName.sendKeys ("PRAKASAM");	
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys ("IT Testing"); 	 		
		WebElement elementDescription=driver.findElement(By.id("createLeadForm_description"));
			elementDescription.sendKeys ("IT Testing-Associate Test  Lead");
		
	 	driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("saravananbtech10.prakasam@gmail.com");
	 	
//	 	select dropdown value
	 	WebElement elementDropdown=driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
	 	Select dropdownvalue=new Select(elementDropdown);
	 	Thread.sleep(1000);
	 	dropdownvalue.selectByVisibleText("Alabama");
	 	
	 	driver.findElement(By.xpath("//input[@name=\"submitButton\"]")).click();
	 	
	 	WebElement elementEditbutton =driver.findElement(By.xpath("//a[contains(text(),'Edit')]"));
	 	elementEditbutton.click();
	 	WebElement elementDescriptionNew=driver.findElement(By.id("updateLeadForm_description"));
	 	elementDescriptionNew.clear();
	 	
	 	elementDescriptionNew.sendKeys("IT Quality Lead New Role");
	 	driver.findElement(By.xpath("//textarea[@name=\"importantNote\"]")).sendKeys("I'm learning Automation Testing");
	 	
		driver.findElement(By.xpath("//input[@value=\"Update\"]")).click();
		
		System.out.println("Page Title is:  " + driver.getTitle());
		
		
	}

}
