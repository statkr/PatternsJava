package proxy;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client implements Multiplier , Closeable{

    private final Socket socket;
    private final DataOutputStream output;
    private final DataInputStream input;

    public Client(int port) throws IOException {
        socket = new Socket("localhost", port);
        output = new DataOutputStream(socket.getOutputStream());
        input = new DataInputStream(socket.getInputStream());
    }

    @Override
    public Double mul(double left, double right) {
        try {
            output.writeDouble(left);
            output.writeDouble(right);
            return input.readDouble();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void close() throws IOException {
        socket.close();
    }
}
