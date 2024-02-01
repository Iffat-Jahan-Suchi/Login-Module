package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Locators extends Base {

	public String url = "https://member.daraz.com.bd/user/login";
	public String url2 = "https://www.daraz.com.bd/";

	@BeforeTest
	public void login() throws InterruptedException {
		driver.get(url2);
		driver.manage().window().maximize();
		Thread.sleep(5000);

		String expectedTitle = "Online Shopping in Bangladesh: Order Now from Daraz.com.bd";
		String actualTitle = driver.getTitle();
		
		SoftAssert soft=new SoftAssert();
		//soft assertion
		soft.assertEquals(actualTitle, expectedTitle);
		Thread.sleep(1000);

		WebElement loc = driver.findElement(By.id("anonLogin"));
		loc.click();
		Thread.sleep(2000);
		soft.assertAll();
	}

	@Test

	public void loginPage() throws InterruptedException {
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		WebElement logemail = driver.findElement(By.xpath("//input[@data-meta='Field']"));
		logemail.sendKeys("bcdn@gmail.ccom");

		WebElement logPass = driver.findElement(By.xpath("(//input[@data-meta='Field'])[2]"));
		logPass.sendKeys("235647");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

}
