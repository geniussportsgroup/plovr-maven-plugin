package com.betgenius.pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class TestResultsPage {

    private SearchContext searchContext;

    public TestResultsPage(SearchContext searchContext) {
        this.searchContext = searchContext;
    }

    public String getSummary() {
        WebElement result = searchContext.findElement(By.cssSelector(".goog-testrunner-progress-summary"));
        return result.getText();
    }

    public String getDetails() {
        WebElement result = searchContext.findElement(By.cssSelector(".goog-testrunner-report"));
        return result.getText();
    }

    public boolean isTestRunFinished() {
        WebElement result = searchContext.findElement(By.cssSelector(".goog-testrunner-progress-summary"));
        return result.getText().contains("Duration");
    }
}
