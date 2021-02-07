package GAZT.GAZT.ADMIN;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Setup {
	 WebDriver driver ;
		@BeforeTest
	public void Start(){
		

		  String chromedriver = System.getProperty("user.dir")+"\\resources\\chromedriver (1) (1).exe";
		  System.setProperty("webdriver.chrome.driver", chromedriver);
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.navigate().to("http://10.50.15.57:90/login");
		  
	}
		
		@Test
		private void Login() throws InterruptedException {
			Thread.sleep(6000); 
			WebElement username = driver.findElement(By.id("username"));
			username.sendKeys("admin");
			WebElement passowrd = driver.findElement(By.id("password"));
			passowrd.sendKeys("diwan@gazt");
			WebElement lgn= driver.findElement(By.xpath("/html/body/app-root/div[1]/gzt-login/div/div[2]/form/button"));
			lgn.click();
			Thread.sleep(3000); 
			WebElement applications = driver.findElement(By.xpath("/html/body/app-root/div[1]/ijs-layout/div/main/div/section/div/ijs-home/div/div/div[2]/div/div/div/div[7]/gzt-main-navigation/div")); 
			applications.click();
			
			Thread.sleep(8000);
			WebElement addbtn = driver.findElement(By.xpath("/html/body/app-root/div[1]/ijs-layout/div/main/div/section/div/ijs-content-management-applications/div[2]/ijs-list-filter-buttons/div/button")); 
			addbtn.click();
			
			WebElement name_en = driver.findElement(By.id("applicationNameEn"));
			name_en.sendKeys("Automatedapp");
			
			WebElement name_ar = driver.findElement(By.id("applicationNameAr"));
			name_ar.sendKeys("Automatedapp");
			
			WebElement link = driver.findElement(By.id("applicationLink"));
			link.sendKeys("https://rubygems.org/gems/selenium-webdriver/versions/4.0.0.alpha6");
			
			String image = "gazt.jpg";
			String imagepath= System.getProperty("user.dir")+"/uploads/"+image;
			WebElement logo= driver.findElement(By.id("input"));
			logo.sendKeys(imagepath);
			Thread.sleep(4000);
			WebElement publish = driver.findElement(By.xpath("/html/body/app-root/div[1]/ijs-layout/div/main/div/section/div/ijs-application/div/form/div[2]/div/button[2]")); 
		    publish.click();	
		    Thread.sleep(3000);
			
			WebElement list = driver.findElement(By.xpath("/html/body/app-root/div[1]/ijs-layout/div/main/div/section/div/ijs-content-management-applications/div[2]/ijs-admin-list/ngx-datatable[1]/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[3]/div/div")); 
			assertEquals(list.getText(),link); 

		}
	

		
		/*@AfterSuite
	public void End() {
	
		  driver.close();
	}*/

}
