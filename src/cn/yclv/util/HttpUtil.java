package cn.yclv.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


public class HttpUtil {
	
	public static void main(String[] args) throws IOException, SQLException {
//		FileUtil.readFilesAndInsert("E:\\java\\qq_group\\member");
		
//		JdbcUtil.queryAll(conn, "orders");
		
//		List<Group> allGroups = QQUtil.getGroupList(txtJson);
//		QQUtil.insertGroups(allGroups, conn, QQConstrant.INSERT_GROUP_SQL_PSTMT);
		
//		buildPost("http://www.lubanyangche.com/sales/wxUser/getHomeAllData.do?sellerUserId=101",
//				"http://www.lubanyangche.com/sales/loginMobileSystem.do", "13795247387", "615652"
//				);
//		buildPost("http://www.lubanyangche.com/sales/wxUser/getHomeAllData.do?sellerUserId=101",
//				"http://www.zhihu.com", "13795247387", "lyc891005"
//				);
		String loginCookie = getLoginCookie("http://www.zhihu.com", "13795247387", "lyc891005");
		System.out.println(loginCookie);
		
		Long gtk = QQUtil.getGTK("@lxG2HhDgq");
		Long bkn = QQUtil.getBkn("n1NOV4H97md6kaQY97RHOhDW28ZTTdmewxWtFPFg2jE_");
		
		//https://www.zhihu.com/api/v4/answers/161296134/favlists?include=data%5B*%5D.updated_time%2Canswer_count%2Cfollower_count%2Ccreator%2Cis_following&offset=0&limit=10
		
		
//		buildPost("http://www.lubanyangche.com/sales/wxUser/selectContainerline2.do?sellerUserId=101");
		
		//JSESSIONID=512CEFFBA0D1CF02BAC64769CFB9C0C4
	}


	/**
	 * 执行get请求
	 * @param url
	 * @return
	 */
	public static String buildGet(String url){
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(url);
		HttpResponse response = null;
		String entityStr = "";
		try {
			response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
		if (entity != null) {
			entityStr = EntityUtils.toString(entity, "UTF-8");
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return entityStr;
	}
	
	
	/**
	 * 执行post请求
	 * 需要添加json请求参数
	 * @param url
	 * @return
	 */
	public static String buildPost(String url, String requestJson){
        DefaultHttpClient httpclient = new DefaultHttpClient();  
        HttpPost httppost = new HttpPost(url);  
        StringEntity entity = null;
        String responseJson = "";
		try {
			entity = new StringEntity(requestJson,"utf-8");
			//解决中文乱码问题    
	        entity.setContentEncoding("UTF-8");    
	        entity.setContentType("application/json");
            httppost.setEntity(entity);  
            HttpResponse response = httpclient.execute(httppost);  
            HttpEntity responseEntity = response.getEntity();  
            if (responseEntity != null) {
            	responseJson = EntityUtils.toString(responseEntity, "UTF-8");
            }
        } catch (Exception e) {  
            e.printStackTrace();  
        }
        return responseJson;
	}
	
	
	/**
	 * 模拟登陆获取cookie
	 * @param url
	 * @param param
	 * @return
	 */
	public static String getLoginCookie(String loginUrl, String name, String password){
		String set_cookie = "";
	 	DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(loginUrl);  
		try {
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("name", name));
			params.add(new BasicNameValuePair("password", password));
			buildEncode(httppost, params);
            HttpResponse response = httpclient.execute(httppost); 
            
            set_cookie = response.getFirstHeader("Set-Cookie").getValue();
            set_cookie = set_cookie.substring(0,set_cookie.indexOf(";"));
        } catch (Exception e) {  
            e.printStackTrace();  
        }
        return set_cookie;
	}
	
	
	
	/**
	 * 执行post请求
	 * @param url
	 * @return
	 */
	public static String buildPost(String url, String loginUrl, String mobile, String code){
		String responseJson = "";
		DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(url);  
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		try {
			buildEncode(httppost, params);
            httppost.setHeader("Cookie", getLoginCookie(loginUrl, mobile, mobile));
            HttpResponse response = httpclient.execute(httppost); 
            HttpEntity responseEntity = response.getEntity();  
            if (responseEntity != null) {
            	responseJson = EntityUtils.toString(responseEntity, "UTF-8");
            	System.out.println(responseJson);
            }
        } catch (Exception e) {  
            e.printStackTrace();  
        }
        return responseJson;
	}


	private static void buildEncode(HttpPost httppost, List<NameValuePair> params) throws UnsupportedEncodingException {
		UrlEncodedFormEntity uefEntity;
		uefEntity = new UrlEncodedFormEntity(params, "UTF-8");
		uefEntity.setContentEncoding("UTF-8");    
		uefEntity.setContentType("application/json");
		httppost.setEntity(uefEntity);
	}
	
	
}

