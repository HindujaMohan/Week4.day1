package Week4.day1;

import java.util.ArrayList;

import java.util.List;



import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Erail {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get(" https://erail.in");
		driver.manage().window().maximize();
		
		WebElement from = driver.findElement(By.id("txtStationFrom"));
		from.clear();
		from.sendKeys("MS");
		Thread.sleep(500);
		from.sendKeys(Keys.TAB);
		WebElement to = driver.findElement(By.id("txtStationTo"));
		to.clear();
		to.sendKeys("MDU");
		from.sendKeys(Keys.TAB);
		driver.findElement(By.id("chkSelectDateOnly")).click();
		int rowSize = driver.findElements(By.xpath("//table//tr")).size();
		int colSize = driver.findElements(By.xpath("//table//tr//th")).size();
		List<String> trainName = new ArrayList<String>();
		for(int i = 1; i<=rowSize; i++ ) {
			for(int j = 1; j<=colSize; j++) {
				String text = driver.findElement(By.xpath("//table//tr[" + i + "]//td[" + j + "]")).getText();
				System.out.println(text);
			}
		}
		
		
	}

}
