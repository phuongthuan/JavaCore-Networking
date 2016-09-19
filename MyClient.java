package JavaCore.Networking;

/**
 * Created by PhuongThuan on 9/14/2016.
 */

import java.net.*;
import java.io.*;

class MyClient {
    public static void main(String args[]) throws Exception {
        System.out.println("Đang kết nối đến server...");
        Socket s = new Socket("localhost", 3333);
        System.out.println("Kết nối thành công");
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "", str2 = "";
        while (!str.equals("stop")) {
            str = br.readLine();
            dout.writeUTF(str);
            dout.flush();
            str2 = din.readUTF();
            System.out.println("Server says: " + str2);
        }

        dout.close();
        s.close();
    }
}
