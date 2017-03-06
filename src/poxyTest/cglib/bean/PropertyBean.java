package poxyTest.cglib.bean;

/**
 * Created by Andrew  on 2017/3/6.
 */
public class PropertyBean {
    private String key;
    private Object value;
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public Object getValue() {
        return value;
    }
    public void setValue(Object value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return "PropertyBean [key=" + key + ", value=" + value + "]" +getClass();
    }
}
