package test;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.sleep;

import static utility.DriverManagerUtility.getDriver;

import static utility.DriverManagerUtility.setDesiredCapability;

/**
 * Created by debabk on 02/09/16.
 */
public  class BaseTest {


    protected Map<String,String> environmentMap=new HashMap<String,String>();

    protected ExtentReports report;
    protected ExtentTest test;

    protected WebDriver driver;

    @BeforeTest
    public void testBaseSetUp()  {
        System.out.println("hello");


    }

/*


    protected void startTestReport(String testName){
        report=new ExtentReports("/Users/debabk/Desktop/testexecutionresult.html", true);
        test=report.startTest(testName);
    }

    protected void testPass(){
        test.log(LogStatus.PASS,"step executed success fully");
    }

    protected void testFail(){
        test.log(LogStatus.FAIL,"step execution failed");
    }

    protected void endTest(){
        report.endTest(test);
        report.flush();
    }
    public static void main(String args[]){
        System.out.println(BaseTest.class.getName());
    }
*/

    public HomePage launchAppWithoutLogin(){
        getDriver();
        return new HomePage();
    }



    public BaseTest setBrowserType(String browserName){
        environmentMap.put("browserName", browserName.toLowerCase());

        return this;
    }
    public BaseTest setPlatform(String platform){
        environmentMap.put("platform",platform.toUpperCase());

        return this;
    }
    public BaseTest setPlatform(){
        environmentMap.put("platform", "MAC");

        return this;
    }
    public BaseTest build(){
        setDesiredCapability(environmentMap);
        return this;
    }



}
