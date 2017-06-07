package webSpider;

import java.io.*;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class DownLoadFile {

	 /**
	  * 根据 url 和网页类型生成需要保存的网页的文件名 去除掉 url 中非文件名字符
	  */
	 public String getFileNameByUrl(String url, String contentType) {
	  // remove http://
	  url = url.substring(7);
	  // text/html类型
	  if (contentType.indexOf("html") != -1) {
	   url = url.replaceAll("[\\?/:*|<>\"]", "_") + ".html";
	   return url;
	  }
	  // 如application/pdf类型
	  else {
	   return url.replaceAll("[\\?/:*|<>\"]", "_") + "."
	     + contentType.substring(contentType.lastIndexOf("/") + 1);
	  }
	 }
	 /**
	  * 保存网页字节数组到本地文件 filePath 为要保存的文件的相对地址
	  */
	 private void saveToLocal(byte[] data, String filePath) {
	  try {
	   DataOutputStream out = new DataOutputStream(new FileOutputStream(
	     new File(filePath)));
	   for (int i = 0; i < data.length; i++)
	    out.write(data[i]);
	   out.flush();
	   out.close();
	  } catch (IOException e) {
	   e.printStackTrace();
	  }
	 }
	 /* 下载 url 指向的网页 */
	 public String downloadFile(String url) throws HttpException {
	  String filePath = null;
	  /* 1.生成 HttpClinet 对象并设置参数 */
	  HttpClient httpClient = new DefaultHttpClient();
	  // 设置 Http 连接超时 5s
//	  httpClient.getConnectionManager().getParams()
//	    .setConnectionTimeout(5000);
	  /* 2.生成 GetMethod 对象并设置参数 */
	  HttpGet httpGet = new HttpGet(url);
	  // 设置 get 请求超时 5s
	 // httpGet.setParameter(httpGet.SO_TIMEOUT, 5000);
	  // 设置请求重试处理
//	  httpGet.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
//	    new DefaultHttpMethodRetryHandler());
	  /* 3.执行 HTTP GET 请求 */
	  try {
	   HttpResponse httpResponse=httpClient.execute(httpGet);
	   // 判断访问的状态码
	   if (httpResponse.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
	    System.err.println("Method failed: "
	      + httpResponse.getStatusLine());
	    filePath = null;
	   }
	   /* 4.处理 HTTP 响应内容 */
	  httpResponse.getEntity();// 读取为字节数组
	   // 根据网页 url 生成保存时的文件名
//	   filePath = "f:\\spider\\"
//	     + getFileNameByUrl(url,
//	    		 httpResponse.getResponseHeader("Content-Type")
//	         .getValue());
//	   saveToLocal(responseBody, filePath);
	  
	  } catch (IOException e) {
	   // 发生网络异常
	   e.printStackTrace();
	  } finally {
	   // 释放连接
		  httpGet.releaseConnection();
		  
	  }
	  return filePath;
	 }
}
