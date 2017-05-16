package serializable.readResolve;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Andrew  on 2017/5/16.
 */
public class Elvis implements Serializable {
    public static final Elvis INSTANCE = new Elvis();
    private Elvis(){}
    private String[] favoriteSongs =
            {"Hound Dog","Heartbreak Hotel"};
    public void printFavorites(){
        System.out.println(Arrays.toString(favoriteSongs));
    }
    private Object readResolve(){
        return INSTANCE;
    }
}
