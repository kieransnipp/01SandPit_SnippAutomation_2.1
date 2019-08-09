package Analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
//ITestListener, ISuiteListener, IReporter,  IAnnotationTransformer, 
//IMethodInterceptor or IInvokedMethodListener
public class RetryAnalyzer implements IRetryAnalyzer {

	int counter = 0;
	int retryLimit = 3;

	@Override
	public boolean retry(ITestResult result) {
		if (counter < retryLimit) {
			counter++;
			return true;

		}//End if

		return false;
	} // End retry

} // End RetryAnalyzer
