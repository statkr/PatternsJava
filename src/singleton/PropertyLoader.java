package singleton;

import java.io.*;
import java.util.Properties;

public class PropertyLoader {
    private static PropertyLoader instance;
    private Properties properties;

    public static synchronized PropertyLoader getInstance() throws IOException {
        if (instance == null) {
            instance = new PropertyLoader();
        }
        return instance;
    }

    private PropertyLoader() throws IOException {
        properties = load();
    }

    private Properties load() throws IOException {
        Properties properties = new Properties();
        InputStream in = new FileInputStream("config.properties");
        properties.load(in);
        in.close();
        return properties;
    }

    public Properties getProperties() {
        return properties;
    }
}
