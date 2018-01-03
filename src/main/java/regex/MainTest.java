package regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Andrew
 * @date 2018/1/2
 */
public class MainTest {
    @Test
    public void groupTest(){
        String pattern = "\\b([a-z]+)";
        String source = "Is is the cost of of gasoline going up up";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(source);

        while (m.find()){
            System.out.println(m.group(1));

        }
    }

    @Test
    public void domainTest(){
        String source = "http://www.runoob.com:80/html/html-tutorial.html";
        String pattern = "(\\w+)://(.+):(\\d*)(.*)";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(source);

        while (m.find()){
            System.out.println(m.group(1));
            System.out.println(m.group(2));
            System.out.println(m.group(3));
            System.out.println(m.group(4));

        }
    }

    @Test
    public void aheadTest(){
        String source = "Windows2000";
        String pattern = "Windows(?=95|98|NT|2000)";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(source);

        while (m.find()){
            System.out.println(m.group(0));
//            System.out.println(m.group(1));

        }
    }
}
