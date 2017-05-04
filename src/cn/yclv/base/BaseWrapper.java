package cn.yclv.base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.yclv.base.model.User;

public class BaseWrapper {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = sdf.parse("2017-04-18 16:49:49");
			long time = date.getTime();
			System.out.println(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
//		strTest();
//		alwaysFor();
		User user = new User();
	}

	@SuppressWarnings("unused")
	private static void charTest() {
		for (char c = 0; c < 128; c++) {
			if(Character.isJavaIdentifierPart(c)){
				System.out.println(c);
			}
		}
	}

	private static void strTest() {
		for (char c : "lv.yan.chi".toCharArray()) {
			System.out.print(c + "-");
		}
	}
	
	static void alwaysFor(){
		for(;;){
			System.out.println("一直在走吗");
		}
	}
}
