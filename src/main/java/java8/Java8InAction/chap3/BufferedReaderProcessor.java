package java8.Java8InAction.chap3;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author Andrew
 * @date 2017/12/5
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader b)throws IOException;
}
