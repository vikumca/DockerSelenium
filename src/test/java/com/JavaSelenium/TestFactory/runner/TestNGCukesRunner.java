package com.JavaSelenium.TestFactory.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/resources/features/GoogleSearch.feature"},
        glue = {"com.JavaSelenium.TestFactory.stepDefinitions"}
)

public class TestNGCukesRunner extends AbstractTestNGCucumberTests {
}