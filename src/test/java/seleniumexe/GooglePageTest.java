package seleniumexe;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GooglePageTest {
	
	private WebDriver driver;
	private WebElement target;
	
	@Before
	public void setupBefore() {
		System.setProperty(
				"webdriver.chrome.driver", 
				"C:\\Users\\Pash\\Documents\\seleniumexe\\src\\main\\resources\\webdriver/chromedriver.exe"
				);
		driver = new ChromeDriver();
//		driver.manage().window().fullscreen(); ////doesn't work
	}
	
	@Test
	public void test1() throws InterruptedException {
		driver.get("https://www.google.com/");
		assertEquals("Google", driver.getTitle());
		//navigate google to images of kittens
		target = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
		target.sendKeys("kittens");
		target.submit();
		
		target = driver.findElement(By.xpath("//*[@id=\"hdtb-msb-vis\"]/div[2]/a"));
		target.click();
		
		Thread.sleep(5000);
	}
	
	@After
	public void setupAfter() {
		driver.close();
	}

}
