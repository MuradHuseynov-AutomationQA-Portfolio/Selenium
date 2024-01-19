package tests.base;//package tests.base;
//
//import common.CommonActions;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import java.io.File;
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//public class Listener implements ITestListener {
//    private WebDriver driver = CommonActions.createDriver();
//    public void onTestFailure(ITestResult result) {
//        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy MM dd_HH mm"));
//        String screenshotName = result.getTestClass().getName() + "." + result.getMethod().getMethodName() + " " + timestamp;
//        TakesScreenshot ts = (TakesScreenshot) driver;
//        File source = ts.getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(source, new File("build/reports/tests/negativeResults/" + screenshotName + ".png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public void onTestSuccess(ITestResult result) {
//        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy MM dd_HH mm"));
//        String screenshotName = result.getTestClass().getName() + "." + result.getMethod().getMethodName() + " " + timestamp;
//        TakesScreenshot ts = (TakesScreenshot) driver;
//        File source = ts.getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(source, new File("build/reports/tests/positiveResults/" + screenshotName + ".png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
