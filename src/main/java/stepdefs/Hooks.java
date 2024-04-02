package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.TestConfiguration;
import webdriver.Driver;

import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Hooks {

    static int total;
    static int passScenario;
    static int failScenario;
    static LinkedHashMap<String, String> map = new LinkedHashMap<>();

    @Before
    public void before(Scenario scenario) {
        Driver.getDriver();
        map.put(scenario.getName(), null);
    }

    @After
    public void cucumberAfter(Scenario scenario) {

        total++;
        if (scenario.isFailed())
            failScenario++;
        else
            passScenario++;

        map.put(scenario.getName(), scenario.getStatus().name());
        Driver.quit();
    }

    @AfterAll
    public static void cucumberAfterAll(){
        int passRatio = 100*passScenario/total;
        int failRatio = 100*failScenario/total;
        System.out.println();
        System.out.println("------------------------------------------------------");
        System.out.println("Tester : " + TestConfiguration.instance().getTestConfiguration().getTesterName());
        System.out.println("TOTAL  : " + total);
        System.out.println("PASSED : " + passScenario + "   %" + passRatio);
        System.out.println("FAILED : " + failScenario + "   %" + failRatio);
        System.out.println();

        AtomicInteger i = new AtomicInteger(1);
        System.out.printf("%-5s%-10s%s\n", "#", "Status", "Scenario Name");
        System.out.printf("%-5s%-10s%s\n", "----", "-------", "---------------------------------------");
        map.forEach((k, v) ->{
            System.out.printf("%-5d%-10s%s\n", i.getAndIncrement(), v, k);
        });
        System.out.println("------------------------------------------------------");
    }

}
