package ioTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import javax.xml.soap.SAAJResult;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.omg.CORBA.PUBLIC_MEMBER;

public class TexxtFileTest {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println('a'+1);
		System.out.println('1'+1+Integer.toHexString((int)'A')+111+333);
		System.out.println('a'+1%2.0);
		Employee[] staff=new Employee[3];
		staff[0]=new Employee("Cal$", 75000, 1987, 12, 15);
		staff[1]=new Employee("Harry", 50000, 1989, 10, 1);
		staff[2]=new Employee("tony", 40000, 1990, 3, 5);
		try(PrintWriter out=new PrintWriter("E:/hh/employee.bat","utf-8"))
		{
			
			writeData(staff, out);
		}
		try(Scanner in=new Scanner(new FileInputStream("E:/hh/employee.bat"),"utf-8"))
		{
			Employee[] newstaff=readData(in);
			for (Employee employee : newstaff) {
				System.out.println(employee);
			}
		}
		

	}
private static void writeData(Employee[] employees,PrintWriter out)throws IOException
{
	out.println(employees.length);
	for (Employee employee : employees) {
		
		writeEmployee(out,employee);
	}
}
private static Employee[] readData(Scanner in)
{
	int n=in.nextInt();
	in.nextLine();
	
	Employee[]employees=new Employee[n];
	for(int i=0;i<n;i++)
	{
		employees[i]=readEmployee(in);
	}
	return employees;
}
public static void writeEmployee(PrintWriter out,Employee e)
{
	GregorianCalendar calendar=new GregorianCalendar();
	calendar.setTime(e.getHireDay());
	out.append(e.getName()+"|"+e.getSalary()+"|"+calendar.get(Calendar.YEAR)
			+"|"+calendar.get(Calendar.MONTH)+"|"+calendar.get(Calendar.DAY_OF_MONTH)+"\n");
}
public static Employee readEmployee(Scanner in)
{
	String line=in.nextLine();
	String[] token=line.split("\\|");
	String name=token[0];
	double salary=Double.parseDouble(token[1]);
	int year=Integer.parseInt(token[2]);
	int month=Integer.parseInt(token[3]);
	int day=Integer.parseInt(token[4]);
	return new Employee(name, salary, year, month, day);
}
}
