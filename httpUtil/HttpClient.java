package com.lq;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class HttpClient {

	public static String get(String urlStr,Map<String,String> params){
		InputStream is = null;
		BufferedReader reader = null;
		String resultStr ="";
        try {
        	String paramsStr = "";
        	for(String param : params.keySet()){
        		paramsStr += "&" + param + "=" + params.get(param);
        	}
        	if(!paramsStr.isEmpty()){
        		paramsStr = paramsStr.substring(1);
        		urlStr += "?" + paramsStr;
        	}
			URL url = new URL(urlStr);
			HttpURLConnection httpCon = (HttpURLConnection) url
					.openConnection();
			httpCon.setRequestMethod("GET");
			is = httpCon.getInputStream();
 
			reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {   
                sb.append(line);   
            }
			resultStr = sb.toString();
		 
		} catch (Exception e) {
			e.printStackTrace();
			 
		} finally {
			try {
				if(reader!=null)reader.close();
				if(is!=null)is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resultStr;
	}
	
	public static String post(String urlStr,Map<String,String> params){
		 URL connect;
		 StringBuffer data = new StringBuffer();  
         try {  
             connect = new URL(urlStr);  
             HttpURLConnection connection = (HttpURLConnection)connect.openConnection();  
             connection.setRequestMethod("POST");  
             connection.setDoOutput(true); 
             connection.setDoInput(true);
             connection.setRequestProperty("accept", "*/*");
             connection.setRequestProperty("connection", "Keep-Alive");
             connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
             OutputStreamWriter paramout = new OutputStreamWriter(  
                     connection.getOutputStream(),"UTF-8"); 
         	String paramsStr = "";
        	for(String param : params.keySet()){
        		paramsStr += "&" + param + "=" + params.get(param);
        	}
        	if(!paramsStr.isEmpty()){
        		paramsStr = paramsStr.substring(1);
        	}
             paramout.write(paramsStr);  
             paramout.flush();  
             BufferedReader reader = new BufferedReader(new InputStreamReader(  
                     connection.getInputStream(), "UTF-8"));  
             String line;              
             while ((line = reader.readLine()) != null) {          
                 data.append(line);            
             }  
           
             paramout.close();  
             reader.close();  
         } catch (Exception e) {  
             // TODO Auto-generated catch block  
             e.printStackTrace();  
         }  
        return data.toString();
	}
	
	/**
	 * 通过网站域名URL使用POST方式 获取该网站的源码
	 * @param url 请求的地址
	 * @param param 请求的参数  
	 * @param request HttpServletRequest对象 
	 * @return 返回请求的结果
	 */
	// 使用Post方式，获取该网站的源码 --如果使用容器的话，可以通过http传cookie，免登陆！
	/*
	private  String getURLSourcePost(String url,String param ,HttpServletRequest request) {
	  PrintWriter out = null;
	  BufferedReader in = null;
	  StringBuilder htmlResult = new StringBuilder();
	  //获取浏览器的传入cookie
	  Cookie[] cookies = request.getCookies();
	  StringBuilder cookiesAll = new StringBuilder();
	  // cookies为空，抛出空指针异常
	  if(cookies != null){
		  for (Cookie cookie : cookies) {
			  cookiesAll.append(cookie.getName()+"="+cookie.getValue()+";");
		  }
	  }
	  try
	  {
	   URL realUrl = new URL(url);
	   //打开和URL之间的连接
	   HttpURLConnection conn = (HttpURLConnection)realUrl.openConnection();  
	   //设置请求的方式
	   conn.setRequestMethod("POST");
	   conn.setConnectTimeout(5 * 1000);
	   //设置通用的请求属性
	   conn.setRequestProperty("accept", "*/*");
	   conn.setRequestProperty("connection", "Keep-Alive");
	   conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
	   // 加入charset=UTF-8以防止乱码！
	   conn.setRequestProperty("content-type", "application/x-www-form-urlencoded; charset=UTF-8");
	   // 设置传cookie内容
	   conn.setRequestProperty("Cookie", cookiesAll.toString());
	   //发送POST请求必须设置如下两行
	   conn.setDoOutput(true);
	   conn.setDoInput(true);
	   //获取URLConnection对象对应的输出流
	   out = new PrintWriter(conn.getOutputStream());
	   //发送请求参数
	   out.print(param);
	   //flush输出流的缓冲
	   out.flush();
	   //定义BufferedReader输入流来读取URL的响应
	   in = new BufferedReader(
	     new InputStreamReader(conn.getInputStream()));
	   String line;
	   while ((line = in.readLine())!= null)
	   {
		   if(StringUtils.isNotBlank(line)){
			   htmlResult.append("\n" + line);
		   }
	   }
	  }
	  catch(Exception e)
	  {
		  throw new RuntimeException("发送POST请求出现异常！",e);
		 
	  }
	  //使用finally块来关闭输出流、输入流
	  finally
	  {
	   try
	   {
	    if (out != null)
	    {
	     out.close();
	    }
	    if (in != null)
	    {
	     in.close();
	    }
	   }
	   catch (IOException ex)
	   {
		log.error(ex);
	    ex.printStackTrace();
	   }
	  }
	  return htmlResult.toString();
	 }
	 */

}
