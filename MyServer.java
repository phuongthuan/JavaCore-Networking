package JavaCore.Networking;

/**
 * Created by PhuongThuan on 9/14/2016.
 */

import java.net.*;
import java.io.*;
import java.util.Date;

class MyServer {
    public static void main(String args[]) throws Exception {
        ServerSocket ss = new ServerSocket(3333);
        System.out.println("Đang chờ kết nối.." + new Date() + "\n");
        Socket s = ss.accept();
        System.out.println("Đã kết nối");
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "", str2 = "";
        while (!str.equals("thoidi=))")) {
            str = din.readUTF();
            System.out.println("Client: " + str);
            str2 = br.readLine();
            dout.writeUTF(str2);
            dout.flush();
        }
        din.close();
        s.close();
        ss.close();
    }
}
