package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import runners.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
@io.cucumber.junit.CucumberOptions(
        features = "src\\test\\resources\\Features\\UserManagement .feature",
        glue = "steps",
        		  plugin = {"pretty", "html:reports/cucumber-reports.html"},
       monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
