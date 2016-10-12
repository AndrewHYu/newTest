package iteratorModel.second;

/**
 * Created by Andrew  on 2016/10/12.
 */
public class MenuItem extends MenuComponent{
    private String name;
    private String description;
    private boolean vegetarian;
    private double price;
    public MenuItem(String name,String description,boolean vegetarian,double price){
        this.name=name;
        this.description=description;
        this.vegetarian=vegetarian;
        this.price=price;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void print(){
        System.out.println("    "+getName());
        if (isVegetarian()){
            System.out.println("(v)");
        }
        System.out.println(","+getPrice());
        System.out.println("     -------"+getDescription());
    }
}
