package resume;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Andrew  on 2017/7/18.
 */
public class Across {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Long res;
        int dimension_size = Integer.parseInt(in.nextLine().trim());
        List<Long[]> dimList = new ArrayList<Long[]>();

        for (int _dimension_i = 0; _dimension_i < dimension_size; _dimension_i++) {
            Long[] dimension_item = new Long[5];
            String dimItemStr = in.nextLine().trim();
            String[] dimItemStrs = dimItemStr.split(" ");
            for (int j = 0; j < 5; j++) {
                dimension_item[j] = Long.parseLong(dimItemStrs[j]);
            }
            dimList.add(dimension_item);
        }
        res = guessMyPath(dimList);
        System.out.println(res);
    }

    /** 先取出曲率做高的，将剩余点按曲率排序，步长为二分为两份。（分为两份减少其他维度的冲突）
     * 再将分出的两份分别选出，时间最长的；同样的方式分为两份，一共四段
     *
     * 同理对剩下维度进行排序（权值相同可不计较先后。可根据预处理得知某一维度数据波动情况，调整先后）
     * 最后得到一个相对有序序列，计算结果
     * */
    public static long guessMyPath(List<Long[]> dimList){

        return 1L;
    }
}
