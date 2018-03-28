package adapter;


import org.junit.Test;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class AdapterTest {
    @Test
    public void testWrite() throws IOException {
        StringWriter writer = new Adapter("file.txt");
        writer.write(new String[]{"test","output"});
        DataInputStream stream = new DataInputStream(new FileInputStream("file.txt"));
    }

}