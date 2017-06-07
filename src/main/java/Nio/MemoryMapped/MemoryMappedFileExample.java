package Nio.MemoryMapped;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Andrew  on 2017/4/6.
 */
public class MemoryMappedFileExample {
    static int length = 1000; // 128 Mb

    public static void main(String[] args) throws Exception
    {
        MappedByteBuffer out = new RandomAccessFile("D:\\test.txt", "rw")
                .getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 9);
        for (int i = 0; i < 3; i++)
        {
            out.put( "黄".getBytes());
        }
        System.out.println("黄".getBytes().length);
        System.out.println("Finished writing");
    }
}
