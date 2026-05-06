package project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectDOBFromDropdown {
	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	        driver.get("http://www.fb.com");
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.findElement(By.linkText("Create new account")).click();
	        driver.findElement(By.id("_R_1cl2p4jikacppb6amH1_")).sendKeys("Krishna");
	        Thread.sleep(1000);
	        driver.findElement(By.id("_R_1kl2p4jikacppb6amH1_")).sendKeys("Ghatamaneni");
	        Thread.sleep(1000);
	        driver.findElement(By.id("_R_6ad8p4jikacppb6amH1_")).sendKeys("9986530211");
	        Thread.sleep(1000);
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"_R_6ad8p4jikacppb6amH1_\"]")));

	        driver.findElement(By.xpath("//*[@id=\"_r_3_\"]/div")).click();
	        driver.findElement(By.xpath("//div[text()='6']")).click();
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//*[@id=\"_r_9_\"]/div")).click();
	        driver.findElement(By.xpath("//div[text()='October']")).click();
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//*[@id=\"_r_f_\"]/div")).click();
	        driver.findElement(By.xpath("//div[text()='2003']")).click();
	        Thread.sleep(1000);

	        WebElement genderDropdown = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//*[text()='Select your gender']")
	            )
	        );

	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", genderDropdown);

	        WebElement gender = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//*[contains(text(), 'Male')]")
	            )
	        );

	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", gender);
	        Thread.sleep(1000);
	       
	        WebElement signUpButton = wait.until(
	            ExpectedConditions.elementToBeClickable(
	                By.xpath("//span[text()='Submit' or text()='Sign Up']")
	            )
	        );
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", signUpButton);

	        
	        WebElement mobileError = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//*[contains(text(),'mobile number') or contains(text(),'Mobile number')]")
	            )
	        );

	        WebElement passwordError = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//*[contains(text(),'password') or contains(text(),'Password')]")
	            )
	        );

	        System.out.println("Mobile Error: " + mobileError.getText());
	        System.out.println("Password Error: " + passwordError.getText());

	       
	        driver.quit();

	}

}
