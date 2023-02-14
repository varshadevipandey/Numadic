package Numadics.QATest.PageObject;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class QAPage {
WebDriver driver;
SoftAssert softAssert = new SoftAssert();

	
	public QAPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	    
	@FindBy(xpath="//div[@class=\"cw-jobheader-info\"]/p[1]")
	WebElement FirstHalfTitle;
	
	@FindBy(xpath="//div[@class=\"cw-jobheader-info\"]/h1")
	WebElement SecondHalfTitle;
	
	@FindBy(id="detail-page-applybtn")
	WebElement Interested;
	
	
	public void VerifyQAPage() throws InterruptedException {
		try {
			String firsthalf = FirstHalfTitle.getText();		
			String QAPageTitle = firsthalf.concat(" ") + SecondHalfTitle.getText();

			softAssert.assertEquals(QAPageTitle, "Numadic Iot Pvt. Ltd. | Full time QA Enginr");	
			Assert.assertEquals(Interested.getText(), "I'm interested");
			Interested.click();
			Thread.sleep(5000);
			}
			catch(NoSuchElementException e) {	
				e.printStackTrace();
			}
		softAssert.assertAll();
	}
}
