package proxy;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Multiplier {


    public Server(int port) throws IOException {
        ServerSocket echoSocket = new ServerSocket(port);
        Socket clientSocket = echoSocket.accept();

        DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

        while (clientSocket.isConnected()) {
            double left = dataInputStream.readDouble();
            double right = dataInputStream.readDouble();
            double result = mul(left, right);
            dataOutputStream.writeDouble(result);
        }
    }

    @Override
    public Double mul(double left, double right) {
        return left * right;
    }
}
