package test;

public class User implements IUser,Yuser {
	
	public User() {
		
	}
	
	@Override
	public void sayHello() {
		System.out.println("Hello World");
	}
	public void sayHello2() {
		System.out.println("Hello2 World");
	}

	@Override
	public void sayGoodbye() {
		// TODO Auto-generated method stub
		System.out.println("goodbye World");
	}

}
