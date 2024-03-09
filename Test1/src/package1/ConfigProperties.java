package package1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ConfigProperties class loads database configuration from a properties file.
 */
public class ConfigProperties {

    private static final String CONFIG_FILE_PATH = "config.properties";

    /**
     * Loads database configuration properties from the config file.
     *
     * @return Properties object containing the database configuration
     * @throws IOException if an error occurs while reading the config file
     */
    public static Properties loadConfigProperties() throws IOException {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH)) {
            properties.load(fis);
        }
        return properties;
    }
}
