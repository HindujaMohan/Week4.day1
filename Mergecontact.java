package Week4.day1;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Mergecontact {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("http://leaftaps.com/opentaps/control/login");
		WebElement eleUserName = driver.findElement(By.id("username"));
		eleUserName.sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();	
		driver.findElement(By.linkText("CRM/SFA")).click();	
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdFrom']/following-sibling::a")).click();
		Set<String> Setwindow1 = driver.getWindowHandles();
		List<String> myWinFromList = new ArrayList<String>(Setwindow1);
		String myParentWindow = myWinFromList.get(0);	
		String myFromWindow = myWinFromList.get(1);
		driver.switchTo().window(myFromWindow);
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).click();
		driver.switchTo().window(myParentWindow);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdTo']/following-sibling::a")).click();
		Set<String> Setwindow2 = driver.getWindowHandles();
		List<String> myWinToList = new ArrayList<String>(Setwindow2);
		String myToWindow = myWinToList.get(1);
		driver.switchTo().window(myToWindow);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();
		driver.switchTo().window(myParentWindow);
		Thread.sleep(5000);		
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(5000);
		driver.switchTo().window(myParentWindow);
		if(driver.getTitle().contains("View Contact | opentaps CRM")){
			System.out.println("Title : " + driver.getTitle());
		}else {
			System.out.println("The title is null");
		} 
		
	}

}
