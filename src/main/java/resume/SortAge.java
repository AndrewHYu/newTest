package resume;

/**
 * @author huangyu
 * @date 2017/9/1
 */
public class SortAge {
    public static void main(String[] args) {
        int[] ages = {9,4,6,7,6};
        ages = sort(ages);
    }
    public static int[] sort(int[]ages){
        int length = ages.length;
        if (length < 0)
            return null;
        final int oldestAge = 99;
        int[] timesAge = new int[oldestAge];

        for (int i = 0;i < length;i++){
            int age = ages[i];
//            if (age < 0 || age > oldestAge)
//                throw new Exception("");
            timesAge[age]++;
        }
        for (int i = 0,index = 0;i < oldestAge;i++){
            for (int j = 0;j < timesAge[i];j++){
                ages[index] = i;
                index++;
            }
        }
        return ages;
    }
}
