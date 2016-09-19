package JavaCore.Networking.Bai3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by PhuongThuan on 9/18/2016.
 */
public class Server {

    public static void main(String[] args) {
        System.out.println("Listening connetion from Client...");
        while (true) {
            try {
                ServerSocket serverSocket = new ServerSocket(5555);
                Socket socket = serverSocket.accept();
                System.out.println("Connected !");
                ObjectOutputStream toClient = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream fromClient = new ObjectInputStream(socket.getInputStream());
                System.out.println("Recieve a Object from Client... ");
                Teacher t = (Teacher) fromClient.readObject();
                System.out.println(t.toString());
                System.out.println("Sent a Object to Client...");
                Teacher tc = new Teacher("Hoanbka", "Cầu giấy", 27);
                toClient.writeObject(tc);
                toClient.flush();
                serverSocket.close();
                System.out.println("Successful!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
