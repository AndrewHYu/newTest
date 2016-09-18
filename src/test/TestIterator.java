package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.text.html.parser.Entity;

public class TestIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		List<String> aList=new LinkedList<>();
		aList.add("a");
		aList.add("b");
		aList.add("c");
		List<String> bList=new LinkedList<>();
		bList.add("A");
		bList.add("B");
		bList.add("C");
		ListIterator<String> aiIterator=aList.listIterator();
		ListIterator<String> bIterator=bList.listIterator();
		while (bIterator.hasNext()) {
			if (aiIterator.hasNext()) {
				aiIterator.next();
			}
			aiIterator.add(bIterator.next());
			
		}
		
		System.out.println(aList);
	}

}
