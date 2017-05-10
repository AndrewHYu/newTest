package serializable.readObject;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Andrew  on 2017/5/7.
 */
public final class Period implements Serializable{
    private static final long serialVersionUID = -7657601420921563384L;
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
    }

    public Date start(){return new Date(start.getTime());}

    public Date end(){return new Date(end.getTime());}

    public String toString(){return start+" - "+end;}

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        if (start.compareTo(end)>0){
            throw new InvalidObjectException(start + " after "+end);
        }
    }
}
