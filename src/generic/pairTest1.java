package generic;


/**
 * Created by 27032 on 2016/8/21.
 */
public class pairTest1 {
    public static void main(String[]args){
        String[]words={"Marry","had","a","little","lamb"};
        Pair<String>mm=ArrayAlg.minmax(words);
        System.out.println("min = "+mm.getFirst());
        System.out.println("max = "+mm.getSecond());

        //泛型方法
//        String middle=ArrayAlg.getMiddle("John","Q","Public");
        Number middle=ArrayAlg.getMiddle(3.14,1729,0);
        System.out.println(middle);


    }
}
class ArrayAlg{
    public static Pair<String> minmax(String[] a){
        if (a==null||a.length==0)return null;
        String min=a[0];
        String max=a[0];
        for (int i=1;i<a.length;i++){
            if (min.compareTo(a[i])>0)min=a[i];
            if (max.compareTo(a[i])<0)max=a[i];
        }
        return new Pair<>(min,max);
    }
    public static <T> T getMiddle(T...a){
        return a[a.length/2];
    }
    public static <T extends Comparable> T min(T[]a){
        if (a==null||a.length==0)return null;
        T smallest=a[0];
        smallest.toString();
        for (int i=1;i<a.length;i++)
            if (smallest.compareTo(a[i])>0)smallest=a[i];
        return smallest;
    }
}