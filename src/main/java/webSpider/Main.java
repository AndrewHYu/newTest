package webSpider;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URL;
import java.nio.CharBuffer;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.*;


import org.apache.lucene.document.Document;

import com.model.Info;
import com.service.TextFactory;


public class Main {
	private int page=0;
	private int currentPage=1;
	private String head="http://tieba.baidu.com/p/";
	private String index;
	private String rowContent;
	private boolean control=false;
	private StringBuilder sbl=new StringBuilder();
	private static Map<String,Integer> l2=new HashMap<String,Integer>();
	private Map<String,Info> infoMap=new HashMap<String,Info>();
	private Map<String,String> charMap=new HashMap<String,String>();
	private ArrayList<String> img=new ArrayList<String>();
	public ArrayList<String> getImg() {
		return img;
	}
	public Map<String, Integer> getL2() {
		return l2;
	}
	public void setL2(Map<String, Integer> l2) {
		this.l2 = l2;
	}
	public Map<String, Info> getInfoMap() {
		return infoMap;
	}
	
	void getInfo(){
		Set<String> set=infoMap.keySet();
		Iterator<String> it=set.iterator();
		while(it.hasNext()){
			String key=it.next();
			Info info1=infoMap.get(key);
			System.out.println("{");
			System.out.println("Name:"+info1.getName()+";sum:"+info1.getSum());
			Iterator it1=info1.getWordMap().keySet().iterator();
			while(it1.hasNext()){
				Character c=(Character) it1.next();
				System.out.println("key:"+c.toString()+";value:"+info1.getWordMap().get(c));
			}
			System.out.println("}");
		}
	}
	public void getPage(String strUrl) throws MalformedURLException,
			IOException, UnsupportedEncodingException {
		System.out.println(new Date(System.currentTimeMillis()).toString());
		index=strUrl.substring(head.length(),strUrl.length());
	    URL url = new URL(strUrl); 
	    HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();  
	    InputStreamReader input = new InputStreamReader(httpConn
	            .getInputStream(), "utf-8");  
	    BufferedReader bufReader = new BufferedReader(input);  
	    String line = "";  
	    StringBuilder contentBuf = new StringBuilder(); 

	    while ((line = bufReader.readLine()) != null) {  
	        contentBuf.append(line);  
	    }
	    rowContent=contentBuf.toString();
	    String startRegex="</span>回复贴，共<span class=\"red\">";
	    String endRegex="</span>页</li>";
	    int endIndex=rowContent.indexOf(endRegex);
	    if(endIndex!=-1)
	    	page=Integer.parseInt(rowContent.substring(rowContent.indexOf(startRegex)+startRegex.length(),endIndex));
	}
	public void getUsers() throws IOException
	{
		String authorRegex=" class=\"p_author_name";
		String endAuthorRegex="</a>";
		String startAuthorRegex="fr=pb\" target=\"_blank\">";
		String author=null;
		String aLine=null;
		String aImg=null;
		String waste=null;
		String startContentRegex="<div id=\"post_content_";
		String endContentRegex="</div><br>            </cc>";
		String imgStartRegex="<img ";
		String wasteStartRegex1="<span";
		String wasteStartRegex2="<div";
		String wasteStartRegex3="<br>";
		String wasteStartRegex4="<a href=";
		String wasteEndRegex1="</span>";
		String wasteEndRegex2="</div>";
		String wasteEndRegex4="</a>";
		String pid=null;
		String lzlHead="http://tieba.baidu.com/p/comment?tid=";
		String lzlLine=null;
		String lzlALine=null;
		String lzlRowContent=null;
		String lzlContentEndRegex="        </span><div class=\"lzl_content_reply\">";
		String lzlNextContent="<span class=\"lzl_content_main\">";
		int lzlReplys=0;
		int lzlPage=0;
		int lzlCurrentPage=1;
        Set<String> list=new HashSet<String>();
        mainConnect(list);  
        Iterator it=list.iterator();
		while(it.hasNext())
		{

			String rowContent=(String) it.next();
			StringBuilder sbContent=new StringBuilder("");
			int d;
					while((d=rowContent.indexOf(authorRegex))!=-1)
			{
				rowContent=rowContent.substring(d+21);
				author=rowContent.substring(rowContent.indexOf(startAuthorRegex)+23,rowContent.indexOf(endAuthorRegex));
				Info count=infoMap.get(author);
				infoMap.put(author, count==null?count=setCount(author):getCount(count));
				rowContent=rowContent.substring(rowContent.indexOf(startContentRegex));
				aLine=rowContent.substring(88,rowContent.indexOf(endContentRegex));
				/*------处理楼中楼------*/
				count = getLou(imgStartRegex, lzlHead, lzlContentEndRegex,
						lzlNextContent, sbContent, count,rowContent);
				/*------处理楼中楼------*/
				
				int dex=aLine.indexOf("post_bubble_middle");
				if(dex!=-1)
				{
					aLine=aLine.substring(dex);
					aLine=aLine.substring(aLine.indexOf(">")+1,aLine.indexOf("</div>"));
				}
				while((dex=aLine.indexOf(imgStartRegex))!=-1)
				{
					aImg=aLine.substring(dex);
					aImg=aImg.substring(0,aImg.indexOf(">")+1);
					aLine=aLine.replace(aImg,"");
					aImg=aImg.substring(aImg.indexOf("http"));
					aImg=aImg.substring(0,aImg.indexOf("\""));
					img.add(aImg);
				}
				while((dex=aLine.indexOf(wasteStartRegex1))!=-1)
				{
					waste=aLine.substring(dex, aLine.indexOf(wasteEndRegex1)+7);
					aLine=aLine.replace(waste, "");
				}
				while((dex=aLine.indexOf(wasteStartRegex2))!=-1)
				{
					waste=aLine.substring(dex, aLine.indexOf(wasteEndRegex2)+6);
					aLine=aLine.replace(waste, "");
				}
				aLine=aLine.replaceAll(wasteStartRegex3, "");
				while((dex=aLine.indexOf(wasteStartRegex4))!=-1)
				{
					waste=aLine.substring(dex, aLine.indexOf(wasteEndRegex4)+4);
					aLine=aLine.replace(waste, "");
				}
				sbContent.append(aLine);
				getWord(count.getWordMap(),sbContent.toString());	
				
			}
			
		}
	}
	private void mainConnect(Set<String> list) throws MalformedURLException,
			IOException, UnsupportedEncodingException {
		StringBuilder contentBuf=new StringBuilder();
		while(currentPage<=page)
		{
        URL url = new URL(head+index+"?pn="+currentPage);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		InputStreamReader input = new InputStreamReader(httpConn  
		        .getInputStream(), "utf-8");  
		BufferedReader bufReader = new BufferedReader(input);  
		String line = "";  
		while ((line = bufReader.readLine()) != null) {  
		    contentBuf.append(line);  
		}
	    list.add(contentBuf.toString());
	    contentBuf.delete(0, contentBuf.length());
	    currentPage++;
	    bufReader.close();
		}
	}
	
	private Info getLou(String imgStartRegex, String lzlHead,
			String lzlContentEndRegex, String lzlNextContent,
			StringBuilder sbContent, Info count,String rowContent) throws MalformedURLException,
			IOException, UnsupportedEncodingException {

		String author;
		String aImg;
		String pid;
		String lzlLine;
		String lzlALine;
		String lzlRowContent;
		int lzlReplys;
		int lzlPage;
		int lzlCurrentPage;
		pid=rowContent.substring(22,rowContent.indexOf("\" class"));
		rowContent=rowContent.substring(rowContent.indexOf(">回复"));
		lzlLine=rowContent.substring(0,rowContent.indexOf("</a>"));
		Pattern p=Pattern.compile("\\d+");
		Matcher m=p.matcher(lzlLine);
		lzlCurrentPage=1;
		if(m.find())
		{
			lzlReplys=Integer.parseInt(m.group());
			lzlPage=lzlReplys/10;
			lzlPage++;
			Set<String> list=new HashSet<String>();
			  StringBuilder contentBuf = new StringBuilder();  
			while(lzlCurrentPage<=lzlPage)
			{
			
			URL lzlUrl=new URL(lzlHead+index+"&pid="+pid+"&pn="+lzlCurrentPage+"&t="+Math.random());
			lzlCurrentPage++;
		    HttpURLConnection httpConn = (HttpURLConnection) lzlUrl.openConnection();  
		    InputStreamReader input = new InputStreamReader(httpConn  
		            .getInputStream(), "utf-8");  
		    BufferedReader bufReader = new BufferedReader(input);  
		    String line = "";  
		  
		    while ((line = bufReader.readLine()) != null) {  
		        contentBuf.append(line);  
		    }
		    lzlRowContent=contentBuf.toString();
		    list.add(contentBuf.toString());
			}
			Iterator it=list.iterator();
			
			while(it.hasNext())
			{
				lzlRowContent=(String) it.next();
			while(lzlRowContent.indexOf(lzlNextContent)!=-1)
			{

			lzlRowContent=lzlRowContent.substring(lzlRowContent.indexOf("username"));
			author=lzlRowContent.substring(10,lzlRowContent.indexOf("\">"));
			if(author.indexOf("\" target=\"_blank\" class=\"at")!=-1)
				author=author.substring(0,author.length()-27);
			count=infoMap.get(author);
			infoMap.put(author, count==null?count=setCount(author):getCount(count));
		lzlRowContent=lzlRowContent.substring(lzlRowContent.indexOf(lzlNextContent)+39);
			lzlALine=lzlRowContent.substring(0,lzlRowContent.indexOf(lzlContentEndRegex));
			int dex;
			while( (dex=lzlALine.indexOf(imgStartRegex))!=-1)
			{
				aImg=lzlALine.substring(dex);
				aImg=aImg.substring(0,aImg.indexOf(">")+1);
				lzlALine=lzlALine.replace(aImg,"");
				aImg=aImg.substring(aImg.indexOf("http"));
				aImg=aImg.substring(0,aImg.indexOf("\""));
				img.add(aImg);
				dex=lzlALine.indexOf(imgStartRegex);
			}
			if(lzlALine.indexOf("回复")!=-1)
				if(lzlALine.indexOf(" ：")!=-1)
					lzlALine=lzlALine.substring(lzlALine.indexOf(" ：")+2);
				else lzlALine=lzlALine.substring(lzlALine.indexOf(" :")+2);
			if(lzlALine.indexOf("</a>  :")!=-1)
				lzlALine=lzlALine.substring(lzlALine.indexOf("</a>  :")+7);
			sbContent.append(lzlALine);
			} 
		    }
		}
		return count;
	}
	private Info getCount(Info count) {
		count.setSum(count.getSum()+1);
		return count;
	}
	private Info setCount(String author) {
		Info count;
		count=new Info();count.setName(author);count.setSum(1);
		return count;
	}
	
	public void ifChar() {
		   FileInputStream i;
		try {
			i = new FileInputStream("d:/1/main.txt");
		    InputStreamReader bf = new  InputStreamReader(i,"utf8");
		   char[] b=new char[100];
		   StringBuilder s=new StringBuilder();
		   while(bf.read(b)!=-1)
			 s.append(new String(b)+"\n");
		   String c=new String(s.toString().getBytes(),"utf8");
		   String[] se=c.split(",");
           for(String x:se){
        	   charMap.put(x,x);
           }
           control=true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private void getWord(Map<Character,Integer> wordMap,String content)
	{
		 String regEx = "^[\u4e00-\u9fa5]{0,}$";
		    Pattern pattern = Pattern.compile(regEx);
		    String con="";
			for(int i=0;i<content.length();i++)
			{
		    Matcher matcher = pattern.matcher(content.charAt(i)+"");
		    if(matcher.matches())
		    	con+=content.charAt(i);
			}
			content=con;
			if(control)
				sbl.append(content);
		for(int i=0;i<content.length();i++)
		{
			
			Character c=content.charAt(i);
			Integer count=wordMap.get(c);
			wordMap.put(c, count==null?1:count+1);
		}
	}
	private  void getData() {
    for(int i=0;i<sbl.length();i++){
		if(i+1<sbl.length()){
			String b=sbl.substring(i,i+2);
			String s=charMap.get(b);
			if(s!=null){
				Integer count=l2.get(s);
				l2.put(s,count==null?1:count+1);
			}
		}
     }
	}
//	public static void main(String[] args) throws IOException {
//		//"http://tieba.baidu.com/p/4314521615"
//		System.out.println(new Date(System.currentTimeMillis()).toString());
//		Main gw=new Main();
//		gw.ifChar();
//		gw.getPage("http://tieba.baidu.com/p/4314521615");
//		gw.getUsers();
//		gw.getData();
//        Set s=l2.keySet();
//        Iterator i=s.iterator();
//        while(i.hasNext()){
//        	String sb=(String) i.next();
//        	System.out.println(sb+":"+l2.get(sb));
//        }
//	
//	}

}
