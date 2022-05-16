package com.baseclass;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.actiondriver.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base {
	ActionClass action = new ActionClass();
	public static Properties prop;
	public static ExtentReports reprtengine;
	static ExtentSparkReporter sparkreport_all;
	public static ThreadLocal<ExtentTest> extenttest = new ThreadLocal<>();
	//public static ExtentTest extenttest; 
	DateFormat dateFormat_report = new SimpleDateFormat("dd-mm-yyyy h-m-s");
	Date date_report = new Date();
	String filename_report;
	static String subFolder;
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	public static DesiredCapabilities ds = new DesiredCapabilities();

	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}



	@Parameters("browserrname")
	@BeforeMethod (groups = {"Regression","Sanity","Smoke"})
	public void browsersetup(String browserrname, ITestResult result, ITestContext context) throws MalformedURLException {		
		
		switch (browserrname) {
		case "chrome":	
			
//			ds.setBrowserName(browserrname);
//			driver.set(new RemoteWebDriver(new URL("http://192.168.1.5:4444"),ds )); //for Grid
			
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());                                        // for Local

			break;
		case "FireFox":
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
			break; 
		}

		getDriver().get( prop.getProperty("url"));		
	}



	@AfterMethod(groups = {"Regression","Sanity","Smoke"})
	public void tearDown() {
		getDriver().quit();

	}



	@BeforeSuite(groups = {"Regression","Sanity","Smoke"})
	public void loadConfig(ITestContext context) throws IOException {
		DOMConfigurator.configure("log4j.xml");
		prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\configuration\\prop.properties");
		prop.load(ip);
		String docTitile=context.getCurrentXmlTest().getName();
		filename_report = context.getSuite().getName();
		reprtengine = new ExtentReports();			
		sparkreport_all = new ExtentSparkReporter(System.getProperty("user.dir")+"\\ExtentReports\\"+filename_report+"-"+dateFormat_report.format(date_report)+".html");
		sparkreport_all.config().setDocumentTitle(docTitile);
		sparkreport_all.config().setReportName("Naresh");
		sparkreport_all.loadXMLConfig(System.getProperty("user.dir")+"\\extentReport-config.xml");
		reprtengine.attachReporter(sparkreport_all);	  
		reprtengine.setSystemInfo("OS", System.getProperty("os.name"));

	}

	@AfterSuite	(groups = {"Regression","Sanity","Smoke"})
	public void generateReports() throws IOException {		
		reprtengine.flush();
		Desktop.getDesktop().browse(new File(System.getProperty("user.dir")+"\\ExtentReports\\"+filename_report+"-"+dateFormat_report.format(date_report)+".html").toURI());
	}



	public String screenShot(String filename) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir")+"\\Screenshots\\" + filename + "_" + dateName + ".png");	

		try {
			FileUtils.copyFile(source, destination);
		} catch (Exception e) {
			e.getMessage();
		}
		// This new path for jenkins
		//String newImageString = "http://localhost:8080/job/GitFrameWork/ws/FrameWork/Screenshots/"+ filename +"_"+dateName +".png";
		// return newImageString;
		return destination.getAbsolutePath();

	}}
