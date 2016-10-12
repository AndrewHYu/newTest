package iteratorModel.second;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Andrew  on 2016/10/12.
 */
public class Menu extends MenuComponent {
    private ArrayList menuComponents = new ArrayList();
    private String name;
    private String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public void add(MenuComponent menuComponent){
        menuComponents.add(menuComponent);
    }
    public void remove(MenuComponent menuComponent){
        menuComponents.remove(menuComponent);
    }
    public MenuComponent getChild(int i){
        return (MenuComponent)menuComponents.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }
    public void print(){
        System.out.println("\n"+getName());
        System.out.println(", "+getDescription());
        System.out.println("---------------");

        Iterator iterator=menuComponents.iterator();
        while (iterator.hasNext()){
            MenuComponent menuComponent=(MenuComponent)iterator.next();
            menuComponent.print();
        }
    }
}
