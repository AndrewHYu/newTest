package test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Created by Admin on 2016/3/30.
 */
public class TestRagex  {
    public static void main(String[] args)throws PatternSyntaxException
    {
        Scanner in= new Scanner(System.in);
        System.out.println("Enter pattern");
        String patternString = in.nextLine();

        Pattern pattern=Pattern.compile(patternString);

        while(true)
        {
            System.out.println("Enter String to match:");
            String input=in.nextLine();
            if (input==null||input.equals(""))return;
            Matcher matcher=pattern.matcher(input);
            if(matcher.matches())
            {
                System.out.println("Matcher");
                int g=matcher.groupCount();
                System.out.println(g);
                if(g>0){
                    for (int i=0;i<input.length();i++) {
                        for (int j = 1; j <= g; j++)
                            if (i == matcher.start(j) && i==matcher.end(j))
                                System.out.print("()");
                        for (int j = 1; j <= g; j++)
                            if (i==matcher.start(j)&&i!=matcher.end(j))
                                System.out.print("(");
                        System.out.print(input.charAt(i));
                        for(int j=1;j<=g;j++)
                            if (i+1!=matcher.start(j)&&i+1==matcher.end(j))
                                System.out.print(")");
                    }
                System.out.println();
            }
        }
        else System.out.println("No match");
    }
}
}