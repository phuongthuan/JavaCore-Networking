package JavaCore.Networking.Bai1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by PhuongThuan on 9/16/2016.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Đang kết nối đến server ...");
        while (true) {
            try {
                Socket socket = new Socket("localhost", 6969);
                System.out.println("Kết nối thành công đến server !");
                DataInputStream fromServer = new DataInputStream(socket.getInputStream());
                DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());

                //Gửi bán kính đến server:
                System.out.println("Enter radius: ");
                double radius = input.nextDouble();
                toServer.writeDouble(radius);
                toServer.flush();

                //Nhận diện tích hình tròn từ Server:
                double area = fromServer.readDouble();
                System.out.println("Radius is: " + radius);
                System.out.println("Area is: " + area);
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
