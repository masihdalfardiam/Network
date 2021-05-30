import java.io.*;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public void runc(int port) {
        try {
            Socket socket = new Socket("localhost", port);
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            byte[] savedmassage = new byte[2048];
            Scanner scanner = new Scanner(System.in);
            while (!(socket.isClosed())) {
                String write = scanner.nextLine();
                out.write(write.getBytes());
                int read = in.read(savedmassage);
                if (read == -1)
                    break;

                System.out.println(new String(savedmassage, 0, read));

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}