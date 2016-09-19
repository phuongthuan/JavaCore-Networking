package demosocket;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PhuongThuan
 */
public class Server {

    static BufferedWriter bw = null;
    static Socket socket = null;
    static BufferedReader br = null;

    /**
     * @param args the command line arguments
     */
    static final int PORT = 6969;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Đang chờ kết nối .............");
            socket = serverSocket.accept();
            System.out.println("Đã kết nối !!");
            System.out.println("==============================");

            //Step 1: Sent message to Client: 
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                        while (true) {
                            String ms = new Scanner(System.in).nextLine();
                            bw.write(ms);
                            bw.newLine();
                            bw.flush();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } finally {
                        try {
                            bw.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }).start();//end Step 1.

            //Step 2: Receive message from Client: 
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String readline = br.readLine();
                System.out.println("Client: " + readline);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                br.close();
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
