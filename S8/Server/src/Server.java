import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {
    public void runs() {
        try {
            ServerSocket server = new ServerSocket(3030);
            Socket socket = server.accept();
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            byte[] buffer = new byte[2048];
            StringBuilder builder = new StringBuilder();
            while (true) {
                int read = in.read(buffer);
                String reading = new String(buffer, 0, read);
                if (reading.equals("over")) {
                    break;
                }
                builder.append(reading + " ");
                out.write(builder.toString().getBytes());

            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}