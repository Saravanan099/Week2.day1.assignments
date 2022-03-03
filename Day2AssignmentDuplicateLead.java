package Week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2AssignmentDuplicateLead {
	public static String CaptureFirstName;

	public static void main(String[] args) throws Throwable {
		Assignment1_CreateLead Assign1_Obj=new Assignment1_CreateLead();
		Assign1_Obj.main(null);
		
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
//click on Email
		    driver.findElement(By.xpath("(//a[@class='x-tab-right'])[3]")).click();
			Thread.sleep(3000);
			WebElement elementEmail= driver.findElement(By.xpath("//input[@name='emailAddress']"));
			elementEmail.sendKeys("saravananbtech10.prakasam@gmail.com");
//			
		  //Click FindLeads
			WebElement elementFindLeadID= driver.findElement(By.xpath("//button[text()= 'Find Leads']"));
			elementFindLeadID.click();
						Thread.sleep(3000);
		//Capture name of the first Lead
						
						WebElement elementPrintFirstName=driver.findElement(By.xpath("(//div[@class=\"x-grid3-cell-inner x-grid3-col-firstName\"]/a)[1]"));
						CaptureFirstName= elementPrintFirstName.getText();
						System.out.println("First Lead ID is:  " + CaptureFirstName); 
						elementPrintFirstName.click();
						Thread.sleep(3000);
						
		//Click on Duplicate Lead					
						driver.findElement(By.xpath("//a[text()= 'Duplicate Lead']")).click();
						Thread.sleep(1000);
		// //Verify the title as 'Duplicate Lead'
					    WebElement elementPrintName =driver.findElement(By.xpath("//div[text()='Duplicate Lead']"));
					    System.out.println("This Page is:  " + elementPrintName.getText()); 
					    if (driver.getPageSource().contains("Duplicate Lead")) {
							System.out.println("This is Duplicate Lead");
						}else {
							
							System.out.println("This is not Duplicate Lead");
						}
		//Click Create Lead
						driver.findElement(By.xpath("//input[@name='submitButton']")).click();			
		//Confirm the duplicated lead name is same as captured name
						if (driver.getPageSource().contains(CaptureFirstName)) {
							System.out.println("Duplicate Lead same as Captured Name");
						}else {
							
							System.out.println("Duplicate Lead not same as Captured Name");
						}
             driver.close();
	}

}
