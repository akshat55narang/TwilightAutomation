package dataprovider;

import java.io.*;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;
    private static String propertiesPath = "src/main/resources/data.properties";

    public ConfigFileReader() {
        File propertiesFile = new File(propertiesPath);
        String path = propertiesFile.getAbsolutePath();
        System.out.println(path);
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(path))) {
            properties = new Properties();
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if (url != null) {
            return url;
        } else {
            throw new RuntimeException(url + " is Null !");
        }
    }

    public String getBrowser() {
        String browser = properties.getProperty("browser");
        if (browser != null) {
            return browser;
        } else {
            throw new RuntimeException(browser + " is Null !");
        }
    }

    public Long getExplicitWait() {
        String timeOut = properties.getProperty("timeout");
        if (timeOut != null) {
            return Long.parseLong(timeOut);
        } else {
            throw new RuntimeException(timeOut + " is Null !");
        }
    }
}
