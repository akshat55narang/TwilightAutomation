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
        }
        throw new RuntimeException(url + " is Null !");
    }

    public String getBrowser() {
        String browser = properties.getProperty("browser");
        if (browser != null) {
            return browser;
        }
        throw new RuntimeException(browser + " is Null !");
    }

    public Long getExplicitWait() {
        String timeOut = properties.getProperty("timeout");
        if (timeOut != null) {
            return Long.parseLong(timeOut);
        }
        throw new RuntimeException(timeOut + " is Null !");
    }

    public String getBaseUri() {
        String baseUri = properties.getProperty("baseuri");
        if (baseUri != null) {
            return baseUri;
        }
        throw new RuntimeException("BaseURI is null !");
    }

    public String getAuthApi() {
        String authApi = properties.getProperty("auth_api");
        if (authApi != null) {
            return authApi;
        }
        throw new RuntimeException("Auth API Url is null !");
    }

    public String getUserApi() {
        String userApi = properties.getProperty("user_api");
        if (userApi != null) {
            return userApi;
        }
        throw new RuntimeException("User API is null !");
    }

    public String getDefaultUser() {
        String username = properties.getProperty("default_username");
        if (username != null) {
            return username;
        }
        throw new RuntimeException("Default User is null !");
    }

    public String getDefaultPassword() {
        String password = properties.getProperty("default_password");
        if (password != null) {
            return password;
        }
        throw new RuntimeException("Default Password is null !");
    }

}
