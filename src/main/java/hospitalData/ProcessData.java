package hospitalData;

import ca.uhn.hl7v2.parser.PipeParser;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Andrew
 * @date 2017/11/27
 */
public class ProcessData {
    public static void main(String[] args) throws IOException {
        byte buffer[] = new byte[1024];
        File file = new File("H:\\yydata\\20171106.txt");
        FileInputStream in = new FileInputStream(file);

        int count = 0;
        StringBuilder sb = new StringBuilder();
        while ((count = in.read(buffer)) != -1){
            sb.append(new String(buffer));
        }
        String [] ss = sb.toString().split("(OBX)|(\\r\\n)");
        String regex = "\\|+";
        for (int i = 0; i< ss.length;i++) {
            String s = ss[i];
            if (s.equals(""))
                continue;

            String[] sData = s.split(regex);
            if(sData.length <= 1)
                break;
            switch (i){
                case 0:
                    System.out.println(sData[3]);
                    break;
                case 1:
                    break;
                case 2:
                    System.out.println(sData[1]+" "+sData[2]);
                    break;
                default:
                    System.out.println(sData[1]+" "+sData[2]+" "+sData[3]+" "+sData[4]+" "+sData[5]+" "+sData[6]);
            }
        }

    }

    @Test
    public void RegexTest(){
        String source = "|OBX|4|||||g/ml||";
        String pattern = "\\|([^\\|]+?)(?=\\|)";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(source);

        while (m.find()){
            System.out.println(m.group(1));
        }
    }
}
