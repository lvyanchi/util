package cn.yclv.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

public class PropHelper {

	public static String loadProp(String path, String key) {
		try {
			Properties prop = new Properties();
			InputStream in = new BufferedInputStream(new FileInputStream(path));
			prop.load(in);
			Iterator<String> it = prop.stringPropertyNames().iterator();
			while (it.hasNext()) {
				String k = it.next();
				if (k.equals(key)) {
					return prop.getProperty(k);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
