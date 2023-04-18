package week4.Day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		/*
		 * //Pseudo Code
		 * 
		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 * 
		 * 2. Enter UserName and Password Using Id Locator
		 * 
		 * 3. Click on Login Button using Class Locator
		 * 
		 * 4. Click on CRM/SFA Link
		 * 
		 * 5. Click on contacts Button
		 * 	
		 * 6. Click on Merge Contacts using Xpath Locator
		 * 
		 * 7. Click on Widget of From Contact
		 * 
		 * 8. Click on First Resulting Contact
		 * 
		 * 9. Click on Widget of To Contact
		 * 
		 * 10. Click on Second Resulting Contact
		 * 
		 * 11. Click on Merge button using Xpath Locator
		 * 
		 * 12. Accept the Alert
		 * 
		 * 13. Verify the title of the page
		 */
		
		 ChromeDriver driver=new ChromeDriver();
			
			driver.manage().window().maximize();	
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get("http://leaftaps.com/opentaps/control/login");
			driver.findElement(By.id("username")).sendKeys("DemoCsr");
			WebElement webpass=driver.findElement(By.id("password"));
			webpass.sendKeys("crmsfa");
			driver.findElement(By.className("decorativeSubmit")).click();
			driver.findElement(By.linkText("CRM/SFA")).click();
			
			driver.findElement(By.linkText("Contacts")).click();
			driver.findElement(By.xpath("//a[@href='/crmsfa/control/mergeContactsForm']")).click();
			driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
			
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> allList=new ArrayList<String>(windowHandles);
			
			driver.switchTo().window(allList.get(1));
			driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
			driver.switchTo().window(allList.get(0));
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
			Thread.sleep(3000);
			Set<String> windowHandles1 = driver.getWindowHandles();
			List<String> allList1=new ArrayList<String>(windowHandles1);
			driver.switchTo().window(allList1.get(1));
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();
			Thread.sleep(2000);
			driver.switchTo().window(allList1.get(0));
			driver.findElement(By.linkText("Merge")).click();
			Alert alarm=driver.switchTo().alert();
			alarm.accept();
			Thread.sleep(3000);
			String title = driver.getTitle();
			if(title.contains("View Contact"))
			{
			System.out.println("Title of the WebPage is Verified and it was correct:  "+title);
			}
			else
			{
				System.out.println("Title of the WebPage is Verified and it was not correct:  "+title);
			}
			driver.close();
			
	}

}
