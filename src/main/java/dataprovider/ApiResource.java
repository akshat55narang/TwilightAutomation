package dataprovider;

import manager.ConfigFileManager;

public class ApiResource {
    public static final String AUTH_API = ConfigFileManager.getInstance().getConfigFileReader().getProperty(PropertyInput.AUTH_API.getProperty());
    public static final String USER_API = ConfigFileManager.getInstance().getConfigFileReader().getProperty(PropertyInput.USER_API.getProperty());
    public static final String PROJECT_API = ConfigFileManager.getInstance().getConfigFileReader().getProperty(PropertyInput.PROJECT_API.getProperty());
}
