package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilities.Driver;

public class Hooks {
    @Before
    public void testSetUp(Scenario scenario) {
        System.out.println(scenario.getName() + " is started!");
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println(scenario.getName() + "status is: " + scenario.getStatus());
        Driver.quitDriver();
    }
}