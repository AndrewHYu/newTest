package enumTest;

/**
 * Created by Andrew  on 2017/1/17.
 */
public enum OrderEnum {
    A {
        @Override
        String localValue() {
            return "支付";
        }
    },B {
        @Override
        String localValue() {
            return "未支付";
        }
    },C {
        @Override
        String localValue() {
            return "退款";
        }
    },D {
        @Override
        String localValue() {
            return "完成";
        }
    },E {
        @Override
        String localValue() {
            return "关闭";
        }
    };
    OrderEnum(){}
    abstract String localValue();
}
