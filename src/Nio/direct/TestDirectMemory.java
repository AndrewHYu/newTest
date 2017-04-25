package Nio.direct;

import sun.nio.ByteBuffered;
import sun.nio.ch.DirectBuffer;

import java.nio.ByteBuffer;

/**
 * Created by Andrew  on 2017/4/25.
 */
public class TestDirectMemory {
    public static void main(String[] args) {
        ByteBuffer directBuffer = ByteBuffer.allocateDirect(1024);

    }
}
