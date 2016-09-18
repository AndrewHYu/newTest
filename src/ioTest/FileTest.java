package ioTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Andrew on 2016/4/13.
 */
public class FileTest {
    public static void main(String[]args) throws FileNotFoundException {
    File file=new File("E:/hh/yu/new.xls");
//        try {
//            file.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    if(!file.exists())
    {
        System.out.println("ss");
        file.mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //FileInputStream fileInputStream=new FileInputStream(file);
    }

    }
}
