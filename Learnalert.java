package Week4.day1;

import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Learnalert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//setup chromeDriver
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
				
				driver.manage().window().maximize();
				driver.switchTo().frame("iFrame");
				

	}

}
