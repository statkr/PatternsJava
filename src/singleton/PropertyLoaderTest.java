package singleton;


import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoaderTest {

    @BeforeClass
    public static void createProperties() throws IOException {
        Properties properties = new Properties();
        properties.setProperty("test_key", "JAVA");
        FileOutputStream out = new FileOutputStream("config.properties");
        properties.store(out, "Ilya Kurganskiy");
        out.close();
    }


    @Test
    public void testSingleLoad() throws Exception {
        PropertyLoader firstInstance = PropertyLoader.getInstance();
        PropertyLoader secondInstance = PropertyLoader.getInstance();
        PropertyLoader thirdInstance = PropertyLoader.getInstance();

        Assert.assertTrue(firstInstance == secondInstance);
        Assert.assertTrue(thirdInstance == secondInstance);
    }

    @Test
    public void testWriting() throws IOException {
        PropertyLoader loader = PropertyLoader.getInstance();
        Properties properties = loader.getProperties();
        properties.list(System.out);
    }
}