package iteratorModel.second;

/**
 * Created by Andrew  on 2016/10/12.
 */
public class Waitress {
    MenuComponent allMenus;
    public Waitress(MenuComponent allMenus){
        this.allMenus=allMenus;
    }
    public void printMenu(){
        allMenus.print();
    }
}
