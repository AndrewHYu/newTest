package iteratorModel.first;

import iteratorModel.first.inter.Menu;

import java.util.Hashtable;
import java.util.Iterator;

/**
 * Created by Andrew  on 2016/10/12.
 */
public class CafeMenu implements Menu{
    Hashtable menuItems =new Hashtable();
    public CafeMenu(){
        addItem("K&B's Pancake Breakfast","Pancakes with friend eggs,sausage",false,2.99);
        addItem("Regular Pancake Breakfast","Pancakes with friend eggs,sausage",false,2.99);
        addItem("Blueberry Pancake Breakfast","Pancakes with friend eggs,sausage",false,3.49);
        addItem("Waffle Pancake Breakfast","Pancakes with friend eggs,sausage",false,3.59);
    }
    public void addItem(String name,String description,boolean vegetarian,double price){
        MenuItem menuItem =new MenuItem(name,description,vegetarian,price);
        menuItems.put(menuItem.getName(),menuItem);
    }
    public Hashtable getItems(){
        return menuItems;
    }

    @Override
    public Iterator createIterator() {
        return menuItems.values().iterator();
    }
}
