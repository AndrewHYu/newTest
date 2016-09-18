package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;

public class Proxy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object[] elements=new Object[100];
		for(int i=0;i<elements.length;i++)
		{
			Integer value=i+1;
			InvocationHandler handler=new TaceHandler(value);
			Object proxy=java.lang.reflect.Proxy.newProxyInstance(null,new Class[]{Comparable.class},handler);
			elements[i]=proxy;
		}
		Integer key=new Random().nextInt(elements.length);
		int result=Arrays.binarySearch(elements, key);
		//if(result>=0)System.out.println(elements[result]);
	}
	}
	
class TaceHandler implements InvocationHandler
{
	private Object target;
	
	public TaceHandler(Object t){
		target=t;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.print(target+"."+method.getName()+"(");
		if (args!=null) {
			for(int i=0;i<args.length;i++){
				System.out.println(args[i]);
				if (i<args.length-1) {
					System.out.print(",");
					
				}
			}
			System.out.print(")");
			
		}
		
		return method.invoke(target, args);
	}
	
	
}


