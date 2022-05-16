package com.utility;

import java.io.IOException;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.actiondriver.ActionClass;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.baseclass.Base;

public class ITestListnerclass extends Base implements ITestListener{
	
	ActionClass action= new ActionClass();
	String path;
	
	
	@Override
	public void onTestStart(ITestResult result) {
		
		Capabilities Browsername = ((HasCapabilities) getDriver()).getCapabilities();
		String Device=Browsername.getBrowserName()+""+Browsername.getBrowserVersion();		
		extenttest.set(reprtengine.createTest(result.getName()));        //use ItestContext to get the name of test from xml file or 
		extenttest.get().assignAuthor("Naresh");
		extenttest.get().assignCategory(Device);
	}
	
	@Override
	public void onTestFailure(ITestResult result) {	
		String path=null;
		try {
			path = screenShot(result.getMethod().getMethodName());
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		//extenttest.get().addScreenCaptureFromPath((path));
		extenttest.get().fail(result.getMethod().getMethodName()+"-->"+"Method is Failed",MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		extenttest.get().fail(result.getThrowable());
		
	}
	@Override
	public  void onTestSkipped(ITestResult result) { 
		extenttest.get().skip(result.getThrowable());
		
		
	}
	@Override
	public  void onTestSuccess(ITestResult result) {     //screenshot for pass test
		String path=null;
		try {
			path = screenShot(result.getMethod().getMethodName());
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		//extenttest.get().addScreenCaptureFromPath((path));
		extenttest.get().pass(result.getMethod().getMethodName()+"-->"+"Methid is Passed",MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	
		

	
}}
