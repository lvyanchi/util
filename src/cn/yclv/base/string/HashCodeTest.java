package cn.yclv.base.string;

import java.util.HashMap;
import java.util.Map;

public class HashCodeTest {
	public static void main(String[] args) {
//		stringHashCode();
		intHashCode();
	}
	
	
	static void stringHashCode(){
		String a = "1";
		System.out.println(a.hashCode());
	}
	
	
	static void intHashCode(){
		Integer a1 = 1;
		for (Integer i = 0; i < 100; i++) {
			System.out.println(i.hashCode());
		}
	}
	
	
	static void hashMapTest(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("", "");
	}
}
