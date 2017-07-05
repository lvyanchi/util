package cn.yclv.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;


public class HttpUtil {
	
	public static void main(String[] args) throws IOException, SQLException {
//		FileUtil.readFilesAndInsert("E:\\java\\qq_group\\member");
		
//		JdbcUtil.queryAll(conn, "orders");
		
//		List<Group> allGroups = QQUtil.getGroupList(txtJson);
//		QQUtil.insertGroups(allGroups, conn, QQConstrant.INSERT_GROUP_SQL_PSTMT);
		
//		String loginCookie = getLoginCookie("http://www.zhihu.com", "13795247387", "lyc891005");
//		System.out.println(loginCookie);
		
//		Long gtk = QQUtil.getGTK("@lxG2HhDgq");
//		Long bkn = QQUtil.getBkn("n1NOV4H97md6kaQY97RHOhDW28ZTTdmewxWtFPFg2jE_");
		
//		Map<String, String> paramsMap = new HashMap<String, String>();
//		paramsMap.put("gc", "161556918");
//		paramsMap.put("st", "1");
//		paramsMap.put("end", "200");
//		paramsMap.put("sort", "0");
//		paramsMap.put("bkn", "1516650740");
//		
//		Map<String, String> headerMap = new HashMap<String, String>();
//		headerMap.put("Cookie", "RK=lH2biZzOYi; pgv_pvi=9398909952; pgv_si=s5268871168; _qpsvr_localtk=0.19207234714815336; ptisp=ctc; ptcz=b7f05457103eb66c4902ce2622b24220a2e5dacca29905474c26a3a1652af40b; pt2gguin=o0383041699; uin=o0383041699; skey=@ZdDeYuQ27; p_uin=o0383041699; p_skey=D5-fRMGiUOXMwTu6Wml*WHTPwHj7gaDzNhoGW4*vaYk_; pt4_token=k9S2tPZmMYb1HpY8tLYEVkN9hb2hoROr3toqbAwr4oQ_");
//		String responseResult = buildPostOfParam("http://qun.qq.com/cgi-bin/qun_mgr/search_group_members", paramsMap, headerMap);
//		System.out.println(responseResult);
		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("ticket", "aabb");
		String responseResult = buildPostOfParam("http://localhost/customer/third/zzw/validate", paramsMap);
		System.out.println(responseResult);
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
	 * 执行post请求
	 * @param url
	 * @param paramsMap
	 * @return
	 */
	public static String buildPostOfParam(String url, Map<String, String> paramsMap){
		String responseJson = "";
		DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(url);
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		try {
			for (Map.Entry<String, String>  entry: paramsMap.entrySet()) {
				params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
//			buildEncode(httppost, params);
			httppost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
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
	 * 执行post请求
	 * @param url
	 * @param paramsMap
	 * @return
	 */
	public static String buildPostOfParam(String url, Map<String, String> paramsMap, Map<String, String> headerMap){
		String responseJson = "";
		DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(url);
        for (Map.Entry<String, String>  entry: headerMap.entrySet()) {
        	httppost.addHeader(entry.getKey(), entry.getValue());
		}
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		try {
			for (Map.Entry<String, String>  entry: paramsMap.entrySet()) {
				params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
			buildEncode(httppost, params);
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
		UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(params, "UTF-8");
		uefEntity.setContentEncoding("UTF-8");    
		uefEntity.setContentType("application/json");
		httppost.setEntity(uefEntity);
	}
	
	
	/**
	 * 包装httpclient为https形式
	 * @param base
	 * @return
	 */
	public static HttpClient wrapClient(HttpClient base) {
        try {
            SSLContext ctx = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                public void checkClientTrusted(X509Certificate[] arg0, String arg1) {}
                public void checkServerTrusted(X509Certificate[] arg0, String arg1) {}
            };
            ctx.init(null, new TrustManager[] { tm }, null);
            SSLSocketFactory ssf = new SSLSocketFactory(ctx, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            SchemeRegistry registry = new SchemeRegistry();
            registry.register(new Scheme("https", 443, ssf));
            ThreadSafeClientConnManager mgr = new ThreadSafeClientConnManager(registry);
            return new DefaultHttpClient(mgr, base.getParams());
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}

