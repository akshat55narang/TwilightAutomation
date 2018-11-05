package manager;

import dataprovider.ConfigFileReader;

public class ConfigFileManager {
    private static final ConfigFileManager configFileManager = new ConfigFileManager();
    private ConfigFileReader configFileReader;

    private ConfigFileManager() {
    }

    public static ConfigFileManager getInstance() {
        return configFileManager;
    }

    public ConfigFileReader getConfigFileReader() {
        return (configFileReader == null) ? configFileReader = new ConfigFileReader() : configFileReader;
    }
}
