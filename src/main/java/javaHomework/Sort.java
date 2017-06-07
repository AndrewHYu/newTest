package javaHomework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/*
 * 
 * 2-7
 * 2-9====p60 cos
 */
public class Sort {

	
	public static void main(String[] args) {
		final String aString="hello";
	final	String bString="world";
		String  cString="helloworld";
		String dString = aString+bString;
		System.out.println(dString==cString);
		String fString = dString.intern();
		System.out.println(dString==cString);
		System.out.println(fString==cString);
//		Scanner in=new Scanner(System.in);
//		String nums=in.nextLine();
//		List<Integer> list=new ArrayList<>();
//		String[] numss=nums.split(" ");
//		for (String num : numss) {
//			list.add(Integer.parseInt(num));
//		}
		
//		while (nums!=null) {
//			int a=nums.indexOf(" ");
//			
//			if(a<0){
//				list.add(Integer.parseInt(nums));
//				break;
//			}else{
//				int x=Integer.parseInt(nums.substring(0, a));
//				list.add(x);
//			}
//			
//			nums=nums.substring(a+1);
//			
//		}
		
//		in.close();
//		Collections.sort(list);
//		System.out.println(list.toString());
	}

}
