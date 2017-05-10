package serializable.StringList.custmoSerialize;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Andrew  on 2017/5/7.
 */
public class StringList implements Serializable {
    private transient int size = 0;
    private transient  Entry head = null;


    private static class Entry{
        String date;
        Entry next;
        Entry previous;
    }

    public final void add(String s){
        Entry e = new Entry();

        if (head != null){
            e.next = head.previous;
        }
        e.next = head;
        head = e;
        e.date = s;
        size++;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(size);

        for (Entry e = head; e != null; e = e.next){
            s.writeObject(e.date);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        int numElements = s.readInt();

        for (int i = 0; i<numElements; i++){
            add((String)s.readObject());
        }
    }

}
