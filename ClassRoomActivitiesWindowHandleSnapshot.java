package week4.Day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ClassRoomActivitiesWindowHandleSnapshot {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

//		
//		ClassRoom:
//			1.launch browser
//			2.load url'https://www.irctc.co.in/'
//			3.click on flights
//			4.handle window
//			5.get the title of page & take snap of page
//			6.close current window 
//			7.swtich to first window 
//			8.get the title of page
//			9.quit browser
			
			
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disableNotification");
		ChromeDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.irctc.co.in/");
		
		driver.findElement(By.linkText("FLIGHTS")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> allList=new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(allList.get(1));
		String title = driver.getTitle();
		Thread.sleep(3000);
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./snapshot/rail.png");
		FileUtils.copyFile(source, dest);
		driver.close();
		Thread.sleep(3000);
		driver.switchTo().window(allList.get(0));
		String title2 = driver.getTitle();
		System.out.println("Title of First Window:"+title);
		System.out.println("Title of Second Window:"+title2);
		driver.quit();
	}

}
