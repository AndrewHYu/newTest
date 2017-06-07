package jvm;

import org.python.core.util.StringUtil;

import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * Created by Andrew  on 2017/3/13.
 */
public class param {
    public static void main(String[] args){
        List<String> paramters = ManagementFactory.getRuntimeMXBean().getInputArguments();
        System.out.println(paramters);
    }
}
