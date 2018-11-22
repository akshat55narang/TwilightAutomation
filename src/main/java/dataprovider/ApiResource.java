package dataprovider;

import manager.ConfigFileManager;

public class ApiResource {
    public static final String AUTH_API = ConfigFileManager.getInstance().getConfigFileReader().getAuthApi();
    public static final String USER_API = ConfigFileManager.getInstance().getConfigFileReader().getUserApi();
    public static final String PROJECT_API = ConfigFileManager.getInstance().getConfigFileReader().getProjectApi();
}
