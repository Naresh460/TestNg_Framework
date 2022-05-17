package com.utility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;


/**
 * @author nbusireddy
 * This IAnnotationTransformer interface will call every failed test case and will execution again for given number of times.
 */



public class MyTransformerListener implements IAnnotationTransformer {
	
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {		
		
		annotation.setRetryAnalyzer(RetryAnalyzer.class);		
		
	}

}
