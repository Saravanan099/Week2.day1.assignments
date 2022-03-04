package Week2.day1;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Day2AssignmentLeafGroundButton {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("http://leafground.com/pages/Button.html");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			// Click button to travel home page
			driver.findElement(By.id("home")).click();		
			
		driver.findElement(By.xpath("(//a[@class='wp-categories-link maxheight'])[2]")).click();
		
		    //Find position of button (x,y)
			System.out.println("The Posititon - "+driver.findElement(By.id("position")).getLocation());
        
			//Find button color
			System.out.println("The Color "+ driver.findElement(By.id("color")).getCssValue("background-color"));
		
			//Find the height and width
			System.out.println("The Size = "+ driver.findElement(By.id("size")).getSize());
			
			
			
	}

}
	