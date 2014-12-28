package com.betgenius;

import com.betgenius.model.TestResult;
import com.betgenius.pagemodels.TestResultsPage;
import org.apache.maven.plugin.logging.Log;
import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.component.annotations.Requirement;
import org.openqa.selenium.WebDriver;

import static java.lang.Thread.sleep;

@Component(role = SeleniumTestAnalyzer.class, hint = "selenium")
public class SeleniumTestAnalyzer {

    @Requirement
    private DriverProvider driverProvider;

    private Integer waitTimeForTestFinishSecs = 180;
    private WebDriver driver;


    public TestResult getSummary(String configId, DriverType driverType, String displayPort, Log logger) {
        System.out.println("driver is null, getting one from " + driverProvider.toString());
        if (driver == null) {
            System.out.println("driver is null, getting one from " + driverProvider.getClass().toString());
            driver = driverProvider.getDriver(driverType,displayPort);
        }
        String url = "http://localhost:9810/test/" + configId + "/all";

        logger.info("Navigating to " + url);
        driver.get(url);
        TestResultsPage resultsPage = new TestResultsPage(driver);

        waitForPageToFinishRunningTests(resultsPage);
        return new TestResult(configId, resultsPage.getSummary(), resultsPage.getDetails());
    }


    private void waitForPageToFinishRunningTests(TestResultsPage resultsPage) {
        int i = 0;
        while (!resultsPage.isTestRunFinished() && i < waitTimeForTestFinishSecs) {
            try {
                sleep(1000);
                i++;
            } catch (InterruptedException e) {
                throw new RuntimeException("JVM Interrupted snoozing test analyzer " + e.getMessage());
            }
        }
    }

    public void closeSelenium() {
        if (driver != null) {
            driver.quit();
        }
    }


    public void setDriverProvider(DriverProvider driverProvider) {
        this.driverProvider = driverProvider;
    }

    public void setWaitTimeForTestFinishSecs(Integer waitTimeForTestFinishSecs) {
        this.waitTimeForTestFinishSecs = waitTimeForTestFinishSecs;
    }


}
