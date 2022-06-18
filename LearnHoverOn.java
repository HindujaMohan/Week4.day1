package Week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnHoverOn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		
		WebElement  mensFashion = driver.findElement(By.xpath("//span[text() = \"Men's Fashion"));
		Actions builder = new Actions(driver);
		builder.moveToElement(mensFashion).perform();
		driver.findElement(By.xpath("//span[(text() = 'Shirts')]")).click();
		WebElement firstShirt = driver.findElement(By.xpath("//div[@class = 'Life Roads - Maroon Cotton Slim Fit Men's Casual Shirt (Pack of 1 )']"));
		builder.moveToElement(firstShirt).perform();
		driver.findElement(By.xpath("//div[contains(text() 'Quick View')]"));
			
	}

}
