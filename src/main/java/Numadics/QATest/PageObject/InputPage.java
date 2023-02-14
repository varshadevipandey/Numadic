package Numadics.QATest.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class InputPage {
	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();

		
		public InputPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		    
		@FindBy(id="cw-submit-btn")
		WebElement Submit;
				
		@FindBy(xpath="//div[@class='lyteDummyEventContainer']")
		WebElement Genderdropdown;
		
		@FindBy(xpath="//*[@data-value=\"Mrs.\"]")
		WebElement Mrs;
		
		@FindBy(xpath="//span[@data-zcqa=\"First_NameError\"]")
		WebElement FirstNameError;
		
		@FindBy(id="rec-form_53264000000003149")
		WebElement EnterName;
		

		
		public void ClickSubmit() {
			Submit.click();
			
		}
		
		public void SelectGender() {
			Genderdropdown.click();
			Mrs.click();
		}
		
		public void Userdetails(String Name) {
			
			String Error = FirstNameError.getText();
			softAssert.assertEquals(Error, "First Name cannot be empty.");
			EnterName.sendKeys(Name);

			
		}
		




}
