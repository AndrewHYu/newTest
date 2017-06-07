	package test;
	
	import java.text.SimpleDateFormat;
import java.util.Date;
	
	public class time {
	
	public static void main(String[] args) throws Exception {
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy,mm,dd hh:mm:ss");
	
	long timeStart=sdf.parse("2016,04,04 10:00:03").getTime();
	long time=System.currentTimeMillis();
	System.err.println(time);
	System.out.println("time:"+sdf.format(time));
	
	System.out.println("new "+timeStart);
	
	Date date = new Date(timeStart);
	Object obj;
	//Date date2=new Date(obj);
	System.out.println(sdf.format(date));
	double f=2.0f-1.1;
	String string =System.getProperty("user.dir");
	
	int cp=string.codePointCount(0, string.length());
	System.out.println(cp);
	System.out.println(string.length());
	//Console con=System.console(); //返回值为空，不能再eclipse等编译器下使用。
	//String username=con.readLine("user name:");
	//char[] passwd=con.readPassword("passWord:");
	//String pw=passwd.toString();
	//System.out.println(username+pw);
	System.out.printf("Hello,%s.Next year , you'll be %d",string,6 );
	System.out.printf("%1$s %2$tB %2$tY","due date:", new Date());
	}
	
	}
