package pagepkg;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basepkg.CuraHealthBaseClass;

public class CuraHealthPageClass extends CuraHealthBaseClass{
	@FindBy(xpath="//*[@id=\"top-menu\"]/li[6]/a")
	WebElement login;
	
	@FindBy(xpath="//*[@id=\"top-menu\"]/li[6]/ul/li[1]/a")
	WebElement telemedicine;
	
	
	
	public CuraHealthPageClass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void login() throws InterruptedException		
	{
		Thread.sleep(3000);
		 Actions act=new Actions(driver);
		 act.moveToElement(login).perform();
		 telemedicine.click(); 
	}
	public void values() throws AWTException, InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"input_1_4_3\"]")).sendKeys("Vishal");
		driver.findElement(By.xpath("//*[@id=\"input_1_4_6\"]")).sendKeys("M R");
		driver.findElement(By.xpath("//*[@id=\"choice_1_7_0\"]")).click(); //gender
		
		
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id=\"field_1_5\"]/div/img")).click(); //date picker
		WebElement monthelement= driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]"));
		Select month=new Select(monthelement);
		month.selectByIndex(3);
		WebElement yearelement= driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]"));
		Select year= new Select(yearelement);
		year.selectByValue("2001");
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[5]/a")).click();
		
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id=\"input_1_8\"]")).sendKeys("0000365218890");
		
//		WebElement specialist= driver.findElement(By.xpath("//*[@id=\"input_1_10\"]"));
//		Select value= new Select(specialist);
//		value.selectByValue("Cardiology");
		
		driver.findElement(By.xpath("//*[@id=\"input_1_11\"]")).sendKeys("AKS Health care Centre");//facility name
		driver.findElement(By.xpath("//*[@id=\"input_1_12\"]")).sendKeys("A severe pain on the chest");
		
		driver.findElement(By.xpath("//*[@id=\"gform_browse_button_1_13\"]")).click(); //file select
		fileUpload("C:\\Users\\absha\\Desktop\\Testingfiles\\dropdown_code.png"); //file path
		driver.findElement(By.xpath("//*[@id=\"input_1_18\"]")).sendKeys("Basil"); // requestors name
		driver.findElement(By.xpath("//*[@id=\"input_1_16\"]")).sendKeys("0482563212"); // nursing station phone
		driver.findElement(By.xpath("//*[@id=\"choice_1_21_1\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"input_1_20\"]")).sendKeys("Bennet"); // clinical contact name
		driver.findElement(By.xpath("//*[@id=\"input_1_22\"]")).sendKeys("9078654312"); // clinical contact number
		Thread.sleep(20000);
		driver.findElement(By.xpath("//*[@id=\"gform_submit_button_1\"]")).click(); // submit button
		
	}

	public void fileUpload(String p) throws AWTException {
		StringSelection strselection =new StringSelection(p);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strselection, null);
		
		Robot robot=new Robot();
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
				
		
	}
	public void confirm() 
	{
		String src=driver.getPageSource();
		if(src.contains("Your consult is scheduled"))
		{
			System.out.println("Consultation successful");
		}
		else
		{
			System.out.println("Consultation error");
		}
		
	}
	public void windowhandle() throws Exception
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;

	        // Scroll down by a specific number of pixels (for example, 1000)
	        js.executeScript("window.scrollBy(0, 1000);");
		String parentwindow=driver.getWindowHandle();
		driver.findElement(By.xpath("/html/body/footer/section[1]/div/div[1]/div/div[2]/div/div/span[1]/a/i")).click();//facebook click
		Thread.sleep(9000);
		//driver.findElement(By.xpath("//*[@id=\"mount_0_0_bs\"]/div/div[1]/div/div[5]/div/div/div[1]/div/div[2]/div/div/div/div[1]/div/i")).click();// facebook login info close
		
		driver.switchTo().window(parentwindow);
		
	}


}
