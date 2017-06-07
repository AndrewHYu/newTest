package XATest;

/**
 * Created by Andrew  on 2016/11/12.
 */
import javax.script.*;

import org.python.util.PythonInterpreter;

import java.io.*;
import static java.lang.System.*;
public class FirstJavaScript  {
    public static void main(String args[])  {
        long start = System.currentTimeMillis();
        PythonInterpreter interpreter = new PythonInterpreter();
//        interpreter.exec("days=('mod','Tue','Wed','Thu','Fri','Sat','Sun'); ");
        interpreter.execfile("E:\\python\\test.py");
//        interpreter.exec("print days[1];");
        long end = System.currentTimeMillis();
        System.out.println(end -  start);


    }
}