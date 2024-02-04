package genericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplemention implements ITestListener{
	@Override
	public void onStart(ITestContext context) {
		
		System.out.println("Suite Execution Starts");	
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+"Execution Starts");	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	System.out.println(result.getMethod().getMethodName()+"Success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
	System.out.println(result.getMethod().getMethodName()+"Fail");
	System.out.println("Failed due to:"+result.getThrowable());
	WebdriverUtility web=new WebdriverUtility();
	web.captureScreenshot(result.getMethod().getMethodName(),BaseClass.sjutil,BaseClass.sdriver);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	System.out.println(result.getMethod().getMethodName()+"Skipped");
	System.out.println("Skipped due to:"+result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) {
	System.out.println("Suite Execution Terminated");
	}

}
