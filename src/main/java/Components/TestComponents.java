package Components;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestComponents {
    public static WebDriver driver;

    public WebDriver initializeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        return driver;
    }

    public void closeDriver() {
        driver.close();
    }

    public static ExtentReports getReportObject(String reportName) {
        String path = System.getProperty("user.dir") + reportName;
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Hotel booking report");
        reporter.config().setDocumentTitle("Test Results");


        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Phanuel");
        return extent;
    }
}
