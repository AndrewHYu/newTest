package iteratorModel.first;

import iteratorModel.first.inter.Iterator;

/**
 * Created by Andrew  on 2016/10/11.
 */
public class Witress {
    PancakeHouseMenu pancakeHouseMenu;
    DinerMenu dinerMenu;
    CafeMenu cafeMenu;
    public Witress(PancakeHouseMenu pancakeHouseMenu,DinerMenu dinerMenu,CafeMenu cafeMenu){
        this.pancakeHouseMenu=pancakeHouseMenu;
        this.dinerMenu=dinerMenu;
        this.cafeMenu=cafeMenu;
    }
    public void print(){
//        Iterator pancakeIterator=pancakeHouseMenu.cr
        Iterator dinnerIterator=dinerMenu.createIterator();
    }
}
