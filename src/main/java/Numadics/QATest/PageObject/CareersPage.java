package Numadics.QATest.PageObject;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CareersPage {
	
	WebDriver driver;
	
	public CareersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	    
	@FindBy(xpath="//div[@class=\"cw-vTM\"]/div/div/h2")
	WebElement PageTitle;
	
	@FindBy(xpath="//div[@class=\"lyteDummyEventContainer\"]")
	WebElement filter;
	
	@FindBy(id="Lyte_Drop_Body_0")
	List<WebElement> ListOfElements;
	
	@FindBy(id="Lyte_Drop_Item_4")
	WebElement Engineering;
	
	@FindBy(linkText="QA Engineer")
	WebElement QaEngineer;
	
	
	public void VerfiyTitle() {
		String Title = PageTitle.getText();
		Assert.assertEquals(Title, "JOIN OUR CREW");

	}
	
	public void ClickFilter() {
		filter.click();
	}
	
	public void ClickEngineering() {
		try {
		if(ListOfElements.size()>0) {
			Engineering.click();	
			}	
		}catch(NoSuchElementException e) {	
			e.printStackTrace();
		}	
	}
	
	public void clickQALink() {
		QaEngineer.click();
	}

	
	
}
