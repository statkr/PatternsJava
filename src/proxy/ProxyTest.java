package proxy;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ProxyTest {

    private Client client;


    @Before
    public void runServerAndClient() throws IOException {
        new Thread(() -> {
            try {
                Server server = new Server(5000);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();


        client = new Client(5000);
    }

    @Test
    public void testMul() {
        Assert.assertEquals(200.0, client.mul(20, 10), 0.01);
        Assert.assertEquals(800.0, client.mul(20, 40), 0.01);
    }

    @After
    public void tearDown() throws IOException {
        client.close();
    }
}
