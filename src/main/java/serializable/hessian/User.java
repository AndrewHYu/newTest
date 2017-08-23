package serializable.hessian;

import java.io.Serializable;

/**
 * @author huangyu
 * @date 2017/8/23
 */
public class User implements Serializable{
    private static final long serialVersionUID = 7996225223668891636L;

    public User() {
        System.out.println("constructor a object");
    }

    private Integer id;

    private String name;

    private String address;

    private Integer sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
