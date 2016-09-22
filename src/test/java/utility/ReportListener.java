package utility;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.*;

import static utility.DriverManagerUtility.getDriver;
//import static utility.DriverManagerUtility.driverManager.getDriver;
import static utility.ReportTestStatus.getReporter;

/**
 * Created by debabk on 06/09/16.
 */
public class ReportListener implements ITestListener,ISuiteListener{

    private static ExtentReports extentReporter;
    private ExtentTest extentTest;

    @Override
    public void onTestStart(ITestResult iTestResult) {
        extentTest=extentReporter.startTest(iTestResult.getMethod().getMethodName());


    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        extentTest.log(LogStatus.PASS, "Successfully executed : " + iTestResult.isSuccess());

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        extentTest.log(LogStatus.FAIL,iTestResult.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        extentTest.log(LogStatus.SKIP,"Test Skipped");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        extentReporter.endTest(extentTest);
        getDriver().close();
    }

    @Override
    public void onStart(ISuite iSuite) {
        extentReporter=getReporter("TestResult.html");

    }

    @Override
    public void onFinish(ISuite iSuite) {
        extentReporter.flush();

    }
}
