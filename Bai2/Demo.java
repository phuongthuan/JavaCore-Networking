package JavaCore.Networking.Bai2;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by PhuongThuan on 9/14/2016.
 */
public class Demo {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6969);
            System.out.println("Đang chờ kết nối ...");
            Socket socket = serverSocket.accept();
            System.out.println("Kết nối thành công !");
            File file = new File("C:\\Users\\PhuongThuan\\Desktop\\demo.txt");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            byte[] buffer = new byte[1024];
            int count;
            while ((count = bufferedInputStream.read(buffer)) > 0) {
                dataOutputStream.write(buffer);
            }
            bufferedInputStream.close();
            dataOutputStream.close();
            System.out.println("Thành công !");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
