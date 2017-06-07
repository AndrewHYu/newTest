package ioTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest {

	public static void main(String[] args)throws IOException,ClassNotFoundException {
		// TODO Auto-generated method stub
		Employee harry=new Employee("Harry Harker",50000,189,10,1);
		Manger carl=new Manger("Carl Cracker", 80000, 1987, 12, 15, harry);
		Manger tony=new Manger("Tony Tester", 40000, 1990, 3, 15, harry);
		Employee[] staff=new Employee[3];
		staff[0]=carl;
		staff[1]=harry;
		staff[2]=tony;
		
		try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("E:/hh/employee.bat")))
		{
			out.writeObject(staff);
		}
		
		try(ObjectInputStream in=new ObjectInputStream(new FileInputStream("E:/hh/employee.bat")))
		{
			Employee[] newStaff=(Employee[]) in.readObject();
			
			newStaff[1].raiseSalary(10);
			for(Employee e:newStaff)
				System.out.println(e);
		}

	}

}
