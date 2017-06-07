package serializable.atomicReference;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Andrew  on 2017/5/7.
 */
public class Foo extends AbstractFoo implements Serializable {
    private static final long serialVersionUID = -2214330724506309068L;

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        System.out.println(" Foo readObject");
        s.defaultReadObject();

        int x = s.readInt();
        int y = s.readInt();
        initialize(x,y);
    }
    private void writeObject(ObjectOutputStream s) throws IOException, ClassNotFoundException {
        System.out.println(" Foo writeObject");
        s.defaultWriteObject();
        s.writeInt(getX());
        s.writeInt(getY());
    }

    public Foo(int x,int y){
        super(x,y);
    }

}
