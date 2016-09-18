package ioTest;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class RandomAccessTest {

	public static void main(String[] args) throws IOException {
		Employee[] staff=new Employee[3];
		staff[0]=new Employee("$Cal", 75000, 1987, 12, 15);
		staff[1]=new Employee("$Harry", 50000, 1989, 10, 1);
		staff[2]=new Employee("$tony", 40000, 1990, 3, 5);
		try(DataOutputStream out=new DataOutputStream(new FileOutputStream("E:/hh/employee.bat")))
		{
			for(Employee e:staff)
				writeData(out,e);
		}
		try(RandomAccessFile in=new RandomAccessFile("E:/hh/employee.bat", "r"))
		{
				int n=(int)(in.length()/Employee.RECORD_SIZE);	
				//int n=3;
				Employee[]newstaff=new Employee[n];
					for(int i=n-1;i>=0;i--)
					{
						System.out.println(n);
						newstaff[i]=new Employee();
						in.seek(i*Employee.RECORD_SIZE);
						newstaff[i]=readData(in);
						
					}
					
					for(Employee e:newstaff)
					{
						System.out.println(e);
					}
				}

	}

	public static void writeData(DataOutput out,Employee e)throws IOException
	{
		DataIO.writeFixedString(e.getName(),Employee.NAME_SIZE, out);
		out.writeDouble(e.getSalary());
		
		GregorianCalendar calendar=new GregorianCalendar();
		calendar.setTime(e.getHireDay());
		out.writeInt(calendar.get(Calendar.YEAR));
		out.writeInt(calendar.get(Calendar.MONTH));
		out.writeInt(calendar.get(Calendar.DAY_OF_MONTH));
		
	}
	public static Employee readData(DataInput in)throws IOException
	{
		String name=DataIO.readFixedString(Employee.NAME_SIZE, in);
		double salary=in.readDouble();
		int y=in.readInt();
		int m=in.readInt();
		int d=in.readInt();
		return new Employee(name,salary,y,m-1,d);
		
	}
}
