package Numadics.QATest;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Numadics.QATest.PageObject.CareersPage;
import Numadics.QATest.PageObject.InputPage;
import Numadics.QATest.PageObject.QAPage;

public class Regression {
	
	WebDriver driver = new ChromeDriver();
	SoftAssert softAssert = new SoftAssert();
	JavascriptExecutor js= (JavascriptExecutor)driver;
	
	@BeforeClass
	public void login() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\varsh\\Downloads\\chromedriver\\chromedriver.exe");
		driver.get("https://jobs.numadic.com/jobs/Careers");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.manage().window().maximize();
			
	}
	
	@Test(priority=1)
	public void verifyTitle() throws InterruptedException {
		try {
			Thread.sleep(2000);
			CareersPage cp = new CareersPage(driver);
			cp.VerfiyTitle();	
		}
		catch(NoSuchElementException e){
			e.printStackTrace();		
		}
				
	}
	
	@Test(priority=2)
	public void dropDown() {
		
		js.executeScript("window.scrollBy(0,550)");
		CareersPage cp = new CareersPage(driver);		
		cp.ClickFilter();
		cp.ClickEngineering();
		cp.clickQALink();
		
		}
	
	
	@Test(priority=4)
	public void qaPage() throws InterruptedException {
		
		QAPage qa = new QAPage(driver);
		qa.VerifyQAPage();		
	}
	
	
	//@Parameters({"Street","City","State","Pin","Country","OrgName","Skill"})
	@Test(priority=5 ,dataProvider="UserInfo")
	public void validations(String Name,String LastName, String Email, String Number)  throws InterruptedException {
		js.executeScript("window.scrollBy(0,2500)");
		InputPage ip = new InputPage(driver);
		Thread.sleep(1000);	
		ip.ClickSubmit();
		Thread.sleep(1000);	

		ip.SelectGender();

		ip.Userdetails(Name);

		softAssert.assertEquals(driver.findElement(By.xpath("//span[@data-zcqa=\"Last_NameError\"]")).getText(), "Last Name cannot be empty.");
		driver.findElement(By.id("rec-form_53264000000003151")).sendKeys(LastName);
		softAssert.assertEquals(driver.findElement(By.xpath("//span[@data-zcqa=\"EmailError\"]")).getText(), "Email cannot be empty.");
		driver.findElement(By.id("rec-form_53264000000003155")).sendKeys(Email);
		softAssert.assertEquals(driver.findElement(By.xpath("//span[@data-zcqa=\"MobileError\"]")).getText(), "Mobile cannot be empty.");
		driver.findElement(By.id("rec-form_53264000000003161")).sendKeys(Number);
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		driver.findElement(By.id("rec-form_53264000000003169")).sendKeys("Kadepathar road");
		driver.findElement(By.id("rec-form_53264000000003171")).sendKeys("Pune");
		js.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.id("rec-form_53264000000003173")).sendKeys("Maharashtra");
		driver.findElement(By.id("rec-form_53264000000003175")).sendKeys("412303");
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.id("rec-form_53264000000003177")).sendKeys("India");
		js.executeScript("window.scrollBy(0,200)");
		softAssert.assertEquals(driver.findElement(By.xpath("//span[@data-zcqa=\"Current_EmployerError\"]")).getText(), "Current Employer cannot be empty.");
		driver.findElement(By.id("rec-form_53264000000003181")).sendKeys("Roxiler");
		softAssert.assertEquals(driver.findElement(By.xpath("//span[@data-zcqa=\"Current_Job_TitleError\"]")).getText(), "Current Job Title cannot be empty.");
		driver.findElement(By.id("rec-form_53264000000003183")).click();
		driver.findElement(By.xpath("//*[@data-value=\"Fresher\"]")).click();
		softAssert.assertEquals(driver.findElement(By.xpath("(//*[@error-message=\"Skill Set cannot be empty.\"])[1]")).getText(), "Skill Set cannot be empty.");
		driver.findElement(By.id("addSkills")).click();

		driver.findElement(By.id("addSkills")).sendKeys("sel");

		Thread.sleep(2000);
		List<WebElement> options =driver.findElements(By.xpath("//ul[@class=\"skl-suggested-skill\"]/li"));	
		for(WebElement ele :options) {
			String ListOption = ele.getText();
			if(ListOption.contains("selenium")) {
				ele.click();		
				break;
			}
		}
		
		js.executeScript("window.scrollBy(0,800)");
		softAssert.assertEquals(driver.findElement(By.xpath("//span[@data-zcqa=\"Current_CTCError\"]")).getText(), "Current CTC cannot be empty.");
		driver.findElement(By.id("rec-form_53264000000285107")).sendKeys("6.5");
		
		softAssert.assertEquals(driver.findElement(By.xpath("//span[@data-zcqa=\"Expected_CTCError\"]")).getText(), "Expected CTC cannot be empty.");
		driver.findElement(By.id("rec-form_53264000000285115")).sendKeys("10.5");
		
		softAssert.assertEquals(driver.findElement(By.xpath("//span[@data-zcqa=\"Notice_PeriodError\"]")).getText(), "Notice Period (days) cannot be empty.");
		
		softAssert.assertEquals(driver.findElement(By.xpath("//span[@data-zcqa=\"Reason_for_changeError\"]")).getText(), "Reason for change cannot be empty.");
		
		driver.findElement(By.id("rec-form_53264000000279009")).sendKeys(" For Personal growth ");
		js.executeScript("window.scrollBy(0,600)");
		softAssert.assertEquals(driver.findElement(By.xpath("//span[@data-zcqa=\"Why_Join_NumadicError\"]")).getText(), "Why Join Numadic ? cannot be empty.");
		driver.findElement(By.id("rec-form_53264000000279013")).sendKeys("To Learn new technology");
		js.executeScript("window.scrollBy(0,200)");
		
		driver.findElement(By.xpath("//*[@id=\"rec-form_53264000000002559_53264000000201078\"]/div/div/a")).click();
		driver.findElement(By.id("53264000000201080_1_tab")).sendKeys("QA Engineer");
		driver.findElement(By.id("53264000000201082_1_tab")).sendKeys("Roxiler");
		driver.findElement(By.id("53264000000201084_1_tab")).sendKeys("NA");
		js.executeScript("window.scrollBy(0,250)");
		
		driver.findElement(By.id("cxd-53264000000201086_1_from_month")).click();
	    WebElement month = driver.findElement(By.xpath("//*[@id=\"cxdb-53264000000201086_1_from_month\"]/lyte-drop-header/lyte-search/lyte-input/div/input"));
		month.sendKeys("Apr");
		Thread.sleep(1000);
		month.sendKeys(Keys.DOWN, Keys.ENTER);
		driver.findElement(By.id("cxd-53264000000201086_1_from_year")).click();	
		WebElement year =driver.findElement(By.xpath("//*[@id='cxdb-53264000000201086_1_from_year']/lyte-drop-header/lyte-search/lyte-input/div/input"));
		year.sendKeys("2016");
		Thread.sleep(1000);
		year.sendKeys(Keys.DOWN, Keys.ENTER);
		driver.findElement(By.id("53264000000201088_1_tab")).click();
		js.executeScript("window.scrollBy(0,200)");
				
		softAssert.assertEquals(driver.findElement(By.xpath("//span[@data-zcqa=\"$LinkedInError\"]")).getText(), "LinkedIn cannot be empty.");
		driver.findElement(By.id("rec-form_111222333445")).sendKeys("https://www.linkedin.com/in/varshadevi-pandey-55b151184/");
		softAssert.assertEquals(driver.findElement(By.xpath("//*[@error-message='Resume cannot be empty.']")).getText(), "Resume cannot be empty.");

		driver.findElement(By.xpath("//input[@class=\"fileuploadInput  \"]")).sendKeys("C:\\Users\\varsh\\Downloads\\ResumeAK.pdf");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,300)");

		driver.findElement(By.id("cw-submit-btn")).click();
		softAssert.assertAll();				
		
	}
		
	
	@AfterTest
	public void tearDown() {
		driver.quit();	
	}
	
	@DataProvider(name="UserInfo")
    public Object[][] getDataFromDataprovider(){
    return new Object[][] 
    	{
            { "Varsha", "Pandey" ,"Varshapandey@gmail.com","8764567876"}
            
        };

    }

}
