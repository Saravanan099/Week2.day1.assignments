package Week2.day1;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day2AssignmentLeafGroundDropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

//Select training program using Index
		WebElement IndexDropdown = driver.findElement(By.id("dropdown1"));
		Select dropdownvalue = new Select(IndexDropdown);
		dropdownvalue.selectByIndex(1);
		
//Select training program using Text		 
		WebElement TextDropdown = driver.findElement(By.name("dropdown2"));
		Select dropdownvalue1 = new Select(TextDropdown);
		dropdownvalue1.selectByVisibleText("Selenium");
		
//Select training program using value
		WebElement ValueDropDown = driver.findElement(By.id("dropdown3"));
		Select dropdownvalue2 = new Select(ValueDropDown);
		dropdownvalue2.selectByValue("1");
         
//Get the Number of Dropdown Options:
		
		//Assign and Select the dropdown list element
		Select selectDropdown = new Select(driver.findElement(By.className("dropdown")));
		
		//Get all the option from dropdown list and assign into List
		List<WebElement> listOptionDropdown =selectDropdown.getOptions();
		
		// Count the item dropdown list and assign into integer variable
		int dropdownCount = listOptionDropdown.size();
		
//Print the total count of dropdown list
	         System.out.println("Total Number of Dropdown Options = " + dropdownCount);
	
	         
//Select your Programs 
				driver.findElement(By.xpath("(//div[@class='example']//select)[5]")).sendKeys("Selenium");
		driver.findElement(By.xpath("(//div[@class='example']//select)[6]")).sendKeys("Selenium");
				

	}

}
