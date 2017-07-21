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
		
		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("gc", "245854112");
		paramsMap.put("st", "1");
		paramsMap.put("end", "1000");
		paramsMap.put("sort", "0");
		paramsMap.put("bkn", "415862199");
		
		Map<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Cookie", "RK=lH2biZzOYi; _qpsvr_localtk=0.05784163728124181; pgv_pvi=9110548480; pgv_si=s9757825024; verifysession=h01187ce47ceb06786b22fa68bcb77bf97b7c7ddfeae3ed8f78b4a10bab92fb37fa947055db8a46f0ae; pac_uid=1_383041699; pgv_info=ssid=s6501896064; pgv_pvid=4775467852; o_cookie=383041699; ptisp=ctc; ptcz=1e54129e0f3c60d64337c87c642682aa6b00845096f38ae402edc2cdb2e37b62; pt2gguin=o0383041699; uin=o0383041699; skey=@nYvJqIHTU; p_uin=o0383041699; p_skey=*TFgRACxL2sLJbA1K6zmpgYrtIDAUQjuqJkRqawct-c_; pt4_token=M32fK1mWrScypyfVS18vH3mdOM1TW0gncLfyWmy29Cc_");
		String responseResult = buildPostOfParam("http://qun.qq.com/cgi-bin/qun_mgr/search_group_members", paramsMap, headerMap);
		System.out.println(responseResult);
//		Map<String, String> paramsMap = new HashMap<String, String>();
//		paramsMap.put("ticket", "aabb");
//		String responseResult = buildPostOfParam("http://localhost/customer/third/zzw/validate", paramsMap);
//		System.out.println(responseResult);
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

