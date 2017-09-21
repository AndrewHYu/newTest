package resume;

import java.util.Scanner;

/**
 * @author huangyu
 * @date 2017/9/18
 */
public class Mi {
    public static void main(String[] args) {
        char [] map = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v'
                ,'w','x','y','z'};
        Scanner in  = new Scanner(System.in);
        while (true){
            String s = in.nextLine();
            StringBuilder sb = new StringBuilder();
            char[] sa = s.toCharArray();
            for (int i = 0; i< sa.length;i++){
                sb.append(map[sa[i] - '1']);
            }
            for (int i = 0; i< sa.length;i++){
                sb.append(map[sa[i] - '1']);
            }
            System.out.println(sb.toString());
        }

    }
}
