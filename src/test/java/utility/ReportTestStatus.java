package utility;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * Created by debabk on 06/09/16.
 */
public final class ReportTestStatus {

    private static ExtentReports extent;

    private ReportTestStatus(){

    }



    public synchronized static ExtentReports getReporter(String filePath) {
        if (extent == null) {
            extent = new ExtentReports(filePath, true);

            extent
                    .addSystemInfo("Host Name", "Demo-Environment")
                    .addSystemInfo("Environment", "QA");
        }

        return extent;
    }

}
