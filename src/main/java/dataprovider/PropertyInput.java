package dataprovider;

public enum PropertyInput {
    URL("url"),
    BROWSER("browser"),
    TIMEOUT("timeout"),
    EXPLICIT_WAIT("explicit_wait"),
    BASEURI("baseuri"),
    AUTH_API("auth_api"),
    USER_API("user_api"),
    PROJECT_API("project_api"),
    DEFAULT_USERNAME("default_username"),
    DEFAULT_PASSWORD("default_password");

    private String property;

    PropertyInput(String property) {
        this.property = property;
    }

    public String getProperty() {
        return property;
    }

}


