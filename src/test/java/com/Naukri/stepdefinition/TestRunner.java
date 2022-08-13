package com.Naukri.stepdefinition;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src//test//resources//Features",
	                   glue   = "com.Naukri.stepdefinition",
	                   plugin = "html:target",
	                monochrome= true,
	                dryRun    = false,
	                      tags = {"@test"})

	public class TestRunner {
	
	

}
