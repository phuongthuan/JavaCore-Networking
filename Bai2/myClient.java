package JavaCore.Networking.Bai2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by PhuongThuan on 9/17/2016.
 */
public class myClient {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Input port (localhost): ");
            int port = input.nextInt();
            if (port == 2000) {
                Socket socket = new Socket("localhost", port);
                System.out.println("Connected to Server !");

                DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
                DataInputStream fromServer = new DataInputStream(socket.getInputStream());
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(toServer));
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Input String: ");
                String s = input.nextLine();
                toServer.writeUTF(s);
                input.nextLine();
                bufferedWriter.flush();
                System.out.println("Messager sent to Server: " + s);


                toServer.close();
                socket.close();
            } else {
                System.out.println("Port not valid !");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
