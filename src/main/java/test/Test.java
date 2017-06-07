package test;

import java.lang.reflect.Proxy;
import java.util.ArrayList;

public class Test {
	
	public static void main(String[] args) {
		
		User user = new User();
		//不能转化为user对象
		IUser userProxy = (IUser) Proxy.newProxyInstance(user.getClass().getClassLoader(),
				new Class[]{IUser.class}, new Handler(user));
		
		userProxy.sayHello();
		userProxy.sayHello2();
		
		ArrayList<Integer> list=new ArrayList<>();
		list.add(2);
		list.add(4);
		list.add(5);
		list.remove(0);
		System.out.println(list.get(0));
		
	}

}
