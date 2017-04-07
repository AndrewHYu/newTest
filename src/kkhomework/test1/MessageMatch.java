package kkhomework.test1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Andrew  on 2017/3/9.
 */
public class MessageMatch {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String[][] messageArray = {
                {"1", "10628888", "xw", "1", "0"},
                {"2", "1062888801", "xw", "0", "0"},
                {"3", "1062888801", "xw1", "0", "1"},
                {"4", "10628888", "01xw", "1", "1"},
                {"5", "10628888", null, "0", "0"},
        };

        System.out.println("指令格式样式：[长号码][空格][内容]");
        String inputContent = in.nextLine();
        String[] inputContentArray = inputContent.split(" ");

        String number = inputContentArray[0];
        String content = inputContentArray[1];
        Map<Integer, String[]> messageMap = MO(content, number, messageArray);
        System.out.println("匹配的结果如下....");
        Iterator<Integer> iterator = messageMap.keySet().iterator();
        while (iterator.hasNext()) {
            int key = iterator.next();
            System.out.println("你匹配的是" + (key + 1) + "行");
            System.out.println(stringToString(messageMap.get(key)));
        }
        if (messageMap.size() == 0) {
            System.out.println("未有匹配结果,输出默认行" + messageArray.length);
            System.out.println(messageArray[messageArray.length - 1].toString());
        }

    }


    private static Map MO(String content, String number, String[][] messageArray) {
        Map<Integer, String[]> messageMap = new HashMap();
        for (int i = 0, b = 0; i < messageArray.length; i++) {
            String[] message = messageArray[i];
            if (message[3].equals("1")) {
                if (message[1].equals(number) && message[4].equals("1") && (message[2] == null || message[2].equals(content))) {
                    messageMap.clear();
                    messageMap.put(i, message);
                    break;
                } else if (message[1].equals(number) && message[4].equals("0") && (message[2] == null || content.indexOf(message[2]) >= 0)) {
                    int f = 1;
                    f = f << 5;
                    if (f > b) {
                        messageMap.clear();
                        messageMap.put(i, message);
                        b = f;
                    }
                }

            } else {
                if (number.indexOf(message[1]) >= 0 && message[4].equals("1") && (message[2] == null || message[2].equals(content))) {
                    int f = 1;
                    f = f << 4;
                    if (f >= b) {
                        messageMap.clear();
                        messageMap.put(i, message);
                        b = f;
                    }
                } else if (message[4].equals("0")) {
                    int f = 1;
                    if (number.indexOf(message[1]) >= 0) {
                        f = f << 2;
                    }
                    if (message[2] == null || content.indexOf(message[2]) >= 0) {
                        f = f << 1;
                    }
                    if (f > b) {
                        messageMap.clear();
                        messageMap.put(i, message);
                        b = f;
                    }
                }
            }
        }
//10628888011 xw1
        return messageMap;
    }
    public static String stringToString(String[] strings){
        String string="";
        for (String s :
                strings) {
            string = string+","+s;
        }
        string = string.replaceFirst(",","");
        return string;
    }
}
