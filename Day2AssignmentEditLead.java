package Week2.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import Week2.day1.Assignment1_CreateLead;
public class Day2AssignmentEditLead {
	public static String CompanyName="Maveric Systems";
	
	public static void main(String[] args) throws Throwable {
		
		Assignment1_CreateLead Assign1_Obj=new Assignment1_CreateLead();
		Assign1_Obj.main(null);
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		 driver.get("http://leaftaps.com/opentaps/control/main");
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
			driver.findElement(By.xpath("//a[text()= 'Leads']")).click();
    //Click FindLeads
		    driver.findElement(By.xpath("//a[text()= 'Find Leads']")).click();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	//Enter FirstName 
			WebElement elementFirstname1 = driver.findElement(By.xpath("(//form[@method='POST']//input[@name='firstName'])[3]"));
			elementFirstname1.sendKeys("SARAVANAN");
	//Click FindLeads
			driver.findElement(By.xpath("//button[text()= 'Find Leads']")).click();
						Thread.sleep(3000);
						
    //Click on first resulting lead
					    
			//Object wait;
			//wait.Until(ExpectedConditions.ElementExists(By.xpath("(//div[contains(@class,\\\"partyId\\\")])[2]/a")));
			driver.findElement(By.xpath("(//div[contains(@class,\"partyId\")])[2]/a")).click();
			System.out.println("Page Title is:  " + driver.getTitle());
			
	//Click Edit and change Company name
					driver.findElement(By.xpath("//a[text()= 'Edit']")).click();
				    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				    driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();
				    WebElement elementCompany=driver.findElement(By.id("updateLeadForm_companyName"));
//				    elementCompany.sendKeys("Maveric Systems");
				    elementCompany.sendKeys(CompanyName);
				    
				    								    
//click update
			    WebElement elementUpdateLead =driver.findElement(By.xpath("//input[@class = 'smallSubmit']"));
			    elementUpdateLead.click();
 //Display the changed name appears
			    WebElement elementPrintName =driver.findElement(By.xpath("//span[@id=\"viewLead_companyName_sp\"]"));
			    System.out.println("Changed company name is:  " + elementPrintName.getText());  
			    
//		//Confirm the changed name appears
			    
				
			if (elementPrintName.getText().contains(CompanyName)) {
				System.out.println("Company name updated as expected");
			}else {
				System.out.println("Company name wrongly updated");
			}

		    
         driver.close();

	}	
}
