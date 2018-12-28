package dataprovider;

import java.io.*;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;
    private static String propertiesPath = "src/main/resources/data.properties";
    public static final String explicit = "explicit_wait";

    public ConfigFileReader() {
        File propertiesFile = new File(propertiesPath);
        String path = propertiesFile.getAbsolutePath();

        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(path))) {
            properties = new Properties();
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Could not locate Property File");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String propertyName) {
        String value = properties.getProperty(propertyName);
        if (value != null) {
            return value;
        }
        throw new RuntimeException(propertyName + "Not Set !");
    }

    public Long getLongProperty(String propertyName) {
        String value = properties.getProperty(propertyName);
        if (value != null) {
            return Long.parseLong(value);
        }
        throw new RuntimeException(propertyName + "Not Set !");
    }
}
