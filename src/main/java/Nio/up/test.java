package Nio.up;

import java.io.IOException;

/**
 * Created by Andrew  on 2017/3/2.
 */
public class test {
    public static void main(String[] args) {
        try {
            ServerSocket8080 serverSocket8099=new ServerSocket8080(8099);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
