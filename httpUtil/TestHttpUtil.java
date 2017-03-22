package com.lq;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;

import com.alibaba.fastjson.JSONObject;

public class TestHttpUtil {

	
	public static void main(String[] args) throws ClientProtocolException, IOException{
//		  String url = "http://10.120.99.171/tclshop/storeback/coupontype/queryList";
//	      Map<String,String> params = new HashMap<String,String>();
////	      params.put("requestType", "city");
////	      params.put("AreaId", "05");
////	      params.put("time", "0.3269021827727556");
//		  String resultStr = TestHttpClient.post(url, params);
//		  System.out.println(resultStr);
		  
	  		String mobile = "13500066000";
	  		String method = "hawkeye.notice.getInfoByMobile";
	  	    String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	  	    String format = "html";
	  	    String appkey = "api_kuyu";
	  	    String url ="http://hktest.koyoo.cn/rest/index.php";
	  	    String secret = "94d3dfbd973086f97e16bd7c18c283ff";
	  	    String serialStr = secret + "appkey" + appkey + "data" + mobile + "format" +
	  	    format + "method" + method + "timestamp" + timestamp + secret;
	  		String sign = MD5.GetMD5Code(serialStr).toUpperCase();
	  		System.out.println(sign);
	  		//1F22158D26849E024729486CC42350B7
	  		//1F22158D26849E024729486CC42350B7
	  		//9ADD389F7C76FD539A75A6B29AC972FE
	  		//E9AFDDFF3E571949DD2A04F8BF238DF7
	  		 Map<String,String> params = new HashMap<String,String>();
	  		 params.put("mobile", mobile);
	  		 params.put("method", method);
	  		 params.put("timestamp", timestamp);
	  		 params.put("format", format);
	  		 params.put("appkey", appkey);
	  		 params.put("sign", sign);
	  		 System.out.println(params);
            String resultStr = TestHttpClient.post(url, params);
            System.out.println(resultStr);
           
//        Map<String,String> params = new HashMap<String,String>();
//        param.put("param", param.toJSONString());
//		String resultStr = HttpXmlClient.post(url, params);
//		System.out.println(resultStr);
//		
//		 resultStr = HttpXmlClient.get("http://10.120.99.171/tclshop/front/skuwarehouserel/getArea?requestType=city&AreaId=05&time=0.3269021827727556");
//		System.out.println(resultStr);
	}
	
	public String getSign(JSONObject param,String pwd){
		pwd = "secret";
		return "";
	}
	
}
