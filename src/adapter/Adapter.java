package adapter;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;

public class Adapter implements StringWriter {
    private String fileName;

    public Adapter(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void write(String[] input) throws IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
            for (String line: input) {
                dataOutputStream.writeChars(line);
            }
            dataOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new IOException(e);
        }
    }
}
