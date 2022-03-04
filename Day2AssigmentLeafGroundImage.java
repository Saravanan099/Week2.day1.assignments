package Week2.day1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Day2AssigmentLeafGroundImage {

	public static void main(String[] args) throws Throwable {
		
		WebDriverManager.chromedriver().setup();
				
				ChromeDriver driver=new ChromeDriver();
								 driver.get("http://leafground.com/pages/Image.html");
				 driver.manage().window().maximize();
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Click on this image to go home page
					driver.findElement(By.xpath("//div[@class='large-6 small-12 columns']/img")).click();
					
					//Click Image Button
					driver.findElement(By.xpath("(//ul[@class='wp-categories-list']//a)[4]")).click();
					
					//Am i Broken Image?
				
					System.out.println(driver.findElement(By.xpath("(//div[@class='row']//img)[2]")).isEnabled());
					System.out.println(driver.findElement(By.xpath("(//div[@class='row']//img)[2]")).getAttribute("src"));
					driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns']//img)[3]")).click();
					
}

		
	}
