package Week2.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Day2AssignmentLeafGroundHyperLinks {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Go to HomePage
		driver.findElement(By.linkText("Go to Home Page")).click();
		
		//Click HyperLink 
		driver.findElement(By.xpath("(//ul[@class='wp-categories-list']//a)[3]")).click();
		
	//	Find where am supposed to go without clicking me
	 System.out.println(driver.findElement(By.linkText("Find where am supposed to go without clicking me?")).getAttribute("href"));
	 
	//Verify am I broken?
 
	System.out.println(driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns']/a)[3]")).getAttribute("href"));
	
	//Go to Home Page (Interact with same link name)
					
	int j=0;
	List<WebElement> LinkNameElements = driver.findElements(By.xpath("//div[@class='large-6 small-12 columns']/a"));
	for (int i = 0; i < LinkNameElements.size(); i++) {
		System.out.println(LinkNameElements.get(i).getAttribute("href"));
		 j=i;
	}

	//How many links are available in this page?
	System.out.println("Total Number of Links available in this Page : "+j);
	
	driver.navigate().to(driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns']/a)[3]")).getAttribute("href"));
	
	}

}
