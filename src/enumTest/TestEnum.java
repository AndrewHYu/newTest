package enumTest;

import java.util.*;

/**
 * Created by Andrew  on 2017/1/17.
 */
public class TestEnum {

    enum Grade{
        A("100-90") {
            @Override
            public String localValue() {
                return null;
            }
        },B("100-90") {
            @Override
            public String localValue() {
                return "优";
            }
        },C("100-90") {
            @Override
            public String localValue() {
                return null;
            }
        },D("100-90") {
            @Override
            public String localValue() {
                return null;
            }
        };
        private String value;
         Grade(String value){
            this.value=value;
        }
        public abstract String localValue();
    }

    public static void main(String[] args) {
        System.out.println(Grade.A);
        System.out.println(Grade.A.toString());

        System.out.println(Grade.B.localValue());
        System.out.println(Grade.B.ordinal());

        System.out.println(Grade.values());

        System.out.println(OrderEnum.A);

        System.out.println(OrderEnum.A.localValue());
        System.out.println(OrderEnum.valueOf("A"));

        System.out.println(Grade.class.getEnumConstants()[0]);
    }
}
