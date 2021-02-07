package GAZT.GAZT.ADMIN;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Applications extends Setup {
	
@Test
public void Addapp() throws InterruptedException {
	Thread.sleep(6000);
	
	WebElement applications = driver.findElement(By.xpath("/html/body/app-root/div[1]/ijs-layout/div/main/div/section/div/ijs-home/div/div/div[2]/div/div/div/div[7]/gzt-main-navigation/div")); 
	applications.click();
	WebElement name_en = driver.findElement(By.id("applicationNameEn"));
	name_en.sendKeys("Automatedapp");
	
	WebElement name_ar = driver.findElement(By.id("applicationNameAr"));
	name_ar.sendKeys("Automatedapp");
	
	WebElement link = driver.findElement(By.id("applicationLink"));
	link.sendKeys("https://rubygems.org/gems/selenium-webdriver/versions/4.0.0.alpha6");
	
	String image = "gazt.jpg";
	String imagepath= System.getProperty("user.dir")+"/uploads"+image;
	WebElement logo= driver.findElement(By.id("input"));
	logo.sendKeys(imagepath);
	
	WebElement publish = driver.findElement(By.xpath("/html/body/app-root/div[1]/ijs-layout/div/main/div/section/div/ijs-application/div/form/div[2]/div/button[2]")); 
    publish.click();	
    Thread.sleep(3000);
	
	WebElement list = driver.findElement(By.xpath("/html/body/app-root/div[1]/ijs-layout/div/main/div/section/div/ijs-content-management-applications/div[2]/ijs-admin-list/ngx-datatable[1]/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[3]/div/div")); 
	assertEquals(list.getText(),link); 


}
}