package com.betgenius;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.apache.maven.plugin.logging.Log;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@RunWith(MockitoJUnitRunner.class)
public class SeleniumTestAnalyzerTest {

	private SeleniumTestAnalyzer analyzer = new SeleniumTestAnalyzer(); 
	
	@Mock
	private DriverProvider driverProvider; 

	@Mock
	private WebDriver webDriver;
	@Mock
	private Log logger; 
	
	@Mock
	private WebElement summaryElement, detailsElement ,finishedElement; 
	
	@Before
	public void setup(){
		analyzer.setDriverProvider(driverProvider); 	
		when(driverProvider.getDriver(DriverType.PHANTOM,null)).thenReturn(webDriver); 
		when(webDriver.findElement(By.cssSelector(".goog-testrunner-progress-summary"))).thenReturn(summaryElement); 
		when(webDriver.findElement(By.cssSelector(".goog-testrunner-report"))).thenReturn(detailsElement); 
		when(summaryElement.getText()).thenReturn("Duration");
	}
	
	@Test
	public void shouldLoadThePlovrTestsPage(){
		analyzer.getSummary("testid",DriverType.PHANTOM,null, logger);
		verify(webDriver).get("http://localhost:9810/test/testid/all");
	}
	
	
	@Test
	public void shouldNotWaitIndefinitelyForTestsToFinish(){ 
		long now = System.currentTimeMillis(); 
		when(finishedElement.getText()).thenReturn("hello");
		analyzer.setWaitTimeForTestFinishSecs(2); 
		analyzer.getSummary("testid",DriverType.PHANTOM ,null,logger);
		assertTrue(System.currentTimeMillis() - now  < 3000 ) ;  
		
	}
	
	

}
