package JavaCore.Networking.Bai3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by PhuongThuan on 9/18/2016.
 */
public class Client {
    public static void main(String[] args) {
        while (true) {
            try {
                Socket socket = new Socket("localhost", 5555);
                System.out.println("Connected to Server !");
                ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream fromServer = new ObjectInputStream(socket.getInputStream());
                System.out.println("Sent a Object to Server...");
                Teacher t = new Teacher("Nguyễn Thị Hằng", "HCM", 30);
                toServer.writeObject(t);
                toServer.flush();
                System.out.println("Successful !!");
                System.out.println("Recieve a Object from Server...");
                Teacher tc = (Teacher) fromServer.readObject();
                System.out.println(tc.toString());
                System.out.println("Successful !!");
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}

