package JavaCore.Networking.Bai1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by PhuongThuan on 9/16/2016.
 */
public class Server {

    public static void main(String[] args) throws IOException {
        System.out.println("Đang chờ kết nối . . ." + new Date() + "\n");
        while (true) {
            try {
                ServerSocket serverSocket = new ServerSocket(6969);
                Socket socket = serverSocket.accept();
                System.out.println("Kết nối thành công !");
                DataInputStream fromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());

                //Nhận bán kính từ Client:
                double radius = fromClient.readDouble();

                double area = radius * radius * Math.PI;
                //Sau khi tính xong thì gửi trả lại kết quả cho Client:
                toClient.writeDouble(area);

                System.out.println("Recieve radius from Client: " + radius);
                System.out.println("Area is: " + area);

                fromClient.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
