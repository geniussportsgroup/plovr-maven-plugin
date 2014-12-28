package com.betgenius;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.codehaus.plexus.component.annotations.Component;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

@Component(role = DriverProvider.class)
public class DriverProvider {

	public static final int DEFAULT_IMPLICITLY_WAIT_SECS = 10;
	public static final int DEFAULT_PAGE_LOAD_TIMEOUT_SECS = 10;

	public WebDriver getPhantomDriver() {
        System.out.println("getting phantom driver");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability("webSecurityEnabled", true);
		PhantomJSDriver driver = new PhantomJSDriver(capabilities);

		driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICITLY_WAIT_SECS, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(DEFAULT_PAGE_LOAD_TIMEOUT_SECS, TimeUnit.SECONDS);
        return driver;
    }

	public WebDriver getDriver(DriverType driverType, String displayPort) {
        System.out.println("and the driver type is... " + driverType.toString());
		switch (driverType) {
		case CHROME:
			return getChromeDriver();
		case PHANTOM:
			return getPhantomDriver();
		case FIREFOX: 
			return getFirefoxDriver(displayPort); 
		}
		throw new IllegalArgumentException("Supported drivers are CHROME,PHANTOM");
	}

	private WebDriver getFirefoxDriver(String displayPort) {

		FirefoxDriver driver =  null;
		if(displayPort != null){
			FirefoxBinary binary = new FirefoxBinary();
			binary.setEnvironmentProperty("DISPLAY", displayPort);
			driver = new FirefoxDriver(binary,null); 
		}else{
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICITLY_WAIT_SECS, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(DEFAULT_PAGE_LOAD_TIMEOUT_SECS, TimeUnit.SECONDS);
		return driver; 
	}

	/**
	 * For the unstable tests.
	 * 
	 * @return
	 */
	@Deprecated
	public WebDriver getChromeDriver() {
        System.out.println("getting chrome driver, this will end bad.");
		String path = getOsPath();
		File file = new File(path);
		file.setExecutable(true);
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		return new ChromeDriver();
	}

	private String getOsPath() {
		String path = "";
		if (isWindows()) {
			path = "driverbin/windows/chromedriver.exe";
		} else if (isMac()) {
			path = "driverbin/osx/chromedriver";
		} else {
			path = "driverbin/linux/chromedriver";
		}
		return path;
	}

	private boolean isWindows() {
		return System.getProperty("os.name").toLowerCase().contains("windows");
	}

	private boolean isMac() {
		return System.getProperty("os.name").toLowerCase().contains("mac");
	}
}
