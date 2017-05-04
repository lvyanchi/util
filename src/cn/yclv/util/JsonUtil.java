package cn.yclv.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonUtil {
	
	
	/**
	 * 处理读取到的json特殊字符
	 * @param json
	 * @return
	 */
	public static String handleJsonSpecialChar(String json) {
		String pattern = "[^{,:]\"[^},:]";//双引号所在的位置，匹配双引号和前后的符号
		Pattern p = Pattern.compile(pattern);
		Matcher matcher = p.matcher(json);
		while(matcher.find()){
			String group = matcher.group(0);
			String replace = group.replace(group, group.substring(0, 1) + "\\\"" + group.substring(2));
			json = json.replace(group, replace);
		}
		return json;
	}
	
	
	public static String string2Json(String json) {       
	    StringBuffer sb = new StringBuffer ();       
	    for (int i = 0; i < json.length(); i++) {       
	        char c = json.charAt(i);       
	        switch (c) {       
	        case '\"':       
	            sb.append("\\\"");       
	            break;       
	        case '\\':       
	            sb.append("\\\\");       
	            break;       
	        case '/':       
	            sb.append("\\/");       
	            break;       
	        case '\b':       
	            sb.append("\\b");       
	            break;       
	        case '\f':       
	            sb.append("\\f");       
	            break;       
	        case '\n':       
	            sb.append("\\n");       
	            break;       
	        case '\r':       
	            sb.append("\\r");       
	            break;       
	        case '\t':       
	            sb.append("\\t");       
	            break;       
	        default:       
	            sb.append(c);       
	        }  
	    }
	    return sb.toString();   
	}
}
