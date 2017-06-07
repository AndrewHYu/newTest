package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Handler implements InvocationHandler {
	
	private Object proxyed;
	
	public Handler(Object proxyed) {
		this.proxyed = proxyed;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("Hello Proxy");
		return method.invoke(proxyed, args);
	}

}
