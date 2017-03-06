package Nio.up;

import java.io.IOException;

/**
 * Created by Andrew  on 2017/3/2.
 */
public class test8080 {
    public static void main(String[] args) {
        try {
            ServerSocket8080 serverSocket8080=new ServerSocket8080(8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
