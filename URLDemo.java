package JavaCore.Networking;

/**
 * Created by PhuongThuan on 9/14/2016.
 */

import java.io.*;
import java.net.*;

public class URLDemo {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://stackoverflow.com/questions/29339933/read-and-write-files-in-java-using-separate-threads");
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host Name: " + url.getHost());
            System.out.println("Port Number: " + url.getPort());
            System.out.println("File Name: " + url.getFile());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
