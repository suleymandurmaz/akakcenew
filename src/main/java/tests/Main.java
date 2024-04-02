package tests;

import org.testng.TestNG;

public class Main {


    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        testNG.setTestClasses(new Class[]{Runner.class});
        testNG.run();
    }

    /*
    public static void main(String[] args) {
        TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();
        suites.add("src/test/resources/xmlFiles/testng.xml");
        testng.setTestSuites(suites);
        testng.run();
    }
     */

    /*
    public static void main2(String[] args) {
        XmlSuite suite = new XmlSuite();
        suite.setName("MovitaSuite");
        suite.setParallel(XmlSuite.ParallelMode.TESTS);
        suite.setThreadCount(2);

        XmlTest test1 = new XmlTest(suite);
        test1.setName("Test1");
        test1.setParameters(new HashMap<>(Map.of("browser","chrome")));
        List<XmlClass> classes1 = new ArrayList<>();
        classes1.add(new XmlClass("test.Runner"));
        test1.setXmlClasses(classes1);

        XmlTest test2 = new XmlTest(suite);
        test2.setName("Test2");
        test2.setParameters(new HashMap<>(Map.of("browser","edge")));
        List<XmlClass> classes2 = new ArrayList<>();
        classes2.add(new XmlClass("test.Runner"));
        test2.setXmlClasses(classes2);

        List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);
        TestNG tng = new TestNG();
        tng.setXmlSuites(suites);
        tng.run();
    }
     */



}
