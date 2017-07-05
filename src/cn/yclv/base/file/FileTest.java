package cn.yclv.base.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FileTest {
	public static void main(String[] args) {
		File file = new File("C:\\Users\\Administrator\\Desktop\\coupon.txt");
		BufferedReader br;
		StringBuffer sb = new StringBuffer();
		Map<String, String> couponMap = new HashMap<String, String>();
		try {
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader reader = new InputStreamReader(fis);
			br = new BufferedReader(reader);
			String lineText = null;
			while((lineText = br.readLine()) != null){
				String[] result = lineText.split("\t");
				couponMap.put(result[0], result[1]);
			}
			br.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
