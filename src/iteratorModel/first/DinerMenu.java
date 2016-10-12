package iteratorModel.first;

import iteratorModel.first.inter.Iterator;

/**
 * Created by Andrew  on 2016/10/11.
 */
public class DinerMenu {
    static final int MAX_ITEM=6;
    int numberOfItems=0;
    MenuItem[] menuItems;
    public DinerMenu(){
        menuItems=new MenuItem[MAX_ITEM];
        addItem("Vegetarian BIL","Fakin",true,2.99);
        addItem("Bacon BIL","Fakin",true,2.99);
        addItem("Soup BIL","Fakin",true,3.29);
        addItem("Hotdog BIL","Fakin",true,3.09);
    }
    public void addItem(String name,String description,boolean vegetarian,double price){
        MenuItem menuItem=new MenuItem(name,description,vegetarian,price);
        if (numberOfItems>=MAX_ITEM){
            System.out.println("Sorry ,menu is full! Can't add item to menu");
        }else {
            menuItems[numberOfItems]=menuItem;
            numberOfItems++;
        }
    }
    public MenuItem[]getMenuItems(){
        return menuItems;
    }
    public Iterator createIterator(){
        return new DinerMenuItemIterator(menuItems);
    }
}
