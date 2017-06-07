package test;
import java.util.regex.*;
public class TestRegex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String oldString="xfooxxxxxxfoo";
		String regexString=".*foo";
		Pattern pattern=Pattern.compile(regexString);
		Matcher matcher= pattern.matcher(oldString) ;
		while(matcher.find()){
		System.out.println(matcher.group());
		
		}
//		matcher.find();
//		System.out.println(matcher.group());
		//System.out.println(matcher.find());
		int a[][]={{1,2,3},{2,3},{4,5}};
		
		System.out.println(a.length);
		System.out.println(a[1].length);
	}

}
