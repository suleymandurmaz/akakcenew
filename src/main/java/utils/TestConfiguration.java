package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.FileReader;

public final class TestConfiguration {
    private static TestConfiguration instance;
    public static String ymlFile = "testconfig.yml";
    private TestConfig config;

    private TestConfiguration() {

        if (System.getProperty("testconfigfile") != null){
            ymlFile = System.getProperty("testconfigfile");
        }

        try {
            FileReader fileReader = new FileReader(ymlFile);
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            config = mapper.readValue(fileReader, TestConfig.class);
        }catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }


    public static TestConfiguration instance() {
        instance = instance == null ? new TestConfiguration() : instance;
        return instance;
    }

    public TestConfig getTestConfiguration() {
        return config;
    }
}
