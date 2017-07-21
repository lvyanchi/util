package cn.yclv.base.util;

import java.lang.reflect.Field;

public class BeanUtils {
	
	public static boolean checkValIsNull(Object obj){
		for (Field f : obj.getClass().getDeclaredFields()) {
		    f.setAccessible(true);
		    try {
				if (f.get(obj) != null) { 
					return false;
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
}
