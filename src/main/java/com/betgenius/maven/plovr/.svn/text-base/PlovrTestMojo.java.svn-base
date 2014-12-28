package com.betgenius.maven.plovr;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import com.betgenius.ConfigOperations;
import com.betgenius.DriverType;
import com.betgenius.SeleniumTestAnalyzer;
import com.betgenius.model.TestResult;

@Mojo(name = "test", defaultPhase = LifecyclePhase.TEST)
public class PlovrTestMojo extends AbstractPlovrMojo {

    private static final String PASS_KEY = ", 0 failed.";

    @Component
    private ConfigOperations configOperations;

    @Component
    private SeleniumTestAnalyzer seleniumTestAnalyzer;

    @Parameter(property = "plovr.config.driver", defaultValue = "PHANTOM")
    private DriverType driverType;
    
    @Parameter(property = "plovr.config.displayPort")
    private String displayPort = null; 


    public void execute() throws MojoExecutionException, MojoFailureException {
        List<File> configFiles = getConfigurationFiles();
        startServer(configFiles);


        List<String> configIds = configOperations.getConfigIdsFromFiles(configFiles);
        List<TestResult> testResults = new ArrayList<TestResult>();
        try {
            for (String configId : configIds) {
                testResults.add(seleniumTestAnalyzer.getSummary(configId, driverType,displayPort, getLog()));
            }
        } finally {
            seleniumTestAnalyzer.closeSelenium();
        }
        reportResults(testResults);
    }


    private void reportResults(List<TestResult> results) throws
            MojoFailureException {
        boolean failed = false;
        for (TestResult t : results) {
            String summary = t.getSummary();
            String details = t.getDetails();
            if (summary != null && summary.contains(PASS_KEY)) {
                getLog().info("For " + t.getId());
                getLog().info(summary);
            } else {
                getLog().error("For " + t.getId());
                getLog().error("" + details);
                getLog().error(summary);
                failed = true;
            }
        }

        if (failed) {
            throw new MojoFailureException("There are test failures");
        }

    }


    public void setSeleniumTestAnalyzer(SeleniumTestAnalyzer seleniumTestAnalyzer) {
        this.seleniumTestAnalyzer = seleniumTestAnalyzer;
    }


    public void setDriverType(DriverType driverType) {
        this.driverType = driverType;
    }


    public ConfigOperations getConfigOperations() {
        return configOperations;
    }


    public void setConfigOperations(ConfigOperations configOperations) {
        this.configOperations = configOperations;
    }


}
