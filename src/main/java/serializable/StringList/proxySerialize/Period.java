package serializable.StringList.proxySerialize;

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

    private void readObject(ObjectInputStream s) throws InvalidObjectException {
        throw new InvalidObjectException("Proxy required");
    }
    private Object readResolve(){
        return new Period(start,end);
    }
    private static class SerializationPoxy implements Serializable{
        private static final long serialVersionUID = -3444539936424088996L;
        private final Date start;
        private final Date end;

        public SerializationPoxy(Period period) {
            this.start = period.start;
            this.end = period.end;
        }
    }
    private Object writeReplace(){
        return new SerializationPoxy(this);
    }
}
