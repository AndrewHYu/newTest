package java8.Java8InAction.chap3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Andrew
 * @date 2017/12/5
 */
public class ExecuteAround {
    public static void main(String[] args) throws IOException {
/*        String oneLine = processFile((BufferedReader b) -> b.readLine());
        System.out.println(oneLine);*/

        int portNumber = 1337;
        Runnable r = () ->{
            System.out.println(portNumber);
        };
//        portNumber = 3232;

        List<String> str = Arrays.asList("a","b","A","B");
        str.sort(String::compareToIgnoreCase);
    }
    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("lambdasinaction/chap3/data.txt"))) {
            return p.process(br);
        }
    }
}
