package iteratorModel.first;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Andrew  on 2016/10/11.
 */
public class PancakeHouseMenu implements Iterator{
    ArrayList<MenuItem>menuItems;

    public PancakeHouseMenu() {
        this.menuItems = new ArrayList<>();
        addItem("K&B's Pancake Breakfast","Pancakes with friend eggs,sausage",false,2.99);
        addItem("Regular Pancake Breakfast","Pancakes with friend eggs,sausage",false,2.99);
        addItem("Blueberry Pancake Breakfast","Pancakes with friend eggs,sausage",false,3.49);
        addItem("Waffle Pancake Breakfast","Pancakes with friend eggs,sausage",false,3.59);

    }
    public void addItem(String name,String description,boolean vegetarian,double price){
        MenuItem menuItem =new MenuItem(name,description,vegetarian,price);
        menuItems.add(menuItem);
    }
    public ArrayList getMenuItems(){
        return menuItems;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    @Override
    public void remove() {

    }
}

