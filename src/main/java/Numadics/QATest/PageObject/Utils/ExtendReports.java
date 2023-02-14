package Numadics.QATest.PageObject.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReports {
	
	public static ExtentReports extendReportsObject() {
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Varsha");
		reporter.config().setDocumentTitle("Numadic Test SCript");	
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Testing", "Varsha");
		extent.createTest(path);
		return extent;
		
	}

}
