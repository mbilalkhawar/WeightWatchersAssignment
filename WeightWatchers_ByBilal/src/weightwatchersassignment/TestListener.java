package weightwatchersassignment;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseClass implements ITestListener {
	TestUtil testUtil = new TestUtil();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test is Starting Up =====> "+ result.getMethod().getMethodName()+"\n");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Executed Successfully =====>  "+ result.getMethod().getMethodName()+"\n");
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		testUtil.captureScreenShot(result.getMethod().getMethodName());	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("When Test is Skipped =====> "+ result.getMethod().getMethodName()+"\n");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Failed But With Success Percentage =====>  "+ result.getMethod().getMethodName()+"\n");
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("On Start =====>  "+ context.getName()+"\n");
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("On Finish =====>  "+ context.getName()+"\n");

		
	}

}
