package Week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day2AssignmentDeleteLead {
	public static String CaptureLeadID;
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
		    Thread.sleep(3000);
		    
  //Click and Enter phone number 
		    driver.findElement(By.xpath("//span[text()= 'Phone']")).click();
			Thread.sleep(3000);
			WebElement elementPhoneNumber1= driver.findElement(By.xpath("//input[@name='phoneNumber']"));
			elementPhoneNumber1.sendKeys("9789057612");
			
	
	//Click FindLeads
			WebElement elementFindLeadsID= driver.findElement(By.xpath("//button[text()= 'Find Leads']"));
			elementFindLeadsID.click();
						Thread.sleep(3000);
	//Capture first Lead ID
											
						WebElement elementPrintLeadID=driver.findElement(By.xpath("(//div[@class=\"x-grid3-cell-inner x-grid3-col-firstName\"]/a)[1]"));
						CaptureLeadID= elementPrintLeadID.getText();
						System.out.println("First Lead ID is:  " + CaptureLeadID); 
						
						elementPrintLeadID.click();
						Thread.sleep(3000);
						
	//Click on Delete					
						driver.findElement(By.xpath("//a[text()= 'Delete']")).click();	
	//Click FindLeads
                 driver.findElement(By.xpath("//a[text()= 'Find Leads']")).click();
                // Thread.sleep(3000);
    //Click and Enter Captured LeadID
                 WebElement elementCaptureLeadID = driver.findElement(By.xpath("//input[@name = 'id']"));
                 elementCaptureLeadID.sendKeys(CaptureLeadID);
                      			     			
     			//Click FindLeads
    			WebElement elementFindLeadID= driver.findElement(By.xpath("//button[text()= 'Find Leads']"));
    			elementFindLeadID.click();
    						Thread.sleep(3000);
    			//Verify message "No records to display" in the Lead List
                 
    						if (driver.getPageSource().contains("No records to display")) {
    							System.out.println("Records deleted successfully");
    						}else {
    							
    							System.out.println("Records not deleted");
    						}

    					    
    			         //driver.close();		
											
		
						

	}

}
