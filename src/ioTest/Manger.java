package ioTest;

public class Manger extends Employee{

	private Employee secretary;
	public Manger(String name, double salary,int year,int month,int day,Employee e){
		super(name, salary, year, month, day);
		this.secretary=e;
	}
	
}
