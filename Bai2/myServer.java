package JavaCore.Networking.Bai2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by PhuongThuan on 9/17/2016.
 */
public class myServer {
    public static void main(String[] args) {
        try {
            System.out.println("Waiting devices " + new Date() + "\n");
            ServerSocket serverSocket = new ServerSocket(2000);
            Socket socket = serverSocket.accept();
            System.out.println("Connected !");
            DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());
            DataInputStream fromClient = new DataInputStream(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fromClient));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//            String message = bufferedReader.readLine();
            String a = "";
            a = fromClient.readUTF();
            String s = br.readLine();
//            System.out.println(message);
            System.out.println(s);
//            File myFile = new File(message);
            bufferedReader.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
