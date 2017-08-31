package resume;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author huangyu
 * @date 2017/8/25
 */
public class Main {
    public static final int CUSTOMS_LIMIT_MONEY_PER_BOX =2000;

    private static int process(List<Model> items,int length,int width,int price ,int height)
    {

        for (int i = 0; i < items.size();i++){
            Model m = items.get(i);
            boolean f = m.length <= length && m.width <= width && m.height <= height &&m.price <= price;
            if (f){
                process(items,length,width,price,height);
                process(items,length - m.length,width - m.width,price - m.price,height - m.height);
            }
        }
        return 1;
    }



    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);
        BoxTemplate boxTemplate = new BoxTemplate();
        boxTemplate.price = CUSTOMS_LIMIT_MONEY_PER_BOX;

        while (scanner.hasNext()){
            boxTemplate.length = scanner.nextInt();
            boxTemplate.width = scanner.nextInt();
            boxTemplate.height = scanner.nextInt();

            int itemNum = scanner.nextInt();
            List<Model> items = new ArrayList<>(itemNum);
            for(int i=0; i<itemNum; i++){
                Model item = new Model();
                item.price = scanner.nextInt();
                item.length = scanner.nextInt();
                item.width = scanner.nextInt();
                item.height = scanner.nextInt();
                items.add(item);
            }
            int boxMinNum = Integer.MAX_VALUE;
//            System.out.println (process(items,boxTemplate));

        }
    }

}
class Model {
    //default 方便使用......
    int price;
    int length;
    int width;
    int height;
    boolean isOk = false;
    public int v(){
        return length * width * height;
    }
}
class BoxTemplate{
    int length;
    int width;
    int height;
    int price;
}
