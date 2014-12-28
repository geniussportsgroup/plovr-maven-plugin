package com.betgenius.maven.plovr;

import com.betgenius.ConfigOperations;
import com.betgenius.DriverType;
import com.betgenius.SeleniumTestAnalyzer;
import com.betgenius.maven.plovr.PlovrTestMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.File;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlovrTestMojoTest {

    private static final File CONFIG_FILE = new File("src/main/resources/plovr-config.json");

    private static final File CONFIG_DIR = new File("src/main/resources");

    private static final String ID = "id";

    private static final String SUCCESS_REG = ", 0 failed.";

    private PlovrTestMojo mojo = new PlovrTestMojo();

    @Mock
    private SeleniumTestAnalyzer seleniumTestAnalyzer;
    @Mock
    private File mockFile;
    @Mock
    private ConfigOperations configOperations;


    @Before
    public void setup() {
        mojo.setDriverType(DriverType.PHANTOM);

        mojo.setSeleniumTestAnalyzer(seleniumTestAnalyzer);
        mojo.setConfigOperations(configOperations);

        when(configOperations.getConfigIdFromFile(CONFIG_FILE)).thenReturn(ID);
    }


    @Test(expected = MojoFailureException.class)
    public void shouldThrowErrorIfConfigDoesntExist() throws MojoExecutionException, MojoFailureException {
        mojo.configurationDirectories = new File[]{};
        mojo.execute();
    }

//
//    @Test
//    public void shouldGetTestResultsFromSeleniumAnalyzer() throws MojoExecutionException, MojoFailureException {
////        when(seleniumTestAnalyzer.getSummary(ID, DriverType.PHANTOM, mojo.getLog())).thenReturn(new TestResult(ID, SUCCESS_REG, SUCCESS_REG));
//        mojo.execute();
//        verify(seleniumTestAnalyzer).getSummary(ID, DriverType.PHANTOM, mojo.getLog());
//    }
//
//
//    @Test
//    public void shouldCloseSeleniumAnalyzerWhenFinished() throws MojoExecutionException, MojoFailureException {
//
////        when(seleniumTestAnalyzer.getSummary(ID, DriverType.PHANTOM, mojo.getLog())).thenReturn(new TestResult(ID, SUCCESS_REG, SUCCESS_REG));
//        mojo.execute();
//        verify(seleniumTestAnalyzer).closeSelenium();
//    }
//
//    @Test(expected = MojoFailureException.class)
//    public void shouldFailBuildIfTestsFail() throws MojoExecutionException, MojoFailureException {
////        when(seleniumTestAnalyzer.getSummary(ID, DriverType.PHANTOM, mojo.getLog())).thenReturn(new TestResult(ID, "build failure", SUCCESS_REG));
//        mojo.execute();
//    }
}
