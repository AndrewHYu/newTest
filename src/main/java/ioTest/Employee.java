package ioTest;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Serializable{

	private String name;
	private double salary;
	private Date hireDay;
	public static final int RECORD_SIZE=100;
	public static final int NAME_SIZE=40;
	public static final int SALARY_SIZE=8;
	public static final int DATE_SIZE=12;
	
	public Employee(){
		
	}
	public Employee(String name, double salary,int year,int month,int day) {
		
		this.name = name;
		this.salary = salary;
		GregorianCalendar calendar=new GregorianCalendar(year,month-1,day);
		hireDay=calendar.getTime();
	}
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	public Date getHireDay() {
		return hireDay;
	}
	public void raiseSalary(double byPercent){
		double raise=salary*byPercent/100;
		salary+=raise;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", hireDay="
				+ hireDay + "]";
	}
	
}
