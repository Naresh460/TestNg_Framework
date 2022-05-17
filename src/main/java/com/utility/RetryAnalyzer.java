/**
 * 
 */
package com.utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author nbusireddy
 *
 */
public class RetryAnalyzer implements IRetryAnalyzer{
	
	int counter=0;
	int analyzer=3;

	@Override
	public boolean retry(ITestResult result) {
		if(counter<analyzer) {
			counter++;
			return true;			
		}
		return false;
	}

}
