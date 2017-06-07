package serializable.StringList.DefalutSerialize;

import java.io.Serializable;

/**
 * Created by Andrew  on 2017/5/7.
 */
public class StringList implements Serializable {
    private static final long serialVersionUID = -760917016953188026L;
    private int size = 0;
    private Entry head = null;


    private static class Entry implements Serializable{
        private static final long serialVersionUID = -8146376250665831614L;
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
}
