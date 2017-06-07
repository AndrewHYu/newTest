package ClazzLoader.TExtend;

/**
 * Created by Andrew  on 2017/4/25.
 */
public class F1 {
    private F1 parent;

    public F1(){

    }
    public F1(F1 parent) {
        this.parent = parent;
    }

    public void say() throws Exception {
        System.out.println("say f1");
        try{
            if (parent!=null){
                System.out.println(parent);
                parent.say();
            }
        }catch (Exception e){

        }

        tell();
    }
    public void tell() throws Exception {
        System.out.println("f1 tell");
        throw new Exception("classNotFind");
    }
}
